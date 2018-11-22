/**
 * VM.java
 *
 * Virtual Memory address translation.
 *
 * Given an input parameter, this program extracts
 * the page number and offset. Then reading the byte in
 * the file BACKING_STORE residing at that position.
 *
 * Usage:
 *	java VM <input file>
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Eighth Edition
 * Copyright John Wiley & Sons - 2010. 
 */

package designing;
import java.io.*;

public class VM
{
	private static final int PAGE_TABLE_ENTRIES = 256;
	private static final int NUMBER_OF_FRAMES = 256;
	//private static final int PHYSICAL_MEMORY_SIZE = 256*256;
	private static final int PHYSICAL_MEMORY_SIZE = Frame.FRAME_SIZE * NUMBER_OF_FRAMES;
	private static final int PAGE_SIZE = 256;
	//private static final int NUMBER_OF_FRAMES = PHYSICAL_MEMORY_SIZE / PAGE_SIZE;	
	private static final int TLB_SIZE = 16;

	private File fileName;				/* the file representing the simulated  disk */
	private RandomAccessFile disk = null;	/* the input file of logical addresses */
	private BufferedReader r = null;

	private int virtualAddress;			/* the virtual address being translated */
	private int physicalAddress;			/* the physical address */

	private int pageNumber;				/* virtual page number */
	private int frameNumber;				/* physical frame number */
	private int offset;					/* offset in page/frame */

	private byte value;					/* the value stored at the physical address */

	private int nextFrameNumber;			/* the next available frame number */
	private int nextTLBEntry;			/* the next available entry in the TLB */

	private PageTableEntry[] pageTable;	/* the page table */
	private Frame[] physicalMemory;		/* physical memory (organized in frames) */

	private TLBEntry[] TLB;				/* the TLB */

	private byte[] buffer;				/* the buffer for storing the page from disk */

	private int pageFaults;				/* the number of page faults */
	private int TLBHits;				/* the number of TLB hits */
	private int numberOfAddresses;		/* the number of addresses that were translated */

	/* Comment Here */
        // The means to execute a paging scheme with a TLB for efficiency are producted here. 
        // Everything is initialized to include a page table with entries, a TLB with a given 
        // size, physical memory decicated to serve the necessary frames, and the data structures
        // needed for utility within this paging scheme. 
	public VM() {
		// create the page table
		pageTable = new PageTableEntry[PAGE_TABLE_ENTRIES];
		for (int i = 0; i < PAGE_TABLE_ENTRIES; i++)
			pageTable[i] = new PageTableEntry();

		// create the TLB
		TLB = new TLBEntry[TLB_SIZE];
		for (int i = 0; i < TLB_SIZE; i++)
			TLB[i] = new TLBEntry();

		// allocate the physical memory
		physicalMemory = new Frame[NUMBER_OF_FRAMES];
		for (int i = 0; i < NUMBER_OF_FRAMES; i++)
			physicalMemory[i] = new Frame();

		// initialize the next frame number
		nextFrameNumber = 0;

		// initialize the next available entry in the TLB
		nextTLBEntry = 0;

		// allocate a temporary buffer for reading in from disk
		buffer = new byte[PAGE_SIZE];

		// initialize the statistics counters
		pageFaults = 0;
		TLBHits = 0;
	}
	

	/**
	 * Extract the page number.
	 */
	public int getPageNumber(int virtualAddress) {
		return  (virtualAddress & 0x0000ff00) >> 8;
	}

	/**
	 * Extract the offset.
	 */
	public int getOffset(int virtualAddress) {
		return (virtualAddress & 0x000000ff);
	}

	/* Comment Here */
        // Grabs the next frame avaiable by returning the a frame number 
        // that is an increment offset from the current. 
	public int getNextFrame() {
		return nextFrameNumber++;
	}

	/* Comment Here */
        // Looks to see if frame number is in the TLB, ultimately 
        // determining perform a page fault. 
	public int checkTLB(int pageNumber) {
		int frameNumber = -1;

		/* Comment Here */
                // If page has hits than it is noted. 
		for (int i = 0; i < TLB_SIZE; i++) {
			if (TLB[i].checkPageNumber(pageNumber)) {
				frameNumber = TLB[i].getFrameNumber();
				TLBHits++;

				break;
			}
		}

		return frameNumber;
	}

	/**
	 * Maps a page number to its frame number in the TLB.
	 */
	public void setTLBMapping(int pageNumber, int frameNumber) {
		// establish the mapping
		TLB[nextTLBEntry].setMapping(pageNumber, frameNumber);

		/* Comment Here */
                // Makes room for the next TLB entry. 
		nextTLBEntry = (nextTLBEntry + 1) % TLB_SIZE;
	}
		

	/**
	 * Determine the physical address of a given virtual address
	 */
	public int getPhysicalAddress(int virtualAddress) throws java.io.IOException {
		// determine the page number
		pageNumber = getPageNumber(virtualAddress);
		//System.out.println("Page number = " + pageNumber);

		// determine the offset
		offset = getOffset(virtualAddress);
		//System.out.println("offset = " + offset);

		/* Comment Here */
                // If there is a miss than a page fault routine begins otherwise 
                // process moves on. 
		if ( (frameNumber = checkTLB(pageNumber)) == -1 ) {  /** TLB Miss **/
			// Check the page table
			if (pageTable[pageNumber].getValidBit() == true) {
				/** Page Table Hit **/
				frameNumber = pageTable[pageNumber].getFrameNumber();
			}
			else { 	/** Page Fault **/

				// get a free frame
				frameNumber = getNextFrame();

				/* Comment Here */
                                // Page fault routine happens by getting necessary page 
                                // in the backing store to swap out current. The current
                                // gets stored in the buffer. 
				// seek to the appropriate page in the BACKING_STORE file
				disk.seek(pageNumber * PAGE_SIZE);
				// read in a page-size chunk from BACKING_STORE
				// into a temporary buffer
				disk.readFully(buffer);

				// copy the contents of the buffer 
				// to the appropriate physical frame
				physicalMemory[frameNumber].setFrame(buffer);

				// now establish a mapping
				// of the frame in the page table
				pageTable[pageNumber].setMapping(frameNumber);

				pageFaults++;
				//System.out.print(" * ");
			}

			// lastly, update the TLB
			setTLBMapping(pageNumber, frameNumber);	
		}

		//System.out.println("Frame = " + frameNumber);

		// construct the physical address
		physicalAddress = (frameNumber << 8) + offset;

		return physicalAddress;
	}

	/**
	 * Returns the signed byte value at the specified physical address.
	 */
	public byte getValue(int physicalAddress) throws java.io.IOException {
   
		/* Comment Here */
                // The actual value of the physcial address is returned here via a bitmask 
                // method. Address from physical memory is read by shifting its bit over enough
                // to reveal its contents via anouther bit wise operation. 
		return physicalMemory[((physicalAddress & 0x0000ff00) >> 8)].readWord(physicalAddress & 0x000000ff);
	}

	/** 
	 * Generate statistics.
	 */
	public void generateStatistics() {
		System.out.println("Number of Translated Addresses = " + numberOfAddresses);
		System.out.println("Page Faults = " + pageFaults);
		System.out.println("Page Fault Rate = " + ( (float) pageFaults) / numberOfAddresses);
		System.out.println("TLB Hits = " + TLBHits);
		System.out.println("TLB Hit Rate = " + ( (float) TLBHits) / numberOfAddresses);
	}

	/**
	 * The primary method that runs the translation of logical to physical addresses.
	 */
	public void runTranslation(String inputFile) throws java.io.IOException {

		try {
			r = new BufferedReader(new FileReader(inputFile));
               fileName = new File("BACKING_STORE");
               disk = new RandomAccessFile(fileName, "r");
			String stringValue;
			
			while ( (stringValue = r.readLine()) != null) {
				// read in the virtual address
				virtualAddress = Integer.parseInt(stringValue);

				// obtain the corresponding physical address
				physicalAddress = getPhysicalAddress(virtualAddress);

				numberOfAddresses++;
			
				// get the value stored at the physical address	
				value = getValue(physicalAddress);
				
				System.out.println("Virtual address: " + virtualAddress + " Physical address: " + physicalAddress + " Value: " + value);
			}

			generateStatistics();
		}
		catch (java.io.IOException ioe) {
			System.err.println(ioe);
		}
		finally {
			disk.close();
			r.close();
		}
	}

	public static void main(String[] args) throws java.io.IOException {
		if (args.length != 1) {
			System.err.println("Usage: java VM <input file>");
			System.exit(-1);
		}
		else {
			VM vm = new VM();
			vm.runTranslation(args[0]);
		}
	}
}

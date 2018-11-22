/**
 *	Address.java
 *
 * 	Usage:
 *		java Address <page size> <address>
 *
 * 	For the given page size and virtual address, 
 * 	this program reports the page number and offset.
 */

package addresses;

public class Address
{
	public static final int ADDRESS_SIZE = 32;

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Usage: java Address <page size> <address>");
			System.exit(0);
		}
      /* Comment Here */
      // Page size variable is initialized to be as big as specified 
      // in the given command line argument. Address is given in the same manner.
      
		int pageSize = Integer.parseInt(args[0].trim());
		int address = Integer.parseInt(args[1].trim());

		int pageBits = 0;
		

		int pageMask = 0;
		int offsetMask = 0;

		/* Comment Here */
                // A given page size is handled by assigning it a certain number
                // of bits depending on its size. The offsetMask and page mask 
                // are also used to give each page "identity" so to speak. Page 
                // mask indicates the page number while offset associsates to the 
                // pages offset to form a logical memory address. The larger the 
                // page the more bits are assigned to increase the number of possible
                // values to be stored in the page since it has more capacity. 
      switch (pageSize) {
			case 1024:
				pageBits = 10;
				offsetMask = 0x000003ff;
				pageMask = 0xfffffc00;
				break;
			case 2048: 	
				pageBits = 11;
				offsetMask = 0x000007ff;
				pageMask = 0xfffff800;
				break;
			case 4096:
				pageBits = 12;
				offsetMask = 0x00000fff;
				pageMask = 0xfffff000;
                break;
            case 8192:
            	pageBits = 13;
            	offsetMask = 0x00001fff;
            	pageMask = 0xffffe000;
                break;
            case 16384:
            	pageBits = 14;
            	offsetMask = 0x00003fff;
            	pageMask = 0xffffcfff;
            	break;
		}
		

		int pageNumber = (address & pageMask) >> pageBits;
		int offset = (address & offsetMask);

      /* Comment Here */	
      // For a given address, its contents are printed to screen indicating what its assigned page number and offset is 
      // in terms of a bit mask. 
      System.out.println("For address " + address + " page number = " + pageNumber + " offset = " + offset);

	}
}

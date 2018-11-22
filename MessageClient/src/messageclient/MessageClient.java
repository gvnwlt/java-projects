/**
 * Message client.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Eighth Edition
 * Copyright John Wiley & Sons - 2010.
 */
 
package messageclient; 

import java.net.*;
import java.io.*;

public class MessageClient
{
	public static final int PORT = 6100;
	public static final String host = "127.0.0.1";

	public static void main(String[] args) throws IOException {
		Socket sock = null;
		
		if (args.length != 1) {
			System.err.println("Usage: java MessageClient <message>");
			System.exit(0);
		}
		
		try {
         /* Comment Here */
         // Within this try block, a socket object is created with the host ip and port number passed
         // as arguments in the constructor. Essentially this block prints out to a data stream from a socket. 
         // It prints out what the first argument value is (the name of the program it self). It also establishes
         // what port and ip address it will be sending messages to. 
			sock = new Socket(host, PORT);

			PrintWriter pout = new PrintWriter(sock.getOutputStream(),true);

			pout.println(args[0]);

			/* Comment Here */
                        // Creates an object input stream to read in an input stream. Once the stream is read,
                        // It is stored in a Message Class type, typecast to be a Message type. The create message object 
                        // thet read in the input stream, invokes a method in the print statement that gets the character count. 
                        // The next line does the same only printing out the digit count instead. 
			ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());

			Message message = (Message) ois.readObject();
			System.out.println(message.getCharacterCount());
			System.out.println(message.getDigitCount());
		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
		catch (ClassNotFoundException cnfe) {
			System.err.println(cnfe);
		}
          finally {
          	sock.close();
          }
	}
}

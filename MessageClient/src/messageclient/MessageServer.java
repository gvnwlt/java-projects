/**
 * Message server.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Eighth Edition
 * Copyright John Wiley & Sons - 2010.
 */

package messageclient; 
 
import java.net.*;
import java.io.*;

public class MessageServer
{
	public static final int PORT = 6100;

	public static void main(String[] args) {
		Socket client = null;
		ServerSocket sock = null;
		BufferedReader reader = null;

		try {
			sock = new ServerSocket(PORT);
			/* Comment Here */
                        // The while loop runs to coninuously accept incoming socket messages. Once 
                        // the message is received it is read into a buffered reader, the buffered reader
                        // reads in strings instead of characters. The buffered reader object then gets passed
                        // to a message object that reads a line from the reader.
			while (true) {
				client = sock.accept();

				reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

				Message message = new MessageImpl(reader.readLine());

				/* Comment Here */
                                // The message object reference variable invokes a method that sets the counter 
                                // variables for letters and digits. 
				message.setCounts();

				/* Comment Here */
                                // An object output stream is created to write out a message into 
                                // the output stream so that a client can read the stream in on its
                                // socket. After the message is sent the socket is closed and then
                                // the loop starts back up again listening and accepting incoming streams 
                                // from the client.
            ObjectOutputStream soos = new ObjectOutputStream(client.getOutputStream());
				soos.writeObject(message);
				System.out.println("wrote message to the socket");

				client.close();
			}
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
}

/**
 * Message server.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Eighth Edition
 * Copyright John Wiley & Sons - 2010.
 */
 
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
			while (true) {
				client = sock.accept();

				reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

				Message message = new MessageImpl(reader.readLine());

				/* Comment Here */
				message.setCounts();

				/* Comment Here */
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

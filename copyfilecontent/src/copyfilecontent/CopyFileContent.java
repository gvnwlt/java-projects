package copyfilecontent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileContent {

	public static void main(String[] args) {

                /* 
                * Creates a file object called "sourceFile" that recieves 
                * a string as an argument in the constructor for a file located in, 
                * or that should be located in, the same directory as the class file. 
                * This file object reads in the file passed as an argument. 
                */
		File sourceFile = new File("file1.txt");

		/*
                * Another file object created as a file object. This file object
                * will be used for the purpose of outputting a file. 
                */
		File destFile = new File("file2.txt");
		
		/* 
                * This condtional checks to see if the specified file exists
                * within the current directory. If it does not exist, 
                * then the try/catch block will execute the method inherited 
                * from the File class to create a new file with the name given 
                * from the string passed in the initial constructor arugment. If
                * the file does exist, then nothing is done here. The catch block
                * will execute if an IOException occurs, handling it with a 
                * printStackTrace that the user can then use to debug the situation.
                */
		if (!destFile.exists()) {
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		InputStream input = null;
		OutputStream output = null;

		try {

			/* 
                        * The refence variable to the InputStream class
                        * creats new object that reads a FileInputStream
                        * from sourceFile. This source file is the file object created
                        * earlier. 
                        */
			input = new FileInputStream(sourceFile);

			/*
                        * The refence variable to the OutputStream class
                        * creats new object that writes out a FileOutputStream
                        * using the destFile object. 
                        */
			output = new FileOutputStream(destFile);

			byte[] buf = new byte[1024];
			int bytesRead;
                        
                        /*
                        * While still reading stuff...
                        * output stuff read into new file ("file2"). 
                        */
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {

				if (null != input) {
					input.close();
				}
				
				if (null != output) {
					output.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
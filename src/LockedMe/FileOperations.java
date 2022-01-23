/**
 * 
 */
package LockedMe;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author avikgoon
 *
 */
public class FileOperations {
	String fileName;

	public void printFileNames(File[] a, int i, int lvl, List<String> fileNames){
		
		// base case of the recursion
		// i == a.length means the directory has
		// no more files. Hence, the recursion has to stop
		if (i == a.length) {
			return;
		}
		// checking if the encountered object is a file or not
		if (a[i].isFile()) {
			String fileName = a[i].getName();
			fileNames.add(fileName);
			// System.out.println(fileName);
		}
		// recursively printing files from the directory
		// i + 1 means look for the next file
		printFileNames(a, i + 1, lvl, fileNames);
	}

	public void getFileName(BufferedReader inp) {
		System.out.println("Enter a file name: ");
		try {
			this.fileName = inp.readLine();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void createNewFile(BufferedReader inp, String path) throws IOException, InterruptedException {

		getFileName(inp);
		try {
			String fullPath = path + "/" + this.fileName;
			File newFile = new File(fullPath);
			if (newFile.createNewFile())
				System.out.println("File created: " + newFile.getName());
			else
				throw new Exception("File already exists.");

		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		} finally {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("\n\nPress enter/return key to continue...");
			System.in.read();
		}

	}

	public void deleteFile(BufferedReader inp, String path) throws IOException {
		getFileName(inp);
		String fullPath = path + "/" + this.fileName;
		try {
			File fileToBeDeleted = new File(fullPath);
			if (fileToBeDeleted.delete()) {
				System.out.println("File deleted successfully");
			} else
				throw new Exception("File Not Found...🔎");
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		} finally {
			System.out.println("\n\nPress enter/return key to continue...");
			System.in.read();
		}

	}
	
	public void doFileExist( BufferedReader inp, String path) throws IOException, InterruptedException{
		getFileName(inp);
		String fullPath = path + "/" + this.fileName;
		System.out.println( "\n👀 Serching..Please Wait....... \n" );
		TimeUnit.SECONDS.sleep(2);
		try {
			File file = new File(fullPath);
			if ( file.exists() ) {
				System.out.println("File found in system..");
			} else
				throw new Exception("File Not Found...🔎");
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		} finally {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("\n\nPress enter/return key to continue...");
			System.in.read();
		}
	}

}

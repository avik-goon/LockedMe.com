/**
 * 
 */
package LockedMe;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author avikgoon
 *
 */
public class FileOperations {
	String fileName;
	public void printFileNames(File[] a, int i, int lvl, ArrayList<String> fileNames) {
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
			//System.out.println(fileName);
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

	public void createNewFile(BufferedReader inp, String path) throws IOException {
		
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
			System.out.println("\n\nPress enter/return key to continue...");
			System.in.read();
		}

	}
	
	public void deleteFile(BufferedReader inp, String path) throws IOException {
		
	}

}

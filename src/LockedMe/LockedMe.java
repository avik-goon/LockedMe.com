package LockedMe;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class LockedMe {
	public static void main(String args[]) throws IOException {
		Scanner input = new Scanner(System.in);
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		String path = "././LockedMeLib";
		File fileObj = new File(path);
		FileOperations fileoperations = new FileOperations();
		int option = 0;
		// display welcome message
		new WelcomeMessage().showWellcomeGraphic();

		// ask user good name, then proceed
		String username = (String) new UserDetails(input).getUserName();
		System.out.println("Hi,🙋 " + username);

		mainmenu: do {
			try {
				System.out.println("Choose any option from the following: 👇");
				System.out.println("1.👀 Show all Files");
				System.out.println("2.➡️ More File Operations");
				System.out.println("3.🚪 Exit");
				option = input.nextInt();
				switch (option) {
				case 1:
					// create new file
					if (fileObj.exists() && fileObj.isDirectory()) {
						final List<String> fileNames = new ArrayList<String>();

						File[] listofFiles = fileObj.listFiles();
						System.out.println( "\n⏳ Loading..Please Wait....... \n" );
						TimeUnit.SECONDS.sleep(2);
						System.out.println("\n---- 🗂 ----\n");

						fileoperations.printFileNames(listofFiles, 0, 0, fileNames);

						// convert all file name to lower case
						List<String> result = fileNames.stream().map(String::toLowerCase).collect(Collectors.toList());
						// sort file name in ascending order
						Collections.sort(result);
						// convert list to string
						String listOfFiles = String.join(",\n", result);

						System.out.println(listOfFiles);
						System.out.println("\n\nThat's it...\nPress enter/return key to continue...");
						System.in.read();
					} else
						throw new FileNotFoundException("The path you given is invalid");
					break;

				case 2:
					int submenuOptionNumber = new MoreOptions(input).createMoreFileOptions();
					submenu: while (submenuOptionNumber > 0) {
						if (submenuOptionNumber == 1) {
							// create a new file
							fileoperations.createNewFile(inp, path);

							// calling sub-menu again
							submenuOptionNumber = new MoreOptions(input).createMoreFileOptions();
							continue submenu;
						} else if (submenuOptionNumber == 2) {
							// delete a existing file
							fileoperations.deleteFile(inp, path);
							// calling sub-menu again
							submenuOptionNumber = new MoreOptions(input).createMoreFileOptions();
							continue submenu;
						} else if (submenuOptionNumber == 3) {
							// search for a file
							fileoperations.doFileExist(inp, path);
							// calling sub-menu again
							submenuOptionNumber = new MoreOptions(input).createMoreFileOptions();
							continue submenu;
						} else
							continue mainmenu; // going back to main menu
					}
					break;
				case 3:
					input.close();
					System.out.println("Good Bye ..🙋");
					System.exit(0);

				default:
					throw new IllegalArgumentException(
							"Unexpected value: " + option + "\nProgram will terminate now...");
				}
			} catch (Exception e) {
				System.err.println(e.getLocalizedMessage());
				System.out.println("Good Bye ..🙋");
				input.close();
				System.exit(0);
			}

		} while (true);

	}
}

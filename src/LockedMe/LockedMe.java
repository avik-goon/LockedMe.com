package LockedMe;

import java.io.*;
import java.util.Scanner;

public class LockedMe {
	public static void main(String args []) throws IOException {
		Scanner input = new Scanner(System.in);
		int option = 0;
		//display welcome message
		new WelcomeMessage().showWellcomeGraphic();
		
		//ask user good name, then proceed
		String username = (String) new UserDetails(input).getUserName();		
		System.out.println("Hi,🙋 "+username);
		
		mainmenu: do {	
			try {
			System.out.println("Choose any option from the following: 👇");
			System.out.println("1.👀 Show all Files");
			System.out.println("2.➡️ More File Operations");
			System.out.println("3.🚪 Exit");
			option = input.nextInt();
			switch (option) {
				case 1:
					
					break;
				
				case 2:
					int submenuOptionNumber = new MoreOptions(input).createMoreFileOptions();
					if( submenuOptionNumber == 1 ) {
						// create a new file
						//submenuOptionNumber = new MoreOptions(input).createMoreFileOptions();
					}else if( submenuOptionNumber == 2 ) {
						// delete a existing file
					} else if( submenuOptionNumber == 3 ) {
						// search for a file
					} else continue mainmenu;
				case 3:
					input.close();System.out.println("Good Bye ..🙋");
					System.exit(0);
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + option+"\nProgram will terminate now...");
				}
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
				input.close();
				System.out.println("Good Bye ..🙋");
				System.exit(0);
			}
		}while(true);
		
	}
}

package LockedMe;

import java.io.*;
import java.util.Scanner;

public class LockedMe {
	public static void main(String args []) throws IOException {
		Scanner input = new Scanner(System.in);
		int option = 0;
		System.out.println("*****************************************");
		System.out.println("*\t\t\t\t\t*");	
		System.out.println("*\t\t\t\t\t*");	
		System.out.println("*\t\t\t\t\t*");	
		System.out.println("*\t ------WELCOME TO------\t\t*");	
		System.out.println("*\t\tLOCKEDME\t\t*");				
		System.out.println("*\t\t\t\t\t*");	
		System.out.println("*\t\t\t\t\t*");	
		System.out.println("*****************************************");
		
		System.out.println("------------------------------------------");
		System.out.println("💻Developer Name: Avik Goon");
		System.out.println("📪️️Developer Email: goonavik@lockedme.com");
		System.out.println("------------------------------------------");
		
		//ask user good name, then proceed
		String username = (String) new UserDetails(input).getUserName();		
		System.out.println("Hi,🙋 "+username);
		
		do {
			try {
			System.out.println("Choose any option from the following: 👇");
			System.out.println("1. Show all Files");
			System.out.println("2. More File Operations");
			System.out.println("3. Exit");
			option = input.nextInt();
				switch (option) {
				case 1:
					
					break;
				
				case 2:
					
					break;
				
				case 3:
					System.out.println("Good Bye ..");
					System.exit(0);
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + option);
				}
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}while( option != 3 );
		
		
		
		input.close();
		
	}
}

/**
 * 
 */
package LockedMe;

import java.util.Scanner;

/**
 * @author avikgoon
 *
 */
public class MoreOptions {
	
	Scanner sc;
	/**
	 * receive scanner object
	 */
	public MoreOptions( Scanner sc ) {
		this.sc = sc;
	}
	public int createMoreFileOptions() {
		System.out.println("\n\n1.📎 Add a new file");
		System.out.println("2.✂️ Delete a file");
		System.out.println("3.🧐 Search for a file");
		System.out.println("4.🔙 Back To Main Menu");
		int option = sc.nextInt();
		if( option > 4 ) {
			System.out.println("Please choose a valid option");
			createMoreFileOptions();
		}
		return option;
	}
}

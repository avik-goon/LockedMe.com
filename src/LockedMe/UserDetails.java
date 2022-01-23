/**
 * 
 */
package LockedMe;

import java.util.Scanner;

/**
 * @author avikgoon
 *
 *	This class gets the user information
 * 
 * @method getUserName()
 * ask user to enter his/her name
 * 
 */
public class UserDetails {
	Scanner sc;
	public UserDetails(Scanner sc2) {
		this.sc = sc2;
		
	}
	
	public String getUserName() {
		System.out.println("\nHi, What should I call You?\n");
		String name = sc.nextLine();
		return (name);
	}
}

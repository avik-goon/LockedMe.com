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
 * 
 */
public class UserDetails {
	
	public String getUserName() {
		Scanner sc = new Scanner(System.in);
		String name;
		System.out.println("\nHi, What should I call You?\n");
		name = sc.nextLine();
		sc.close();
		return name;
	}
}

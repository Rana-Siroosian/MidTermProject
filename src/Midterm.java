import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * 
 *@author RanaSiroosian&JeannieMcCarthy
 *
 */
public class Midterm {

	public static void main(String[] args) throws Exception {
		ClubArt.displayGreeting("FITNESS CLUB");
//		ClubArt.displayClubName("R A N A");
		printMenu();
	}
	
	public static void printMenu() {
		
		String [] menu = {"Add Member", "Check In Member", "Generate Invoice", 
				"Remove member", "Quit"};
		System.out.println("**************************************************"
				+ "********************************************************************************\n");
		for (int i = 0; i < menu.length; i++) {
			System.out.println((i+1) + ". " + menu[i]);
		}
		}
	}
	

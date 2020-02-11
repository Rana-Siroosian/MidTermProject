import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 *@author RanaSiroosian&JeannieMcCarthy
 *
 */
public class Midterm {

	public static void main(String[] args) throws Exception {
		
		Scanner scnr = new Scanner (System.in);
		ClubArt.displayGreeting("FITNESS CLUB");
//		ClubArt.displayClubName("R A N A");
//		List<Member> member = new ArrayList();
		
 		List<Constant> constant = new ArrayList();
		List<Flexible> flexible = new ArrayList();
		printMenu(constant, flexible, scnr);

		
	}
	
	public static void printMenu(List<Constant> constant,List<Flexible> flexible,Scanner scnr) {
		
		String [] menu = {"Add Member", "Check In Member", "Generate Invoice", 
				"Remove member", "Quit"};
		System.out.println("**************************************************"
				+ "********************************************************************************\n");
		for (int i = 0; i < menu.length; i++) {
			System.out.println((i+1) + ". " + menu[i]);
			
		}
		int choice = Validator.getInt(scnr, "What would you like to do? (choose by number) ", 1, 5);
		System.out.println();
		
		switch (choice) {
		
		case 1 :
			System.out.println("Is this member is constant?");
			String yesOrNo = Validator.yesOrNo(scnr);
			if (yesOrNo.equalsIgnoreCase("y")) {
				addMember1(constant,scnr);
				break;}
			else {
				addMember2(flexible,scnr);
				break;
			}
		case 2 : 
			
		}
	}
	
	public static List<Constant> addMember1(List<Constant> constant,Scanner scnr) {
		
		String memberName = Validator.getString(scnr, "Please enter member name: ");
		int memberId = Validator.getInt(scnr, "Please enter member Id: ");
		double weight = Validator.getDouble(scnr, "Please enter member's weight: ");
		String clubName = Validator.getString(scnr, "Please enter the club name: ");
		constant.add(new Constant( memberId, memberName,weight, clubName));
		return constant;
		
	}
	
	public static  List<Flexible> addMember2( List<Flexible> flexible,Scanner scnr){
		String memberName = Validator.getString(scnr, "Please enter member name: ");
		int memberId = Validator.getInt(scnr, "Please enter member Id: ");
		double weight = Validator.getDouble(scnr, "Please enter member's weight: ");
		 flexible.add(new Flexible(memberName, memberId, weight));
		 return flexible;

	}
}
	

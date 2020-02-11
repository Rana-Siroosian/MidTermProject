import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
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
//		String [] clubNames = {"Dumbell Paradise", "Oxygen360" , "Crazy CrossFit", "Run With It",
//				"Tred Lightly", "Spin Me Right Round"};
		
 		List<Constant> constant = new ArrayList<>();
		List<Flexible> flexible = new ArrayList<>();
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
			checkIn(scnr);
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
	
	public static void checkIn(Scanner scnr) {
		Flexible flexible = new Flexible("Jeannie", 3, 131);
		
		List<Club> clubs = new ArrayList<>(Arrays.asList(new Club("Dumbell Paradise", "123 Main Street"),
				new Club("Oxygen360" , "345 Main St."), new Club("Crazy CrossFit", "678 Main St."),
				new Club("Run With It", "123 Runna Way"), new Club("Tread Lightly", "777 Stomp Ct."),
				new Club("Spin Me Right Round", "1111 Inna Cr.")));
		for (int i = 0; i < clubs.size(); i++) {
			System.out.println((i+1) + ". " + clubs.get(i));

		}
		int club = Validator.getInt(scnr, "Which club the member would like to check in? ", 1, 6)-1;
		flexible.checkIn(clubs.get(club));
		System.out.println(flexible.points);
		
	}
}
	

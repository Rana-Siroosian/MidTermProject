import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 *@author RanaSiroosian&JeannieMcCarthy
 *
 */
public class Midterm {
	public static FileHelper<Member> fileHelper = new FileHelper<Member>("MembersTextFile",
			new MemberLineConverter());
	public static void main(String[] args) throws Exception {
		
		Scanner scnr = new Scanner (System.in);
		ClubArt.displayGreeting("FITNESS CLUB");
		System.out.println("**************************************************"
				+ "********************************************************************************\n");
//		ClubArt.displayClubName("R A N A");
//		List<Member> member = new ArrayList();
//		String [] clubNames = {"Dumbell Paradise", "Oxygen360" , "Crazy CrossFit", "Run With It",
//				"Tred Lightly", "Spin Me Right Round"};
		
 		List<Constant> constant = new ArrayList<>();
		List<Flexible> flexible = new ArrayList<>();
		printMenu(constant, flexible, scnr);

		System.out.println("Thank you, Goodbye!");
	}
	
	
	
	public static void printMenu(List<Constant> constant,List<Flexible> flexible,Scanner scnr) {

		String [] menu = {"Add Member", "Check In Member","Display Member Information", "Generate Invoice", 
				"Remove member", "Quit"};
		
		for (int i = 0; i < menu.length; i++) {
			System.out.println((i+1) + ". " + menu[i]);
			
		}
		System.out.println("---------------------------------------------");
		int choice = Validator.getInt(scnr, "\nWhat would you like to do? (choose by number): ", 1, 6);
		System.out.println();
		
		switch (choice) {
		
		case 1 :
			System.out.println("Is this member a constant member?");
			String yesOrNo = Validator.yesOrNo(scnr);
			if (yesOrNo.equalsIgnoreCase("y")) {
				addMember1(constant,scnr);
				printMenu(constant, flexible, scnr);

				break;}
			else {
				addMember2(flexible,scnr);
				printMenu(constant, flexible, scnr);

				break;
			}
		case 2 : 
			CheckIn.checkIn(scnr);
			printMenu(constant, flexible, scnr);

			break;
		
		case 3: 
			displayMember.displayMemberInfo();
			printMenu(constant, flexible, scnr);
			break;
			
		case 4 :
			GenerateMemInvoice.generateInvoice(scnr);
			printMenu(constant, flexible, scnr);
			break;
		case 5 : 
			RemoveMem.removeMember(scnr);
			printMenu(constant, flexible, scnr);
			break;
			
		case 6 :
			break;
		}
		
	}
	
	public static List<Constant> addMember1(List<Constant> constant,Scanner scnr) {
		
		String memberName = Validator.getString(scnr, "Please enter member name: ");
		int memberId = Validator.getInt(scnr, "Please enter member Id: ");
		double weight = Validator.getDouble(scnr, "Please enter member's weight: ");
		//get Club
		System.out.println("\nPlease choose a club (by number) from the list below: ");
		Club.showClubs();

		int club = Validator.getInt(scnr, "", 1, 6)-1;
		Club clubName = Club.getClubList().get(club);
		//String clubName = Validator.getString(scnr, "Please enter the club name: ");
		LocalDateTime now = LocalDateTime.now();
//		System.out.println(now.getHour());
		double fee = 19.99;

		if (now.getHour() > 12 && now.getHour()<22) {
			System.out.println("Woohoo, You are eligible for discount and we will take $10 off of your total.");
			fee -=10.0;
		}
		fileHelper.append(new Constant(memberId, memberName, weight, fee,clubName));
		System.out.println("\nMember is added.");
		System.out.println("---------------------------------------------");

		return constant;
	}
	
	public static  List<Flexible> addMember2( List<Flexible> flexible,Scanner scnr){
		
		
		LocalDateTime now = LocalDateTime.now();
//		System.out.println(now.getHour());
		
		String memberName = Validator.getString(scnr, "Please enter member name: ");
		int memberId = Validator.getInt(scnr, "Please enter member Id: ");
		double weight = Validator.getDouble(scnr, "Please enter member's weight: ");
		double fee = 44.44;
		if (now.getHour() > 12 && now.getHour()<18) {
			System.out.println("Woohoo, You are eligible for discount and we will take 10$ off of your total.");
			fee -=10.0;
		}
		int points = 0;

		fileHelper.append(new Flexible(memberId, memberName, weight,fee,points));
		System.out.println("\nMember is added.");
		System.out.println("---------------------------------------------");

		 return flexible;

	}
	


}
	

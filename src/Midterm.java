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
		
		//Here's where all the good stuff happens:
		printMenu(scnr);

		System.out.println("Thank you, Goodbye!");
	}
	
	
	
	public static void printMenu(Scanner scnr) {

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
			
			if (AddMember.displayMembershipOptions(scnr)) {
				AddMember.addMember1(scnr);
				printMenu(scnr);

				break;}
			else {
				AddMember.addMember2(scnr);
				printMenu(scnr);

				break;
			}
		case 2 : 
			CheckIn.checkIn(scnr);
			printMenu(scnr);

			break;
		
		case 3: 
			displayMember.displayMemberInfo();
			printMenu(scnr);
			break;
			
		case 4 :
			GenerateMemInvoice.generateInvoice(scnr);
			printMenu(scnr);
			break;
		case 5 : 
			RemoveMem.removeMember(scnr);
			printMenu(scnr);
			break;
			
		case 6 :
			break;
		}
	}
}
	

import java.util.Scanner;

/**
 * 
 * @author RanaSiroosian&JeannieMcCarthy
 *
 */
public class Midterm {
	public static FileHelper<Member> fileHelper = new FileHelper<Member>("MembersTextFile", new MemberLineConverter());

	public static void main(String[] args) throws Exception {

		Scanner scnr = new Scanner(System.in);

		// Display cool Ascii art greeting:
		ClubArt.displayGreeting("FITNESS CLUB");
		boolean loop = true;
//		ClubArt.displayClubName("R A N A");
		int choice = printMenu(scnr);

		do {
		// Print menu options and get menu selection from user, then switch it up:
		switch (choice) {

		case 1:
			//Check to see what kind of Membership the person wants, different add methods for different memberships
			if (AddMember.membershipOptions(scnr)) {
				AddMember.addMember1(scnr);
				choice =printMenu(scnr);
				break;
			} else {
				AddMember.addMember2(scnr);
				choice =printMenu(scnr);
				break;
			}
		case 2:
			
			CheckIn.checkIn(scnr);
			choice =printMenu(scnr);
			break;

		case 3:
			
			displayMember.displayMemberInfo();
			choice =printMenu(scnr);
			break;

		case 4:
			
			GenerateMemInvoice.generateInvoice(scnr);
			choice =printMenu(scnr);
			break;
			
		case 5:
			
			RemoveMem.removeMember(scnr);
			choice =printMenu(scnr);
			break;

		case 6:
			loop = false;
			break;
		}
		}while (loop);
		System.out.println("Thank you, Goodbye!");
	}

	public static int printMenu(Scanner scnr) {
		
		//Menu options in String array:
		String[] menu = { "Add Member", "Check In Member", "Display Member Information", "Generate Invoice",
				"Remove member", "Quit" };
		
		//loop through to display them nicely:
		for (int i = 0; i < menu.length; i++) {
			System.out.println((i + 1) + ". " + menu[i]);
		}
		System.out.println("---------------------------------------------");
		
		//Get user Selection
		int choice = Validator.getInt(scnr, "\nWhat would you like to do? (choose by number): ", 1, 6);
		System.out.println();
		return choice;
	}
}

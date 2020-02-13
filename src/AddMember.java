import java.time.LocalDateTime;
import java.util.Scanner;

public class AddMember {
	public static FileHelper<Member> fileHelper = new FileHelper<Member>("MembersTextFile", new MemberLineConverter());

	public static void addMember1(Scanner scnr) {

		// Enter member info
		String memberName = Validator.getString(scnr, "Please enter member name: ");
		int memberId = Validator.getInt(scnr, "Please enter member Id: ");
		double weight = Validator.getDouble(scnr, "Please enter member's weight: ");

		// Assign a Club to a member
		System.out.println("\nPlease choose a club (by number) from the list below: ");
		Club.showClubs();
		int club = Validator.getInt(scnr, "", 1, 6) - 1;
		Club clubName = Club.getClubList().get(club);

		// Give Discount between noon and 8pm
		double fee = 19.99;
		LocalDateTime now = LocalDateTime.now();
		if (now.getHour() > 12 && now.getHour() < 20) {
			System.out.println("Woohoo, You are eligible for discount and we will take 10$ off of your total.");
			fee -= 10.0;
		}
		
		//create the member
		fileHelper.append(new Constant(memberId, memberName, weight, fee, clubName));
		System.out.println("\nMember is added.");
		System.out.println("---------------------------------------------");
	}

	public static void addMember2(Scanner scnr) {
		
		//Enter Member Info
		String memberName = Validator.getString(scnr, "Please enter member name: ");
		int memberId = Validator.getInt(scnr, "Please enter member Id: ");
		double weight = Validator.getDouble(scnr, "Please enter member's weight: ");
		int points = 0;
		
		//Give Discount between noon and 8pm
		LocalDateTime now = LocalDateTime.now();
		double fee = 44.44;
		if (now.getHour() > 12 && now.getHour() < 18) {
			System.out.println("Woohoo, You are eligible for discount and we will take 10$ off of your total.");
			fee -= 10.0;
		}
		
		//Write to file
		fileHelper.append(new Flexible(memberId, memberName, weight, fee, points));
		System.out.println("\nMember is added.");
		System.out.println("---------------------------------------------");
	}
	
	public static boolean displayMembershipOptions(Scanner scnr) {
		System.out.println("Here are our membership options:\n");
		System.out.println(String.format("%-40s%-40s", "Single Club Membership", "Flexible Membership"));
		System.out.println("**************************************|******************************************");
		System.out.println(String.format("%-40s%-40s", "Unlimited access to your Home Club", "Unlimited Access to any club"));
		System.out.println("--------------------------------------|-----------------------------------------");
		System.out.println(String.format("$%-40.2f$%-40.2f", 19.99, 44.44));
		System.out.println("--------------------------------------|-----------------------------------------\n");
		System.out.println("Please choose Single Club(S) or Flexible Membership (F)");
		String sOrF = Validator.sOrF(scnr);
		if (sOrF.equalsIgnoreCase("S")) {
			return true;
		}else return false;
	}
}

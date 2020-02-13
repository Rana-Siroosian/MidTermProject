import java.time.LocalDateTime;
import java.util.Scanner;

public class AddMember {
	public static FileHelper<Member> fileHelper = new FileHelper<Member>("MembersTextFile", new MemberLineConverter());

	public static void addMember1(Scanner scnr) {

		// Enter member info
		String memberName = Validator.getString(scnr, "Please enter member name: ");
		int memberId = Validator.getInt(scnr, "Please enter member Id: ");
		double weight = Validator.getDouble(scnr, "Please enter member's weight: ");
		double height = Validator.getDouble(scnr, "Please enter your height: ");
		double bmi = (weight / (height * height)) * 703;
		double fee = 19.99;

		if (bmi >= 18.5 && bmi <= 25) {
			System.out.println("You are in a good shape.");
		}
		else if (bmi > 25 && bmi <= 30) {
			System.out.println("You are overweight, would you like to have one of our personal trainer? (y/n): ");
			String yesOrNo = Validator.yesOrNo(scnr);
			
			if (yesOrNo.equalsIgnoreCase("y")) {
				
				System.out.println("Best downtown personal trainer\n");
				System.out.println(String.format("%-40s%-40s", "1. Rana Siroosian", "2. Jeannie Mccarthy"));
				System.out.println("**************************************|******************************************");
				System.out.println(String.format("%-40s%-40s", "1. Monthly: $230", "1. Monthly: $230"));
				System.out.println("--------------------------------------|-----------------------------------------");
				System.out.println(String.format("%-40s%-40s", "2. Hourly: $26", "2. Hourly: $26"));
				System.out.println("--------------------------------------|-----------------------------------------");
				System.out.println();
				System.out.println("Which trainer would you like to work with? (choose by number): ");
				int option = Validator.getInt(scnr, "", 1, 2);
				if (option == 1) { 
					System.out.println("Would you like the monthly plan or hourly? (choose by number): ");
					int plan = Validator.getInt(scnr, "", 1, 2);
						if (plan == 1) {
							fee = fee + 230;
						}
						else {
							int hours = Validator.getInt(scnr, "How many hours are you planning for? ");
							fee = (hours * 26) + fee;
							System.out.println("Thank you for taking this plan with us, we garantee that you will"
									+ "see the changes less than a month and you will feel healthier.");
						}
					}
				
				if (option == 2) { 
					System.out.println("Would you like the monthly plan or hourly? (choose by number): ");
					int plan = Validator.getInt(scnr, "", 1, 2);
						if (plan == 1) {
							fee = fee + 230;
						}
						else {
							int hours = Validator.getInt(scnr, "How many hours are you planning for? ");
							fee = (hours * 26) + fee;
							System.out.println("Thank you for taking this plan with us, we garantee that you will"
									+ "see the changes less than a month and you will feel healthier.");
						}
					}
				
				
				}
								
			}
		

		// Assign a Club to a member
		System.out.println("\nPlease choose a club (by number) from the list below: ");
		Club.showClubs();
		int club = Validator.getInt(scnr, "", 1, 6) - 1;
		Club clubName = Club.getClubList().get(club);

		// Give Discount between noon and 8pm
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
		double height = Validator.getDouble(scnr, "Please enter your height: ");
		double bmi = ((weight*705)/height)/height;
		int points = 0;
		double fee = 44.44;

		
		if (bmi >= 18.5 && bmi <= 25) {
			System.out.println("You are in a good shape.");
		}
		else if (bmi > 25 ) {
			System.out.println("\nYou are overweight, would you like to have one of our personal trainer? (y/n): ");
			String yesOrNo = Validator.yesOrNo(scnr);
			
			if (yesOrNo.equalsIgnoreCase("y")) {
				
				System.out.println("Best downtown personal trainer\n");
				System.out.println(String.format("%-40s%-40s", "1. Rana Siroosian", "2. Jeannie Mccarthy"));
				System.out.println("**************************************|******************************************");
				System.out.println(String.format("%-40s%-40s", "1. Monthly: $230", "1. Monthly: $230"));
				System.out.println("--------------------------------------|-----------------------------------------");
				System.out.println(String.format("%-40s%-40s", "2. Hourly: $26", "2. Hourly: $26"));
				System.out.println("--------------------------------------|-----------------------------------------");
				System.out.println();
				System.out.println("Which trainer would you like to work with? (choose by number): ");
				int option = Validator.getInt(scnr, "", 1, 2);
				if (option == 1) { 
					System.out.println("Would you like the monthly plan or hourly? (choose by number): ");
					int plan = Validator.getInt(scnr, "", 1, 2);
						if (plan == 1) {
							fee = fee + 230;
						}
						else {
							int hours = Validator.getInt(scnr, "\nHow many hours are you planning for? ");
							fee = (hours * 26) + fee;
							System.out.println("\nThank you for taking this plan with us, we garantee that you will"
									+ "see the changes less than a month and you will feel healthier.");
						}
					}
				
				if (option == 2) { 
					System.out.println("\nWould you like the monthly plan or hourly? (choose by number): ");
					int plan = Validator.getInt(scnr, "", 1, 2);
						if (plan == 1) {
							fee = fee + 230;
						}
						else {
							int hours = Validator.getInt(scnr, "\nHow many hours are you planning for? ");
							fee = (hours * 26) + fee;
							System.out.println("\nThank you for taking this plan with us, we garantee that you will"
									+ " see the changes less than a month and you will feel healthier.");
						}
					}
				
				
				}
								
			}
		
		if (bmi < 18.5 ) {
			System.out.println("\nYou should try to eat more, being this tiny is not good for your health! ");
		}
		
		
		//Give Discount between noon and 8pm
		LocalDateTime now = LocalDateTime.now();
		if (now.getHour() > 12 && now.getHour() < 18) {
			System.out.println("\nWoohoo, You are eligible for discount and we will take 10$ off of your total.");
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

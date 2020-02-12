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

		
	}
	
	public static void printMenu(List<Constant> constant,List<Flexible> flexible,Scanner scnr) {

		String [] menu = {"Add Member", "Check In Member","Display Member Information", "Generate Invoice", 
				"Remove member", "Quit"};
		
		for (int i = 0; i < menu.length; i++) {
			System.out.println((i+1) + ". " + menu[i]);
			
		}
		System.out.println("---------------------------------------------");
		int choice = Validator.getInt(scnr, "\nWhat would you like to do? (choose by number) ", 1, 6);
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
			checkIn(scnr);
			printMenu(constant, flexible, scnr);

			break;
		
		case 3: 
			displayMemberInfo();
			printMenu(constant, flexible, scnr);
			break;
			
		case 5 : 
			removeMember(scnr);
			printMenu(constant, flexible, scnr);
			break;
			
		case 6 :
			break;
		}
		System.out.println("Thank you, Goodbye!");
	}
	
	public static List<Constant> addMember1(List<Constant> constant,Scanner scnr) {
		
		String memberName = Validator.getString(scnr, "Please enter member name: ");
		int memberId = Validator.getInt(scnr, "Please enter member Id: ");
		double weight = Validator.getDouble(scnr, "Please enter member's weight: ");
		String clubName = Validator.getString(scnr, "Please enter the club name: ");
//		constant.add(new Constant( memberId, memberName,weight, clubName));
		
		fileHelper.append(new Constant(memberId, memberName,weight, clubName));
		System.out.println("Member is added.");
		System.out.println("---------------------------------------------");

		return constant;
		
	}
	
	public static  List<Flexible> addMember2( List<Flexible> flexible,Scanner scnr){
		String memberName = Validator.getString(scnr, "Please enter member name: ");
		int memberId = Validator.getInt(scnr, "Please enter member Id: ");
		double weight = Validator.getDouble(scnr, "Please enter member's weight: ");
//		 flexible.add(new Flexible(memberName, memberId, weight));
		fileHelper.append(new Flexible(memberName,memberId ,weight));
		System.out.println("Member is added.");
		System.out.println("---------------------------------------------");

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
		int club = Validator.getInt(scnr, "Which club member would like to check in? ", 1, 6)-1;
		flexible.checkIn(clubs.get(club));
		System.out.println(flexible.points);
		
	}
	
	public static void displayMemberInfo() {
		System.out.println(String.format("%-5s%-15s%-12s%-10s", "Id", "Member","Weight","Club Name"));
		System.out.println("*****************************************");
		List<Member> members = fileHelper.readAll();
		
		for (Member member : members) {
			System.out.println(member.toString());
		}
		
		System.out.println("---------------------------------------------");

	}
	
	public static void removeMember(Scanner scnr) {
		
		List<Member> members = fileHelper.readAll();
		
		System.out.println(String.format("%-2s %-5s%-15s%-12s%-10s","#", "Id", "Member","Weight","Club Name"));
		System.out.println("*****************************************");
		int i=0;

		for (Member member : members) {

			System.out.println((i+=1)+". " + member.toString());
			
		}
		int delete = Validator.getInt(scnr, "Which member would you like to delete? (choose by member ID): ");

		System.err.print("Are you sure you want to delete " + members.get(delete-1).getName() + " from the list? (y/n): ");
		String question = Validator.yesOrNo(scnr);

		if (question.equalsIgnoreCase("y")) {
			System.out.println(members.get(delete-1).getName() + " is removed from the list! ");
			members.remove(delete-1);
			fileHelper.rewrite(members);

			
		}
		if (question.equalsIgnoreCase("n")) {
			System.out.println();
			System.out.println("Ok , next time make up your mind before pressing delete.");

		}
		System.out.println("---------------------------------------------");

	}
	
	public static void generateInvoice() {
		List<Member> members = fileHelper.readAll();
		//double invoice = 
		System.out.println(String.format("%-2s %-5s%-15s%-12s%-10s","#", "Id", "Member","Weight","Club Name"));
		System.out.println("*****************************************");
		int i=0;

		for (Member member : members) {

			System.out.println((i+=1)+". " + member.toString());
			
		}
		
	}
}
	

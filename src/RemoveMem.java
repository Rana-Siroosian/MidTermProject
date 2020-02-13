import java.util.List;
import java.util.Scanner;

public class RemoveMem {

	public static FileHelper<Member> fileHelper = new FileHelper<Member>("MembersTextFile",
			new MemberLineConverter());
	
public static void removeMember(Scanner scnr) {
		
		List<Member> members = fileHelper.readAll();
		
		//display list of members
		System.out.println(String.format("%-2s %-5s%-15s%-12s","#", "Id", "Member","Weight"));
		System.out.println("*****************************************");
		int i=0;
		for (Member member : members) {
			System.out.println((i+=1)+". " + member.toString());
		}
		//get user selection
		int delete = Validator.getInt(scnr, "Which member would you like to delete? (choose by member ID): ");
		System.err.print("Are you sure you want to delete " + members.get(delete-1).getName() + " from the list? (y/n): ");
		String question = Validator.yesOrNo(scnr);
		//delete the selected member
		if (question.equalsIgnoreCase("y")) {
			System.out.println(members.get(delete-1).getName() + " is removed from the list! ");
			members.remove(delete-1);
			fileHelper.rewrite(members);
		}
		if (question.equalsIgnoreCase("n")) {
			System.out.println();
			System.err.println("Ok , next time make up your mind before pressing delete.");
		}
		System.out.println("---------------------------------------------");
	}
}

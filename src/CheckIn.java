import java.util.List;
import java.util.Scanner;

/**
 * @author JeannieMcCarthy&RanaSiroosian
 *
 */
public class CheckIn {
	public static FileHelper<Member> fileHelper = new FileHelper<Member>("MembersTextFile",
			new MemberLineConverter());
	public static void checkIn(Scanner scnr){
		
		List<Member> members = fileHelper.readAll();
		System.out.println("Which member would you like to check in? "
				+ "(choose by number from the list before): ");
		System.out.println();
		System.out.println(String.format("%-2s %-5s%-15s","#", "Id", "Member"));
		System.out.println("***************");
		int i=0;

		for (Member member : members) {

			System.out.println((i+=1)+". " + member.getId()+ "\t" +member.getName()+"\n");
			
			
		}
		int checkIn = Validator.getInt(scnr, "", 1, members.size());

		System.out.println();
		System.out.println("\nPlease pick a club from the list below (choose by number):\n ");
		try{
			members.get(checkIn-1).checkIn(Club.chooseClub(scnr));
			System.out.println(((Flexible) members.get(checkIn-1)).getPoints());
		}catch (AccessDeniedException e) {
			e.getMessage();
		}
		System.out.println("---------------------------------------------");

		
	}
}

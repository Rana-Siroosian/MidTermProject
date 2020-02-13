import java.util.List;
import java.util.Scanner;

public class GenerateMemInvoice {

	public static FileHelper<Member> fileHelper = new FileHelper<Member>("MembersTextFile",
			new MemberLineConverter());
	
	public static void generateInvoice(Scanner scnr) {
		
		List<Member> members = fileHelper.readAll();
		
		//display members
		System.out.println(String.format("%-2s %-5s%-15s","#", "Id", "Member"));
		System.out.println("***************");
		int i=0;
		for (Member member : members) {
			System.out.println((i+=1)+". " + member.getId()+ "\t" +member.getName()+"\n");
		}
		System.out.println();
		
		//get user selection:
		int invoice = Validator.getInt(scnr, "Which member would you like to see the invoice for? (choose by number): ", 1, members.size());
		System.out.println();
		
		//display invoice:
		System.out.println(String.format("%-5s%-11s%-15s", "Id", "Member", "Fee"));
		System.out.println("*********************");
		System.out.println(String.format("%-5s %-10s%-10s" ,members.get(invoice-1).getId(), members.get(invoice-1).getName()
					,members.get(invoice-1).getFee()));
		System.out.println("---------------------------------------------");	
	}
}

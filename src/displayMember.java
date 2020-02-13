import java.util.List;

public class displayMember {
	public static FileHelper<Member> fileHelper = new FileHelper<Member>("MembersTextFile",
			new MemberLineConverter());
	
	public static void displayMemberInfo() {
		System.out.println(String.format("%-5s%-15s%-12s%-10s", "Id", "Member","Weight","Club Name"));
		System.out.println("*****************************************");
		List<Member> members = fileHelper.readAll();
		
		for (Member member : members) {
			System.out.println(member.toString());
		}
		
		System.out.println("---------------------------------------------");

	}
}

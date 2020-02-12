import java.util.List;

public class Testing {
	public static FileHelper<Member> fileHelper = new FileHelper<Member>("MembersTextFile",
			new MemberLineConverter());
	public static void main(String[] args) {
		
	System.out.println("somethinhg1");
//		fileHelper.append(new Flexible(1, "Rana", 121, 0));
//		fileHelper.append(new Constant(2, "Jeannie", 130, "Fitterize"));
		
		//System.out.println(getFileAsList());
		for (Member member : getFileAsList()) {
			System.out.println(member);
			System.out.println("something");
		}
		
	}
	
	private static List<Member> getFileAsList() {
	
		List<Member> members = fileHelper.readAll();
		return members;
	}

}

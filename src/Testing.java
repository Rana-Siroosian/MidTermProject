import java.util.Arrays;
import java.util.List;

public class Testing {
	public static FileHelper<Member> fileHelper = new FileHelper<Member>("MembersTextFile",
			new MemberLineConverter());
	public static void main(String[] args) {
		
	
		fileHelper.append(new Flexible(1, "Rana", 0.0, 121));
		fileHelper.append(new Constant(2, "Jeannie", 130, "Fitterize"));
		
		System.out.println(getFileAsList());
	}
	
	private static List<Member> getFileAsList() {
	
		List<Member> members = fileHelper.readAll();
		return members;
	}

}

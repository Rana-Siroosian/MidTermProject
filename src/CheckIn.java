import java.util.Scanner;

/**
 * @author JeannieMcCarthy&RanaSiroosian
 *
 */
public class CheckIn {
	
	public static void checkIn(Scanner scnr, Member member, Club club){
		try{
			member.checkIn(club);
		}catch (AccessDeniedException e) {
			e.getMessage();
		}
//		if (member instanceof Flexible) {
//			((Flexible) member).points++;
//		}
//		else {
//			if(((Constant) member).getHomeClub().equalsIgnoreCase(club)){
//				System.out.println("Welcome to your club!");
//			}
//		}
	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author JeannieMcCarthy&RanaSiroosian
 *
 */
public class Club {
	
	protected String name;
	protected String address;
	
	public Club(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return String.format("Club: %s", name);
	}
	
	public static void displayName(String name) {
		
	}
	//club list variable
	private static List<Club> clubs = new ArrayList<>(Arrays.asList
			(new Club("Dumbell Paradise", "123 Main Street"), new Club("Oxygen360" , "345 Main St."),
			new Club("Crazy CrossFit", "678 Main St."), new Club("Run With It", "123 Runna Way"),
			new Club("Tread Lightly", "777 Stomp Ct."), new Club("Spin Me Right Round", "1111 Inna Cr.")));
	
	//show menu of clubs method
	public static void showClubs() {
		for (int i = 0; i < clubs.size(); i++) {
			System.out.println(String.format("%s%s%-15s",i+1,". ", clubs.get(i)));
		}
	}
	
	public static Club chooseClub(Scanner scnr) {
		showClubs();
		int club = Validator.getInt(scnr, "", 1, 6)-1;
		return clubs.get(club);
	}
	public static List<Club> getClubList() {
		return clubs;
	}
}

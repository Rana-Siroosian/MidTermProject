
public class Constant extends Member {
	
	protected Club homeClub;
	
	
//constructor for program
	public Constant(int id, String name, double weight, Club homeClub) {
		super(id, name, weight);
		this.homeClub = homeClub;
		this.fee=19.99;
	}
	//constructor for file reader
	public Constant(int id, String name, double weight, double fee, String homeClub) {
		super(id, name, weight);
		
		this.fee=fee;
		//get string from file, loop through clubs to find matching club for this member
		for (Club club : Club.getClubList()) {
			if (club.toString().contains(homeClub)) {
				this.homeClub = club;
			}
		}
	}


	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void checkIn(Club club) throws AccessDeniedException {
		
		if(club.equals(homeClub)) {
			System.out.println("Welcome to your club.");
		}
		else {
			throw new AccessDeniedException("Membership type is not eligible "
					+ "for entry into this location.");
		}
	}


	public Club getHomeClub() {
		return homeClub;
	}


	public void setHomeClub(Club homeClub) {
		this.homeClub = homeClub;
	}


	@Override
	public String toString() {
		return String.format("%-5d%-15s%-5.2f\t%s\n", getId(), getName(), getWeight(), homeClub);	
		}
	
	

}

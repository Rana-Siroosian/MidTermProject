
public class Constant extends Member {
	
	protected Club homeClub;
	
	
//constructor for program
	public Constant(int id, String name, double weight, Club homeClub) {
		super(id, name, weight);
		this.homeClub = homeClub;
		this.fee=19.99;
	}
	//constructor for file reader
	public Constant(int id, String name, double weight, double fee, Club homeClub) {
		super(id, name, weight);
		this.homeClub = homeClub;
		this.fee=fee;
//		//get string from file, loop through clubs to find matching club for this member
//		for (Club club : Club.getClubList()) {
//			if (club.toString().contains( homeClub)) {
//				this.homeClub = club;
//			}
//		}
	}


	@Override
	public void checkIn(Member member, Club club) throws AccessDeniedException {
		
		if(club.equals(homeClub)) {
			System.out.println("Welcome to " + club.getName());
		}
		else {
			throw new AccessDeniedException(member.getName() + "'s Membership type is not eligible "
					+ "for entry into " + club.getName() + ".\n Please advise " + member.getName() 
					+ " to head over to " + ((Constant) member).getHomeClub() + " at " 
					+ ((Constant) member).getHomeClub().getAddress() + "\nor UPGRADE to our " 
					+ "Flexible Membership option TODAY!!!");
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

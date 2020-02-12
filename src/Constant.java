
public class Constant extends Member {
	
	protected String homeClub;
	
	


	public Constant(int id, String name, double weight, String homeClub) {
		super(id, name, weight);
		this.homeClub = homeClub;
		this.fee=19.99;
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


	public String getHomeClub() {
		return homeClub;
	}


	public void setHomeClub(String homeClub) {
		this.homeClub = homeClub;
	}


	@Override
	public String toString() {
		return String.format("%-5d%-15s%-5.2f\t%s\n", getId(), getName(), getWeight(), homeClub);	
		}
	
	

}


public class Constant extends Member {
	
	protected String homeClub;
	
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void checkIn(Club club) throws AccessDeniedException {
		
		if( club.equals(homeClub)) {
			System.out.println("Welcome to your club.");
		}
		else {
			throw new AccessDeniedException("Your membership type is not eligible "
					+ "for entry into this location.");
		}
	}

}

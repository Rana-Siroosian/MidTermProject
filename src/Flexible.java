
public class Flexible extends Member{

	protected int points;
	
	
	@Override
	public void checkIn(Club club) {
		
		points++;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}
	
	

}

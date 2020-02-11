
public class Flexible extends Member{

	protected int points = 0;
	
	
	public Flexible(int id, String name, double weight, int points) {
		super(id, name, weight);
		this.points = points;
	}


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

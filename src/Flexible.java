
public class Flexible extends Member{

	protected int points = 0;
	
	//constructor for file reader
	public Flexible(int id, String name, double weight, double fee, int points) {
		super(id, name, weight);
		this.points = points;
		this.fee = fee;
	}

	//constructor for program
	public Flexible(int memberId, String memberName, double weight) {
		super(memberId, memberName, weight);
		this.fee = 44.44;
	}


	@Override
	public void checkIn(Member member, Club club) {
		
		points++;
		System.out.println("Great! Successfullly checked in at " + club.getName() + ". "
				+ member.getName() + "'s point balance has increased to: " + 
				(((Flexible) member).getPoints()));
	}
	
	@Override 
	public String toString() {
		return String.format("%-5d%-15s%-5.2f\t%-10d\n", getId(), getName(), getWeight(), points);
	}

	public int getPoints() {
		return points;
	}

}

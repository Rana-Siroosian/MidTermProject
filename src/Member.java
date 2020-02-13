import java.time.LocalDate;

/**
 * 
 * @author RanaSiroosian&JeannieMcCarthy
 *
 */
public abstract class Member {

	protected int id;
	protected String name;
	protected double weight;
	protected double fee;


	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public Member() {
		
	}
	
	public Member (int id, String name, double weight) {
		
		this.id = id;
		this.name = name;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public abstract String toString();
	
	public abstract void checkIn(Member member, Club club) throws AccessDeniedException;
	
}

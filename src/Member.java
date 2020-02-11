/**
 * 
 * @author RanaSiroosian&JeannieMcCarthy
 *
 */
public abstract class Member {

	protected int id;
	protected String name;
	
	
	public Member() {
		
	}
	
	public Member (int id, String name) {
		
		this.id = id;
		this.name = name;
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
	
	@Override
	public String toString() {
		return String.format("%-10d%-15s", getId(), getName());
	}
	
	public abstract void checkIn(Club club) throws AccessDeniedException;
	
}

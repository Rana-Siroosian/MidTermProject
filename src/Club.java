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
		return String.format("Club [name=%s, address=%s]", name, address);
	}
	
	public static void displayName(String name) {
		
	}
	
	
}

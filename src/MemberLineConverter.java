
/**
 * @author JeannieMcCarthy
 *
 */
public class MemberLineConverter implements LineConverter<Member> {

	@Override
	public String toLine(Member member) {
		
		//different string formats for different members:
		if (member instanceof Flexible) {
			return String.format("%d\t%s\t%.2f\t%f\t%d", member.getId(), member.getName(), member.getWeight(), member.getFee(),
					((Flexible) member).getPoints());
		} else {
			return String.format("%d\t%s\t%.2f\t%f\t%s", member.getId(), member.getName(), member.getWeight(), member.getFee(),
					((Constant) member).getHomeClub());
		}
	}

	@Override
	public Member fromLine(String line) {
		//regex to determine which kind of member
		if (line.matches(".*\\t.*\\t.*\\t\\d*")) {
			String[] parts = line.split("\t");
			int id = Integer.parseInt(parts[0]);
			String name = parts[1];
			double weight = Double.parseDouble(parts[2]);
			double fee = Double.parseDouble(parts[3]);
			int points = Integer.parseInt(parts[4]);
			Flexible thisFlex = new Flexible(id, name, weight, fee, points);
			return thisFlex;
		}
		 
		else if (line.matches(".*\\t.*\\t[a-zA-Z][a-zA-Z\\W\\w]*")){
			String[] parts = line.split("\t");
			int id = Integer.parseInt(parts[0]);
			String name = parts[1];
			double weight = Double.parseDouble(parts[2]);
			double fee = Double.parseDouble(parts[3]);
			Club homeClub = null;
			for (Club club : Club.getClubList()) {
				if (club.toString().contains((CharSequence) parts[4])) {
					 homeClub = club;
				}
			}
			 
			return new Constant(id, name, weight, fee, homeClub);
		}
		//Will return a fake member filled with zeroes and ERROR to indicate the line could not be parsed.
		//This way the rest of the list can be read without any exceptions
		else return new Flexible(0, "ERROR", 0.0,0.0, 0);
	}

}

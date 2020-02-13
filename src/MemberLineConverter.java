
/**
 * @author JeannieMcCarthy
 *
 */
public class MemberLineConverter implements LineConverter<Member> {

	@Override
	public String toLine(Member member) {
		if (member instanceof Flexible) {
			return String.format("%d\t%s\t%.2f\t%d\t%d", member.getId(), member.getName(), member.getWeight(), member.getFee(),
					((Flexible) member).getPoints());
		} else {
			return String.format("%d\t%s\t%.2f\t%f\t%s", member.getId(), member.getName(), member.getWeight(), member.getFee(),
					((Constant) member).getHomeClub());
		}

	}

	@Override
	public Member fromLine(String line) {
		if (line.matches(".*\\t.*\\t.*\\t\\d*")) {
//			System.out.println(line);
			String[] parts = line.split("\t");

			int id = Integer.parseInt(parts[0]);
			String name = parts[1];
			double weight = Double.parseDouble(parts[2]);
			double fee = Double.parseDouble(parts[3]);
			int points = Integer.parseInt(parts[4]);
			Flexible thisFlex = new Flexible(id, name, weight, fee, points);
//			System.out.println(thisFlex);
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
		else return new Flexible(0, "ERROR", 0.0,0.0, 0);
	}

}

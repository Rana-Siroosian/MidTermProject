
/**
 * @author JeannieMcCarthy
 *
 */
public class MemberLineConverter implements LineConverter<Member> {

	@Override
	public String toLine(Member member) {
		if (member instanceof Flexible) {
			return String.format("%d\t%s\t%.2f\t%d", member.getId(), member.getName(), member.getWeight(),
					((Flexible) member).getPoints());
		} else {
			return String.format("%d\t%s\t%.2f\t%s", member.getId(), member.getName(), member.getWeight(),
					((Constant) member).getHomeClub());
		}

	}

	@Override
	public Member fromLine(String line) {
		if (line.matches(".*\\t.*\\t.*\\t\\d*")) {
			String[] parts = line.split("\t");
			parts[0].trim();
			int id = Integer.parseInt(parts[0]);
			String name = parts[1];
			double weight = Double.parseDouble(parts[2]);
			int points = Integer.parseInt(parts[3]);
			return new Flexible(id, name, weight, points);
		}
		//if (line.matches(".*\\t.*\\t.*\\t\\.*")) {
		else {
			String[] parts = line.split("\t");
			int id = Integer.parseInt(parts[0]);
			String name = parts[1];
			double weight = Double.parseDouble(parts[2]);
			String homeClub = parts[3];
			return new Constant(id, name, weight, homeClub);
		}
	}

}

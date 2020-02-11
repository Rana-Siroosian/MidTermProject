
/**
 * @author JeannieMcCarthy
 *
 */
public class MemberLineConverter implements LineConverter<Member>{

	@Override
	public String toLine(Member member) {
		if (member instanceof Flexible) {
			return String.format("%d\t%s\t%d\t%d", member.getId(), member.getName(), member.getWeight(),
					((Flexible) member).getPoints());	
		}else  {
			return String.format("%d\t%s\t%d\t%s", member.getId(), member.getName(), member.getWeight(),
					((Constant) member).getHomeClub());	
		}
		
	}

	@Override
	public Member fromLine(String line) {
		//if (line.matches(")) {
		String[] parts = line.split("\t");
		String id = parts[0];
		String name = parts[1];
		double weight = Double.parseDouble(parts[2]);
		return null;
		}

}

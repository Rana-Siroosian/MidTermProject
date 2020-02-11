
/**
 * @author JeannieMcCarthy
 *
 */
public class MemberLineConverter implements LineConverter<Member>{

	@Override
	public String toLine(Member member) {
		return String.format("%s\t%s\t%d", member.getId(), member.getName(), member.get());
	}

	@Override
	public Country fromLine(String line) {
		String[] parts = line.split("\t");
		String name = parts[0];
		String rulingMonarch = parts[1];
		int population = Integer.parseInt(parts[2]);
		
		return new Country(name, rulingMonarch, population);
	}

}


public class PatternFilter implements WordFilter {
	String pattern = null;
	char dash = '-';

	public PatternFilter(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String filter(String word) {
		boolean matchword = false;

		if (pattern.length() != word.length()) {// This is the only way I can
			// figure out how to make the
			// program work.
			return null;// Can't figure out how to use both filters.
		}

		for (int i = 0; i < (pattern.length()); i++) {
			if ((pattern.charAt(i)) == (word.charAt(i)) || (pattern.charAt(i) == dash)) {
				matchword = true;
			} else {
				return null;
			}
		}

		return pattern;
	}
}

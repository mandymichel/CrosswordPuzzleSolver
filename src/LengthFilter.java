
public class LengthFilter implements WordFilter {

	private int length;

	public LengthFilter(int length) {
		this.length = length;
	}

	@Override
	public String filter(String word) {
		if (word.length() == length) {
			return word;
		}
		return null;
	}

}

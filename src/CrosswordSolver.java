import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrosswordSolver implements Solver {

	List<String> matches = new ArrayList<>();// broken now. why??
	Dictionary dictionary = new Dictionary();

	public List<String> filterAll(Dictionary dictionary, WordFilter[] filters) {

		String word = null;
		for (int i = 0; i < dictionary.size(); i++) {
			word = dictionary.getWord(i);
			boolean allFiltersMatched = true;
			for (int j = 0; j < (filters.length); j++) {
				WordFilter wordFilter = filters[j];
				if (wordFilter.filter(word) == null) {
					allFiltersMatched = false;
				}

			}
			if (allFiltersMatched) {
				matches.add(word);
			}
		}

		return matches;
	}

	public void run() {
		Scanner keyboard = new Scanner(System.in);
		out.println("Type a word or word pattern.");
		String pattern = keyboard.next();
		int length = pattern.length();

		LengthFilter lf = new LengthFilter(length);
		PatternFilter pf = new PatternFilter(pattern);
		WordFilter[] filters = { lf, pf };
		matches = filterAll(dictionary, filters);
		for (String word : matches) {
			System.out.println(word);
		}
	}

	public static void main(String[] args) {
		CrosswordSolver xsolver = new CrosswordSolver();
		xsolver.run();
	}

}

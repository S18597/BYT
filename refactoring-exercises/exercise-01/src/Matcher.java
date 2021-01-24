public class Matcher {

	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {
		clipTooLarge(actual, clipLimit);
		return sameLength(expected, actual) && eachEntryWithinRange(expected, actual, delta);
	}

	// Clip "too-large" values
	public void clipTooLarge(int[] actual, int clipLimit) {
		for (int i = 0; i < actual.length; i++)
			if (actual[i] > clipLimit)
				actual[i] = clipLimit;
	}

	// Check for length differences
	public boolean sameLength(int[] expected, int[] actual) {
		if (actual.length != expected.length)
			return false;
	}

	// Check that each entry within expected +/- delta
	public boolean eachEntryWithinRange(int[] expected, int[] actual, int delta) {
		for (int i = 0; i < actual.length; i++)
			if (Math.abs(expected[i] - actual[i]) > delta)
				return false;
		return true;
	}
}

public class sorted {
	public String sortedmethod (String[] strs) {
		StringBuilder result = new StringBuilder();

		if (strs != null && strs.length > 0) {
			//sort the string arrays
			Arrays.sort(strs);

			char[] first = strs[0].toCharArray();
			char[] last = strs[strs.length - 1].toCharArray();

			for (int i = 0, j = 0; i < first.length && j < last.length; i++, j++) {
				if (first[i] != last[j]) {
					break;
				}
				result.append(first[i]);
			}
		}
		return result.toString();
	}
}

public class unsorted {
	
}
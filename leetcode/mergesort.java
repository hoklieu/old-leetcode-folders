private int[] mergeSort(int[] unsorted) {
	//base case: 
	if (unsorted.length <= 1) {
		return unsorted;
	}
	int mid = unsorted.length / 2;
	int[] left = new int[mid];
	int[] right = new int[unsorted.length - mid];

	System.arraycopy(unsorted,0,left,0,mid);
	System.arraycopy(unsorted,mid,right,0,right.length);

	left = mergeSort(left);
	right = mergeSort(right);
	return merge(left,right);

}
public int[] merge(int[] a,int[] b) {
	int[] result = new int[a.length + b.length];

	int ptr = 0;

	int ptra = 0;
	int ptrb = 0;

	while (ptra < a.length && ptrb < b.length) {
		if (a[ptra] < b[ptrb]) {
			result[ptr++] = a[ptra++];
		} else {
			result[ptr++] = b[ptrb++];
		}
	}
	//deal with the rest
	if (ptra < a.length || ptrb < b.length) {
		while (ptra < a.length) {
			result[ptr++] = a[ptra++];
		}
		while (ptrb < b.length) {
			result[ptr++] = b[ptrb++];
		}
	}
	return result;
}
package com.sample.text.problesolving.array;

// Java program to find length
// of the longest array with
// first element smaller than
// or equal to last element.
public class LargestSubArray1stElementGreaterThanLast {

	// Search function for searching
	// the first element of the
	// subarray which is greater or
	// equal to the last element(num)
	static int binarySearch(int[] searchSpace, int s, int e, int num) {
		int ans = 0;

		while (s <= e) {
			int mid = (s + e) / 2;

			if (searchSpace[mid] >= num) {
				ans = mid;
				e = mid - 1;
			} else
				s = mid + 1;
		}

		return ans;
	}

	// Returns length of the longest
	// array with first element smaller
	// than the last element.
	static int longestSubArr(int[] arr, int n) {
		// Search space for the
		// potential first elements.
		int[] searchSpace = new int[n];

		// It will store the Indexes
		// of the elements of search
		// space in the original array.
		int[] index = new int[n];

		// Initially the search
		// space is empty.
		int j = 0;
		int ans = 0;

		for (int i = 0; i < n; ++i) {

			// We will add an ith element
			// in the search space if the
			// search space is empty or if
			// the ith element is greater
			// than the last element of
			// the search space.
			if (j == 0 || searchSpace[j - 1] < arr[i]) {
				searchSpace[j] = arr[i];
				index[j] = i;
				j++;
			}

			// we will search for the index
			// first element in the search
			// space and we will use it find
			// the index of it in the original array.
			int idx = binarySearch(searchSpace, 0, j - 1, arr[i]);

			// Update the answer if the
			// length of the subarray is
			// greater than the previously
			// calculated lengths.
			ans = Math.max(ans, i - index[idx] + 1);
		}
		return ans;
	}

	// Driver Code
	public static void main(String[] args) {
		int arr[] = {-5, -1, 7, 5, 1, -2};
		int n = arr.length;
		System.out.println(longestSubArr(arr, n));
	}

	// This code is contributed
	// by ChitraNayal

}

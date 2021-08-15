package com.sample.text.problesolving.array;

import java.util.Arrays;

public class LongestCommonBinarySum {

	// A O(n) and O(n) extra space Java program to find
	// longest common subarray of two binary arrays with
	// same sum

	static int arr1[] = new int[] {0, 1, 0, 1, 1, 1, 1};
	static int arr2[] = new int[] {1, 1, 1, 1, 1, 0, 1};

	// Returns length of the longest common sum in arr1[]
	// and arr2[]. Both are of same size n.
	static int longestCommonSum(int n) {
		// Initialize result
		int maxLen = 0;

		// Initialize prefix sums of two arrays
		int preSum1 = 0, preSum2 = 0;

		// Create an array to store staring and ending
		// indexes of all possible diff values. diff[i]
		// would store starting and ending points for
		// difference "i-n"
		int diff[] = new int[2 * n + 1];

		// Initialize all starting and ending values as -1.
		for (int i = 0; i < diff.length; i++) {
			diff[i] = -1;
		}

		// Traverse both arrays
		for (int i = 0; i < n; i++) {
			// Update prefix sums
			preSum1 += arr1[i];
			preSum2 += arr2[i];

			// Comput current diff and index to be used
			// in diff array. Note that diff can be negative
			// and can have minimum value as -1.
			int curr_diff = preSum1 - preSum2;
			int diffIndex = n + curr_diff;

			// If current diff is 0, then there are same number
			// of 1's so far in both arrays, i.e., (i+1) is
			// maximum length.
			if (curr_diff == 0)
				maxLen = i + 1;

			// If current diff is seen first time, then update
			// starting index of diff.
			else if (diff[diffIndex] == -1)
				diff[diffIndex] = i;

			// Current diff is already seen
			else {
				// Find length of this same sum common span
				int len = i - diff[diffIndex];

				// Update max len if needed
				if (len > maxLen)
					maxLen = len;
			}
		}
		return maxLen;
	}

	// Driver method to test the above function
	public static void main(String[] args) {
		System.out.print("Length of the longest common span with same sum is ");
//		System.out.println(longestCommonSum(arr1.length));
		System.out.println(longestCommonBinarySum(arr1, arr2));
	}

	public static int longestCommonBinarySum(int[] arr, int[] arr2) {
		int res = 0;
		int presum1 = 0, presum2 = 0, sum_diff = 0;
		int n = arr.length;
		int dp[] = new int[2 * arr.length];
		Arrays.fill(dp, -1);
		for (int i = 0; i < arr.length; i++) {
//			presum1 += arr[i];
//			presum2 += arr2[i];
//
//			int curr_diff = presum1 - presum2;
//			int diff_index = curr_diff + n;
//
//			if (curr_diff == 0) {
//				res = i + 1;
//			} else if (dp[diff_index] == -1) {
//				dp[diff_index] = i;
//			} else {
//				int l = i - dp[diff_index];
//				if (l > res) {
//					res = l;
//				}
//			}
			
			presum1+=arr1[i];
			presum2+=arr2[i];
			
			int curr_diff= presum1-presum2;
			int diff_index = n+curr_diff;
			
			if(curr_diff==0) {
				res=i+1;
			}else if(dp[diff_index] == -1) {
				dp[diff_index] = i;
			} else {
				int t= i-dp[diff_index];
				if(t>res) {
					res=t;
				}
			}
			
		}
		return res;
	}
}
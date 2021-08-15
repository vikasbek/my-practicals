package com.sample.test.dp;

public class SubsetSumCount {

	public static int getsubset(int[] arr, int sum, int s) {
		if (sum == 0) {
			return 1;
		}
		if (sum < 0 || s >= arr.length) {
			return 0;
		}
		return getsubset(arr, sum - arr[s], s + 1) + getsubset(arr, sum, s + 1);
	}

	public static int getsubsetSum(int[] arr, int sum, int s) {
		if (sum == 0 && s == arr.length) {
			return 1;
		}
		if (s > arr.length) {
			return 0;
		}
		return getsubset(arr, sum - arr[s], s + 1) + getsubset(arr, sum + arr[s], s + 1);
	}

	public static void main(String[] args) {
//		int array[] = { 1, 1, 2, 3 };
//		int count = getsubset(array, 4, 0);
//		System.out.println(count);
		int arr[] = {1, 2, 7, 1};
		int op = getsubsetSum(arr, 9, 0);
		System.out.println(op);

	}

}

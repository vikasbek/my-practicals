package com.sample.test;

public class HE_MinimumSteps {

	public static void main(String[] args) {

		long arr[] = {1,2,1,2};

		System.out.println(getCountSubArray(arr, arr.length));


	}

	private static int getCountSubArray(long[] arr, int n) {
		int diff = 0;
		int ed[] = new int[n + 1];
		int od[] = new int[n + 1];
		ed[0] = 1;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if ((arr[i] & 1) == 1) {
				diff++;
			} else {
				diff--;
			}
			if (diff >= 0) {
				ans+=ed[diff];
				ed[diff]++;

			} else {
				ans+=od[-diff];
				od[-diff]++;
			}
		}

		return ans;
	}
}

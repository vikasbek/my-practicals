package com.sample.test;

public class Subset_sum {
	static int countStrings(int n) {
		int a[] = new int[n];
		int b[] = new int[n];
		a[0] = b[0] = 1;
		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}
		for(int i=0 ;i < n; i++) {
			System.out.print(a[i] + " ");	
		}
		System.out.println();
		for(int i=0 ;i < n; i++) {
			System.out.print(b[i] + " ");	
		}
		return a[n - 1] + b[n - 1];
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		System.out.println(countStrings(0));
	}
}

package com.sample.test.config.desing;

import java.util.Arrays;

public class SocietyConfig {

	public static void main(String[] args) {
		int n = 3, k = 1;
		int arr[] = {1, 2, 4};
		int j = 0;
		int profit = 0;
		for (int i = 0; i < k; i++) {

			int localMax = 0;
			int localMin = 0;

			while (j < n) {
				if (arr[j] < arr[j + 1]) {
					localMin = arr[j];
					break;
				}
				j++;
			}
			while (j < n) {
				if(j+1==n) {
					localMax=arr[j];
				}else if (arr[j] > arr[j + 1]) {
					localMax = arr[j];
					break;
				}
				j++;
			}

			profit += (localMax - localMin);
		}
		System.out.println(profit);

		//
		// int n = 5;
		// int a[] = {2,3,1,11,12};
		// int b[] = {4,5,10,12,13};
		// for (int i = 0; i < b.length; i++) {
		// a[i] = ;
		// b[i] = ;
		// }
		// Arrays.sort(a);
		// Arrays.sort(b);
		// int i = 0, j = 0, max = Integer.MIN_VALUE, count = 0;
		// while (i < n || j < n) {
		// if ((i < n && j < n)) {
		// if (a[i] < b[j]) {
		// i++;
		// count++;
		// if (max < count) {
		// max = count;
		// }
		// } else {
		// j++;
		// count--;
		// }
		// } else {
		// j++;
		// count--;
		// }
		// }
		// System.out.println(max);

		//
		// int n=2, m=2;
		// double dp[][] = new double[1003][1003];
		// for (int i = 0; i <=n; i++)
		// {
		// for (int j = 0; j <=m; j++)
		// {
		// if(i==0){ dp[i][j]=1; continue;}
		// if(j==0){ dp[i][j]=1; continue;}
		// dp[i][j]= i*1.0/(i+j)+ (j*1.0/(i+j))*((j-1)*1.0/(i+j-1))*dp[i][j-2];
		// }
		// }
		// System.out.format("%.6f\n",dp[n][m]);
		//

		// int day =100000000;
		// long[] rl = new long[1000000000000000000];
		// rl[0]=1;
		// rl[1]=2;
		// rl[2]=3;
		// for(int i=3;i<=day;i++){
		// rl[i]=rl[i-1] + rl[i-2];
		// }
		// System.out.println(((long)rl[day]));

		// int day=2;
		//
		// long a=1;
		// long b=2;
		// long c;
		// if(day==1){
		// b=a;
		// }
		// if(day==0){
		// b=1;
		// }
		// for(int i=3;i<=day;i++){
		// b=a+b;
		// c=b;
		// a=b;
		// // rl[i]=rl[i-1] + rl[i-2];
		// }
		// System.out.println(b);
		// testCase--;

		// changesetBit();
		// char[] c = {'a','b','c'};
		// printSequence(c);
		// int[] arr = {2,3,4,5,8};
		// countSubsetSumToK(arr, 9);
	}

	private static void countSubsetSumToK(int[] arr, int K) {
		int range = 1 << arr.length;
		int count = 0;
		for (int i = 1; i < range; i++) {
			count += rangeSum(arr, i, K);
		}
		System.out.println(count);
	}

	private static int rangeSum(int[] arr, int r, int k) {
		int count = 0;
		int i = 0;
		int sum = 0;
		while (r > 0) {
			if ((r & 1) > 0) {
				sum += arr[i];
			}
			r = r >> 1;
			i++;
		}
		if (sum == k) {
			count = 1;
		}
		return count;
	}

	private static void printSequence(char[] c) {
		int range = 1 << c.length;
		for (int i = 1; i < range; i++) {
			printSequenceOfrange(c, i);
		}
	}

	private static void printSequenceOfrange(char[] c, int r) {

		int i = 0;
		while (r > 0) {
			System.out.print((r & 1) > 0 ? c[i] : "");
			r = r >> 1;
			i++;
		}
		System.out.println();
	}

	private static void changesetBit() {
		int a = 13, b = 1;
		System.out.println(1 << b);
		System.out.println(a | (1 << b));
	}
}

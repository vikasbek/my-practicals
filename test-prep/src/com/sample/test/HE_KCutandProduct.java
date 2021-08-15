package com.sample.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HE_KCutandProduct {
	private static int MOD = 720720;

	public static void main(String[] args) throws IOException {
		//
		// 11
		// 560375 78934 183293 733272 380219 989164 553323 772278 689277 5744 655754
		// 5
		// long[] arr = {560375, 78934, 183293, 733272, 380219, 989164, 553323, 772278, 689277, 5744,
		// 655754};
		// int n = 11;
		// int k = 5;

		// calculateCutandProduct(arr, n, k);
		if(true) {
			System.out.println("if");
		}else if(true){
			System.out.println("elseif");
		}else {
			System.out.println("else");
		}
		long[] arr = {1, 2, 3, 4};
		calculateCutandProductDP(arr, arr.length, 3);

		// solution(a, 4 - 1, 2);
		// test();

	}

	private static void calculateCutandProductDP(long[] arr, int n, int k) {
		long[][] c = new long[n + 1][k + 1];
		long[][] s = new long[n + 1][k + 1];
		long A[] = new long[n + 1];
		long prod;

		for (int i = 1; i < n + 1; i++) {
			A[i] = arr[i - 1];
		}

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < k + 1; j++) {
				c[i][j] = 0;
				s[i][j] = 0;
			}
		}

		int j = 1;

		for (j = 1, prod = 1l; j < n + 1; j++) {
			c[j][0] = 1;
			prod = prod * arr[j - 1];
			s[j][0] = prod;
		}

		int x = 1;
		for (int i = 1; i < n + 1; i++) {
			for (j = 1; j < k + 1; j++) {
				if (j >= i) {
					c[i][j] = 0;
					s[i][j] = 0;
				} else {
					for (x = 1, prod = 1l; x <= i - j; x++) {
						c[i][j] = c[i - x][j - 1] + c[i][j];
						prod = prod * A[i - x + 1];
						s[i][j] = s[i - x][j - 1] + c[i - x][j - 1] * prod + s[i][j];
					}
				}
			}
		}
		System.out.println(s[n][k]);
	}

	private static void calculateCutandProduct(long[] arr, int n, int k) {
		long[][] mt = new long[arr.length][arr.length];
		for (int i = 0; i < n; i++) {
			mt[i][i] = arr[i];
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++)
				mt[i][j] = ((mt[i][j - 1] % MOD) * (arr[j] % MOD)) % MOD;
		}
		System.out.println(kCutandProduct(arr, 0, arr.length - 1, k, 0, mt));
	}

	private static long kCutandProduct(long[] arr, int s, int e, int k, long sum, long[][] mt) {

		if (k <= 0 && s <= e) {
			return (sum + mt[s][e]) % MOD;
		}
		long curr_sum = 0;
		int index = 1;
		for (int j = s; j <= e - k; j++) {
			curr_sum = (curr_sum + kCutandProduct(arr, s + index++, e, k - 1, mt[s][j] + sum, mt)) % MOD;
		}
		return curr_sum;
	}


	private static void solution(long[] a, int n, int k) {

		int i, j;
		int x = 0, y;
		long prod;
		int MOD = 720720;
		long[][] count = new long[n + 1][k + 1];
		long[][] sum = new long[n + 1][k + 1];
		for (i = 0; i <= n; i++)
			for (j = 0; j <= k; j++)
				count[i][j] = sum[i][j] = 0;

		for (i = 1, prod = 1; i <= n; i++) {
			prod = (prod * a[i]) % MOD;
			sum[i][0] = prod;
			count[i][0] = 1;
		}

		for (i = 1; i <= n; i++) {
			for (j = 1; j <= k; j++) {
				if (j > i - 1)
					sum[i][j] = count[i][j] = 0;
				else {
					for (x = 1, prod = 1l; x <= i - j; x++) {

						count[i][j] = (count[i - x][j - 1] + count[i][j]) % MOD;

						prod = (prod * a[i - x + 1]) % MOD;

						sum[i][j] = (sum[i][j] + count[i - x][j - 1] * prod + sum[i - x][j - 1]) % MOD;


					}
				}
			}
		}
		System.out.println(sum[n][k]);

	}

	public static void test() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n, i, j, k;
		int x, y;
		int MOD = 720720;;
		// 1000000007;
		String line = br.readLine();
		n = Integer.parseInt(line);
		long[] a = new long[n + 1];
		long prod;
		line = br.readLine();
		String[] ar = line.split("\\s+");
		x = 0;
		for (i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(ar[x++]);
		}
		x = 0;
		line = br.readLine();
		k = Integer.parseInt(line);


		long[][] count = new long[n + 1][k + 1];
		long[][] sum = new long[n + 1][k + 1];
		for (i = 0; i <= n; i++)
			for (j = 0; j <= k; j++)
				count[i][j] = sum[i][j] = 0;

		for (i = 1, prod = 1; i <= n; i++) {
			prod = (prod * a[i]) % MOD;
			sum[i][0] = prod;
			count[i][0] = 1;
		}

		for (i = 1; i <= n; i++) {
			for (j = 1; j <= k; j++) {
				if (j > i - 1)
					sum[i][j] = count[i][j] = 0;
				else {
					for (x = 1, prod = 1l; x <= i - j; x++) {

						count[i][j] = (count[i - x][j - 1] + count[i][j]) % MOD;

						prod = (prod * a[i - x + 1]) % MOD;

						sum[i][j] = (sum[i][j] + count[i - x][j - 1] * prod + sum[i - x][j - 1]) % MOD;


					}
				}
			}
		}

		/*
		 * for(i=1,prod =1;i<=n;i++) { prod = (prod*a[i]); sum[i][0] = prod; count[i][0] = 1; }
		 * 
		 * for(i=1;i<=n;i++) { for(j=1;j<=k;j++) { if(j>i-1) sum[i][j] = count[i][j] = 0; else {
		 * for(x=1,prod=1l;x<=i-j;x++) {
		 * 
		 * count[i][j] = (count[i-x][j-1] + count[i][j]);
		 * 
		 * prod = (prod * a[i-x+1] );
		 * 
		 * sum[i][j] = (sum[i][j] + count[i-x][j-1]*prod + sum[i-x][j-1]);
		 * 
		 * 
		 * } } } }
		 */

		System.out.println(sum[n][k]);

	}


}

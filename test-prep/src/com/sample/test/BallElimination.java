package com.sample.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BallElimination {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] inp = br.readLine().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(inp[i]);
		}
		int[][] dp = new int[N + 1][N + 1];
		// stores min cost for substring i...j
		for (int x = 0; x <= N; x++)
			Arrays.fill(dp[x], 999999);

		for (int l = 0; l < N; l++) {
			dp[l][l] = 1;
		}
		for (int l = 1; l < N; l++) {
			if (arr[l] == arr[l - 1])
				dp[l - 1][l] = 0;
			else
				dp[l][l + 1] = 2;
		}

		for (int l = 3; l <= N; l++) { // for all substrings of length 3 to N
			for (int i = 0; i < N; i++) { // for all starting indices
				int j = i + l - 1; // j is ending index
				if (j > N - 1)
					continue;
				if (arr[i] == arr[j]) {
					dp[i][j] = dp[i + 1][j - 1];
				} else {
					for (int k = i; k < j; k++) {
						dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
					}
				}
			}
		}
		System.out.println(dp[0][N - 1]);
	}

	public static String modifyString(String S) {

		// this is default OUTPUT. You can change it.
		String result = "";

		// write your Logic here:
		for (int i = 0; i < S.length(); i++) {
			
			
		}

		return result;
	}
	
	
}

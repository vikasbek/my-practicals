package com.sample.test;

public class Fibonacci {
	static int mod = 1000000007;

	static long fib(long n) {
		n = n + 2;
		long F[][] = new long[][] {{1, 1}, {1, 0}};
		if (n == 0)
			return 0;
		power(F, n - 1);

		return F[0][0];
	}

	/*
	 * Helper function that multiplies 2 matrices F and M of size 2*2, and puts the multiplication
	 * result back to F[][]
	 */
	static void multiply(long F[][], long M[][]) {
		long x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
		long y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
		long z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
		long w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

		F[0][0] = x % mod;
		F[0][1] = y % mod;
		F[1][0] = z % mod;
		F[1][1] = w % mod;
		System.out.println(x + " " + x % mod +" "+  y + " " + y % mod + " "+ z + " " + z % mod + " " +w + " " + w % mod);
	}

	/*
	 * Helper function that calculates F[][] raise to the power n and puts the result in F[][] Note
	 * that this function is designed only for fib() and won't work as general power function
	 */
	static void power(long F[][], long n) {
		if (n == 0 || n == 1)
			return;
		long M[][] = new long[][] {{1, 1}, {1, 0}};

		power(F, n / 2);
		multiply(F, F);

		if (n % 2 != 0)
			multiply(F, M);
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		long n = 5;
		System.out.println(fib(n));
	}
}
/* This code is contributed by Rajat Mishra */

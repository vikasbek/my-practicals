package com.sample.test;

public class PromoTest {

	public static void main(String[] args) {
		long[][] resultantArray = new long[3][10];
		for (int i = 0; i < resultantArray.length; i++) {
			for (int j = 0; j < resultantArray[i].length; j++) {
				resultantArray[i][j] = i + j;
			}
		}
		int cnt = 1;
		for (int j = 0; j < resultantArray[0].length; j++) {
			resultantArray[0][j] = cnt++;
		}

		cnt = 1;
		for (int i = 0; i < resultantArray.length; i++) {
			resultantArray[i][0] = cnt++;
		}

		for (int i = 1; i < resultantArray.length; i++) {
			for (int j = 1; j < resultantArray[i].length; j++) {
				Long result = resultantArray[i - 1][j] + resultantArray[i][j - 1] - resultantArray[i - 1][j - 1] + Math.min(i + 1, j + 1);
				resultantArray[i][j] = result;
			}
		}
		for (int i = 0; i < resultantArray.length; i++) {
			for (int j = 0; j < resultantArray[i].length; j++) {
				System.out.print(resultantArray[i][j] + " ");
			}
			System.out.println();
		}
	}
}

package com.sample.test;

import java.util.ArrayList;
import java.util.List;

public class SubSetMaxSumWhereDigitsNotSame {

	public static void main(String[] args) {

		// List<Integer> list = new ArrayList<>();
		// list.add(2);
		// list.add(12);
		// list.add(3);
		// list.add(54);
		//
		String xy = "74654 55812 57734 80295 95827 65072 45838 60883 74288 90423 68739 87389 17959 51731 10131 61002 46236 99905 22291 58610 16514 85844 38582 20664 85687 13907 96005 22315 94857 62527 95235 10593 12517 71470 72127 29060 43577 86142 29975 83557 90567 90429 80090 36247 49598 35243 48692 89173 87760 85705 15090 80418 34376 36545 66877 62426 91830 30423 64570 51238 44489 46465 69950 96826 85315 44260 32673 75459 14602 92998 73488 47911 78763 94014 82888 61274 94861 30344 10025 77992 68989 30645 87456 30781 79390 46198 44617 50498 98594 81131 76445 28645 30060 75529 95659 87509 11825 28998 67093 83455";
		String [] a = xy.split(" ");
		
		System.out.println(getMaxSum("100", a));

	}

	static boolean hasSameChar(String aS, String bS) {
		for (int i = 0; i < aS.toString().length(); i++) {
			for (int j = 0; j < bS.toString().length(); j++) {
				if (aS.charAt(i) == bS.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}

	private static Long getMaxSum(String N, String[] lis) {
		Long[] dp = new Long[lis.length];
		List<String> containedString = new ArrayList<>();
		for (int i = 0; i < lis.length; i++) {
			dp[i] = Long.valueOf(lis[i]);
		}
		for (int i = 0; i < lis.length; i++) {
			containedString.add(String.valueOf(lis[i]));
		}
		// 1 5 12 4 45 23
		// 1 6 17
		// 1 15 512

		for (int j = 1; j < lis.length; j++) {
			for (int i = 0; i < j; i++) {
				if (!hasSameChar(lis[i], lis[j]) && dp[j] < Long.valueOf(lis[j] + lis[i])) {
					containedString.set(j, containedString.get(j) + lis[i]);
					dp[j] = Long.valueOf(lis[j] + lis[i]);
				}else if(!hasSameChar(containedString.get(i), lis[j]) && dp[j] < Long.valueOf(dp[j] + lis[i])) {
					containedString.set(j, containedString.get(j) + containedString.get(i));
					dp[j] = Long.valueOf(lis[j] + lis[i]);
				}

			}
		}
		Long max = Long.MIN_VALUE;
		for (int j = 0; j < lis.length; j++) {
			if (dp[j] > max) {
				max = dp[j];
			}
		}

		return max;
	}
}

/*
100
74654 55812 57734 80295 95827 65072 45838 60883 74288 90423 68739 87389 17959 51731 10131 61002 46236 99905 22291 58610 16514 85844 38582 20664 85687 13907 96005 22315 94857 62527 95235 10593 12517 71470 72127 29060 43577 86142 29975 83557 90567 90429 80090 36247 49598 35243 48692 89173 87760 85705 15090 80418 34376 36545 66877 62426 91830 30423 64570 51238 44489 46465 69950 96826 85315 44260 32673 75459 14602 92998 73488 47911 78763 94014 82888 61274 94861 30344 10025 77992 68989 30645 87456 30781 79390 46198 44617 50498 98594 81131 76445 28645 30060 75529 95659 87509 11825 28998 67093 83455
250017
 * */

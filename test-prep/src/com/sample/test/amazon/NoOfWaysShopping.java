package com.sample.test.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class NoOfWaysShopping {
	public static long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes,
			List<Integer> priceOfSkirts, List<Integer> priceOfTops, int dollars) {

		int[][] countArray = new int[dollars][4];

		for (int i = 1; i < dollars; i++) {
			int jeanscount = 0;
			int shoescount = 0;
			int skirtscount = 0;
			int topscount = 0;
			int dollarsTemp = dollars;
			for (int jeans = 0; jeans < priceOfJeans.size(); jeans++) {
				if (priceOfJeans.get(jeans) <= dollarsTemp) {
					countArray[i][0] += 1;
				}
			}
			for (int jeans = 0; jeans < priceOfShoes.size(); jeans++) {
				if (priceOfShoes.get(jeans) <= dollarsTemp) {
					countArray[i][1] += 1;
				}
			}
			for (int jeans = 0; jeans < priceOfSkirts.size(); jeans++) {
				if (priceOfSkirts.get(jeans) <= dollarsTemp) {
					countArray[i][2] += 1;
				}
			}
			for (int jeans = 0; jeans < priceOfTops.size(); jeans++) {
				if (priceOfTops.get(jeans) <= dollarsTemp) {
					countArray[i][3] += 1;
				}
			}
		}

		return 3;
	}

	public static int countGroups(List<String> related) {
		// Write your code here
		
		char[][] darr = new char[related.size()][related.get(0).length()];
		for (int i = 0; i < related.size(); i++) {
			darr[i] = related.get(i).toCharArray();
		}
		int groups = 0;
		Map<Integer,Integer> groupMap = new HashMap<>(); 
		for (int i = 0; i < darr.length; i++) {
			for (int j = 0; j <= i; j++) {
//				if(i==j) {
//					continue;
//				}
				if(darr[i][j]==darr[j][i] && darr[i][j]=='1') {
//					groups ++;
					if(groupMap.containsKey((Integer) j)) {
						groupMap.put((Integer) i, groupMap.get(j));
					} else {
						groupMap.put((Integer) i, (Integer)i);						
					}
				}
				
			}
		}
		Collection<Integer> values = groupMap.values();
		Stream<Integer> dis = values.stream().distinct();
		System.out.println(dis.count());
		return groups;
	}

	public static void main(String[] args) {
//		problem1();
		List<String> list = new ArrayList<String>();
		list.add("1100");
		list.add("1110");
		list.add("0110");
		list.add("0001");
		countGroups(list);
	}

	private static void problem1() {
		Integer[] jeansPrice = { 2, 3 };
		Integer[] shoesPrice = { 4 };
		Integer[] skirtsPrice = { 2, 3 };
		Integer[] topsPrice = { 1, 2 };
		getNumberOfOptions(Arrays.asList(jeansPrice), Arrays.asList(shoesPrice), Arrays.asList(skirtsPrice),
				Arrays.asList(topsPrice), 10);
	}
}

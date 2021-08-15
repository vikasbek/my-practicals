package com.sample.test.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class FindMostFrequent {

	public static List<String> findMostFrequent(String helpText, List<String> wordsToExclude) {

		String[] helpTextStrArray = helpText.trim().split("[ '.]");
		Map<String, Integer> excludedInMem = new HashMap<>();
		for (String exe : wordsToExclude) {
			excludedInMem.put(exe.toLowerCase(), 1);
		}
		List<String> result = new ArrayList<String>();
		Map<String, Integer> resultMap = new HashMap<>();

		for (String text : helpTextStrArray) {
			if (!excludedInMem.containsKey(text.toLowerCase())) {
				Integer value = Objects.isNull(resultMap.get(text.toLowerCase())) ? 0
						: resultMap.get(text.toLowerCase());
				resultMap.put(text.toLowerCase(), value + 1);
			}
		}

		Optional<Integer> maxNumber = resultMap.values().stream().max((i, j) -> i.compareTo(j));

		for (String str : resultMap.keySet()) {
			if (resultMap.get(str) == maxNumber.get()) {
				result.add(str);
			}
		}
		result.sort((p1, p2) -> p1.compareTo(p2));
		return result;
	}

	public static void main(String[] args) {
//		String helpText = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.";
//		String[] exlist = { "is", "are", "a" };
//		List<String> exclude = Arrays.asList(exlist);
//
//		System.out.println(findMostFrequent(helpText, exclude));
		
//	    public static void main(String[] args) {
			int sum = 0 ;
			int i=0;
			while(i<100) {
				sum = sum + i;
				sum = i + sum;
				i+=1;
				
			}
			System.out.println(sum);
//		}
	}
}

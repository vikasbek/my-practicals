package com.sample.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SequencePrint {

	/**
	 * aaa aab aac aad . . . . aax aay aaz baa bab bac . .... zzy zzz
	 * 
	 * 
	 */
	public static void printSequence(char[] word, int from) {
		if (from >= word.length) {
			System.out.println(word);
			return;
		}
		for (char i = 'a'; i <= 'z'; i++) {
			word[from] = i;
			printSequence(word, from + 1);
		}
	}

	public static void main(String[] args) {
		print(3);
		List<Integer> res = new ArrayList<>();
//		res.sort(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				if
//				return 0;
//		
//		Collections.sort(res);
//		Map<Integer, List<Integer>> empMap = new HashMap<>();
//		for(List<Integer> listMap: empMap.set) {
//			
//			
//		}
	}

	private static void print(int n) {

		char[] word = new char[n];
		Arrays.fill(word, 'a');

		printSequence(word, 0);


	}

}

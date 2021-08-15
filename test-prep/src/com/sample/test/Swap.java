package com.sample.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
class Person{
	
	
}

public class Swap {
	public static void main(String[] args) {
		Supplier<Person> personSupplier = ()-> new Person();
		Supplier<Person> personSupplier2 = ()-> {
			System.out.println();
			return new Person();
			};
		List<Person> plist = new ArrayList<>();
		plist.forEach((p)->{
			
			
			
			
		});
		
		
		
		swap("INDIAN", "ARMY");

		boolean isAnagram = isAnagram("ARMY", "MARY");
		System.out.println(isAnagram);
	}

	private static boolean isAnagram(String string, String string2) {
		if (string.length() != string2.length()) {
			return false;
		}
		int arr[] = new int[26];

		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			arr[c -'A'] += 1;
		}
		for (int i = 0; i < string2.length(); i++) {
			char c = string2.charAt(i);
			arr[c- 'A'] -= 1;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				return false;
			}
		}

		return true;
	}

	static void swap(String x, String y) {
		System.out.println("x=" + x + " y=" + y);
		y = new String(y + "|" + x);
		x = y.split("[|]")[0];
		y = y.split("[|]")[1];
		System.out.println("x=" + x + " y=" + y);
	}

}

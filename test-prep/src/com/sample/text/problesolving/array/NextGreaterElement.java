package com.sample.text.problesolving.array;

import java.util.Stack;



public class NextGreaterElement {


	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int arr[] = {15, 14, 13, 12, 11, 10};
//		printNGE(arr, arr.length);
//		// Set<Integer> set = new HashSet<>();
//		TreeSet<Integer> set = new TreeSet<>();
//		set.add(12);
//		set.add(13);
//		set.add(11);
//		set.add(10);
//		set.add(9);
//		set.add(14);
//		set.add(15);
//		set.add(19);
//		System.out.println(set.ceiling(11));
	}


	/**
	 * @param arr
	 * @param length
	 * 
	 *        traverse element from last and put last element of array in stack and
	 * 
	 * 
	 */
	private static void printNGE(int[] arr, int length) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[length - 1]);
		int arrRes[] = new int[length];
		arrRes[length - 1] = -1;
		for (int i = length - 2; i >= 0; i--) {
			if (stack.peek() > arr[i]) {
				arrRes[i] = stack.peek();
				stack.push(arr[i]);
			} else {
				while (!stack.empty() && stack.peek() < arr[i]) {
					stack.pop();
				}
				if (!stack.empty()) {
					arrRes[i] = stack.peek();
					stack.push(arr[i]);
				} else {
					arrRes[i] = -1;
					stack.push(arr[i]);
				}
			}
		}

		for (int i = 0; i < arrRes.length; i++) {
			System.out.print(arrRes[i] + " ");
		}

	}
}

package com.sample.test;

import java.util.Stack;

public class Find132Pattern {

	// public static boolean find132pattern(int[] nums) {
	// if (nums.length < 3)
	// return false;
	// Stack<Integer> stack = new Stack<>();
	// int[] min = new int[nums.length];
	// min[0] = nums[0];
	// for (int i = 1; i < nums.length; i++)
	// min[i] = Math.min(min[i - 1], nums[i]);
	// for (int j = nums.length - 1; j >= 0; j--) {
	// if (nums[j] > min[j]) {
	// while (!stack.isEmpty() && stack.peek() <= min[j])
	// stack.pop();
	// if (!stack.isEmpty() && stack.peek() < nums[j])
	// return true;
	// stack.push(nums[j]);
	// }
	// }
	// return false;
	// }

	public static boolean find132pattern(int[] nums) {
		if (nums.length < 3) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int[] min = new int[nums.length];
		min[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			min[i] = Math.min(nums[i], min[i - 1]);
		}
		for (int j = nums.length - 1; j >= 0; j--) {
			if (min[j] < nums[j] && (stack.isEmpty() || stack.peek() > nums[j])) {
				stack.push(nums[j]);
			}
			while (min[j] < nums[j] && !stack.isEmpty() && stack.peek() <= min[j]) {
				stack.pop();
			}
			if (!stack.isEmpty() && nums[j] > min[j] && stack.peek() < nums[j]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// int[] nums = {-1, 3, 2, 0};
		// int[] nums = {1, 2, 3, 4};
		// int[] nums = {3,1,4,2};
		// int[] nums = {4,3,2,2,1};
		// int[] nums = {6,12,3,4,6,11,20};
		// int[] nums = {6,15,16,12,3,4,6,11,20};
		// int[] nums = {1, 0, 1, -4, -3};
		int[] nums = {10, 15, 5, 16, 70, 14};
		System.out.println(find132pattern(nums));
	}
}

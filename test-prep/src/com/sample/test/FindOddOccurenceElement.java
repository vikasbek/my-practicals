package com.sample.test;

public class FindOddOccurenceElement {
// Java program to find the element 
// that appears odd number of time 
	// A Binary Search based function to find 
	// the element that appears odd times 
	static void search(int arr[], int low, int high) 
	{ 
		// Base cases 
		if (low > high) 
		return; 
		if (low == high) 
		{ 
			System.out.printf("The required element is %d "
							, arr[low]); 
			return; 
		} 
	
		// Find the middle point 
		int mid = (low + high)/2; 
	
		// If mid is even and element next to mid is 
		// same as mid, then output element lies on 
		// right side, else on left side 
		if (mid % 2 == 0) 
		{ 
			if (arr[mid] == arr[mid + 1]) 
				search(arr, mid + 2, high); 
			else
				search(arr, low, mid); 
		} 
		
		// If mid is odd 
		else
		{ 
			if (arr[mid] == arr[mid - 1]) 
				search(arr, mid + 1, high); 
			else
				search(arr, low, mid - 1); 
		} 
	} 
	
	// Driver program 
	public static void main(String[] args) 
	{ 
//		int arr[] = {1, 1, 2, 2, 1, 1, 2, 2, 13, 
//									1, 1, 40, 40}; 
		int  arr[] = {1, 1, 2, 2, 1,2,2, 1, 13};
		 
		int len = arr.length; 
		search(arr, 0, len-1); 
	} 
} 
// This code is contributed by 
// Smitha DInesh Semwal 

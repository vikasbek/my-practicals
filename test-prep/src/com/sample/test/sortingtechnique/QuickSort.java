package com.sample.test.sortingtechnique;

public class QuickSort {
	
	
	
	
	public static void main(String[] args) {
//		int[] arr = {1,11, 5, 3, 8, 2, 6};
		int[] arr = {11,10,9,9,8,7,6,8,5,4,3,2};
		
		quicksort2(arr, 0, arr.length -1);
		print(arr);
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	private static void quickSort(int[] arr, int s, int e) {
		if(s<e) {
			int p = partition(arr, s, e);
			quickSort(arr, s, p-1);
			quickSort(arr, p+1, e);
		}
	}

	private static int partition(int[] arr, int s, int e) {
		int pivot = arr[e];
		int lowerValueIndex=s-1;
		for(int j=s;j<e;j++) {
			if(arr[j]<pivot) {
				lowerValueIndex++;
				int temp = arr[j];
				arr[j]=arr[lowerValueIndex];
				arr[lowerValueIndex] = temp;
			}
		}
		lowerValueIndex++;
		int temp = arr[lowerValueIndex];
		arr[lowerValueIndex] = arr[e];
		arr[e] = temp;
		return lowerValueIndex;
	}
	
	private static void quicksort2(int[] arr, int s, int e) {
		if(s<e) {
			int pivot = partition2(arr, s, e);
			quicksort2(arr, s, pivot - 1);
			quicksort2(arr, pivot+1, e);
		}
		
		
	}

	private static int partition2(int[] arr, int s, int e) {
		int pivot = arr[e];
		int pi = s-1;
		int temp = -1;
		for(int f=s;f<e;f++) {
			if(arr[f]<pivot) {
				pi++;
				temp = arr[f];
				arr[f]=arr[pi];
				arr[pi]=temp;
			}
		}
		pi++;
		temp=arr[pi];
		arr[pi]= pivot;
		arr[e]=temp;
		return pi;
	}

}

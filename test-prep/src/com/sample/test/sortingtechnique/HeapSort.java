package com.sample.test.sortingtechnique;

public class HeapSort {


	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 8, 2, 6};
		maxHeapSort(arr);
		minHeapSort(arr);
	}
	
	private static void minHeapSort(int[] arr) {
		
		for(int i=arr.length-1/2;i>-1;i--) {
			minHeapify(arr, arr.length, i);
		}
		for(int i=arr.length -1;i>-1;i--) {
			int t=arr[i];
			arr[i]=arr[0];
			arr[0]=t;
			minHeapify(arr, i, 0);
		}
		print(arr);
	}

	private static void minHeapify(int[] arr, int length, int i) {
		int min = i;
		int l=2*i+1;
		int r=2*i+2;
		if(length> i) {
			if(l<length && arr[l]<arr[min]) {
				min=l;
			}
			if(r<length && arr[r] < arr[min]) {
				min =r;
			}
			if(min!=i) {
				int t=arr[min];
				arr[min]=arr[i];
				arr[i]=t;
				minHeapify(arr, length, min);
			}
		}
		
	}
	
	private static void maxHeapSort(int[] arr) {
		for (int i = arr.length / 2;i>-1; i--) {
			maxHeapify(arr, arr.length, i);
		}
//		for (int i = 0; i < arr.length; i++) {
//			int t = arr[i];
//			arr[i] = arr[arr.length - i - 1];
//			arr[arr.length - i - 1] = t;
//			maxHeapify(arr, arr.length - i - 1, (arr.length - i - 2)/2-1);
//		}
		for (int i = arr.length-1; i >=0; i--) {
			int t = arr[i];
			arr[i] = arr[0];
			arr[0] = t;
			maxHeapify(arr, i, 0);
		}

		print(arr);
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void maxHeapify(int[] arr, int length, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (i < length) {
			if (l < length && arr[l] > arr[largest]) {
				largest = l;
			}
			if (r < length && arr[r] > arr[largest]) {
				largest = r;
			}
			if (largest != i) {
				int temp = arr[largest];
				arr[largest] = arr[i];
				arr[i] = temp;
				maxHeapify(arr, length, largest);
			}
		}
		
	}

}

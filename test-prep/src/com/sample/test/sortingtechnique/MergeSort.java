package com.sample.test.sortingtechnique;

public class MergeSort {


	public static void main(String[] args) {

		int arr[] = {4, 3, 2, 8, 4, 6, 7};
		sort(arr, arr.length);
		print(arr);

	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void sort(int[] arr, int length) {
		MergeSort(arr, 0, length - 1);
	}

	private static void MergeSort(int[] arr, int s, int e) {
		if (s < e) {
			int m = (s + e) / 2;
			MergeSort(arr, s, m);
			MergeSort(arr, m + 1, e);
			merge(arr, s, m, e);
		}
	}

	private static void merge(int[] arr, int s, int m, int e) {
		int ll = m - s;
		int rl = e - m - 1;

		int[] L = new int[ll + 1];
		int[] R = new int[rl + 1];
		for (int i = 0; i <= ll; i++) {
			L[i] = arr[s + i];
		}
		for (int i = 0; i <= rl; i++) {
			R[i] = arr[m + i + 1];
		}

		int i = 0;
		int j = 0;
		int k = s;
		while (i <= ll && j <= rl) {
			if (L[i] <= R[j]) {
				arr[k++] = L[i];
				i++;
			} else {
				arr[k++] = R[j];
				j++;
			}

		}
		while (i <= ll) {
			arr[k++] = L[i++];
		}
		while (j <= rl) {
			arr[k++] = R[j++];
		}
	}
}

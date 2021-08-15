package com.sample.test;

import java.io.IOException;
import java.util.Scanner;

public class PowerFullIndex {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String testcase =s.nextLine();
		int count = Integer.parseInt(testcase);
       while(count>0) {
      	 String size = s.nextLine();
      	 String arrayString = s.nextLine();
      	 String[] array = arrayString.split(" ");
      	 int maxIndex=0;
      	 int maxSum=0;
      	 for(int i=0;i<array.length;i++) {
      		 int sl=findSmallestLeft(array, i);
      		 int sr=findSmallestRight(array, i);
      		 int gl=findGreatestLeft(array, i);
      		 int gr=findGreatestRight(array, i);
      		 int temp=sl+sr+gl+gr;
      		 if(maxSum<temp) {
      			 maxSum=temp;
      			 maxIndex = i;
      		 }
      		 
      	 }
      	 System.out.println(maxIndex);
      	 count--;
       } 
	}

	private static int findGreatestRight(String[] array, int index) {
		int count=0;
		for(int i=index;i<array.length;i++) {
			if(Integer.parseInt(array[index]) < Integer.parseInt(array[i])) {
				count++;
			}
		}
		return count;
	}

	private static int findGreatestLeft(String[] array, int index) {
		int count=0;
		for(int i=0;i<index;i++) {
			if(Integer.parseInt(array[index]) < Integer.parseInt(array[i])) {
				count++;
			}
		}
		return count;
	}

	private static int findSmallestRight(String[] array, int index) {
		int count=0;
		for(int i=index;i<array.length;i++) {
			if(Integer.parseInt(array[index]) > Integer.parseInt(array[i])) {
				count++;
			}
		}
		return count;
	}

	private static int findSmallestLeft(String[] array, int index) {
		int count=0;
		for(int i=0;i<index;i++) {
			if(Integer.parseInt(array[index]) > Integer.parseInt(array[i])) {
				count++;
			}
		}
		return count;
	}

}

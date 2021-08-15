package com.sample.text.problesolving.array;

	/*package whatever //do not write package name here */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

	public class TwoElementSumEqualK {
		public static void main (String[] args) {
			//code
			Scanner sc = new Scanner(System.in);
			if(sc.hasNext()){
			    int testCase = Integer.parseInt(sc.nextLine());
			    while(testCase >0){
			        String case1 = sc.nextLine();
			        int caseArray[] = Arrays.stream(case1.split(" ")).mapToInt(Integer::parseInt).toArray();
			        int size = caseArray[0];
			        int X = caseArray[1];
			        String arrayString = sc.nextLine();
			        int array[] = Arrays.stream(arrayString.split(" ")).mapToInt(Integer::parseInt).toArray();
			        System.out.println(printResult(size, array, X));
			        testCase--;
			    }
			    
			}
		}
		
		
		public static String printResult(int size, int[] array, int k) {
		   HashMap<Integer, Integer> map = new HashMap<>(); 
//		   int i=0, j=size-1;
//		   while(i<j){
//		       if((array[i] + array[j]) == k){
//		      	 map.put(key, value)
//		           return "Yes";
//		       }else if((array[i] + array[j]) < k){
//		           i++;
//		       }else{
//		           j--;
//		       }
//		   }
		   for(int i=0;i<size;i++) {
		   	if(map.containsKey(array[i])) {
		   		return "Yes";
		   	}else {
		   		map.put(k-array[i], k-array[i]);
		   	}
		   }
		    
		    return "No";
		}
		
	}
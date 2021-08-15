package com.sample.test;

public class PrintSequence {
	
	public static void find(char arr[][] , int n , String s, int index){
		   if(n == 0){
//		       cout<<s<<endl;
			   System.out.println(s);
		       return;
		   }
		   for(int i = 0 ; i < 26; i++){
//		       s[index]= arr[n][i];
		       find(arr, n -1 , s, index + 1);
		       //s.pop_back();
		   }
		}

	
	public static void main(String[] args) {
		int n = 6;
		//cin>>n;
		char arr[][] = new char[n][26];
		for(int i = 0; i < n ; i++){
		   for(int j = 0 ; j < 26 ; j++){
		       arr[i][j] = (char) (j + 'a');
		       //cout<<arr[i][j]<<" ";
		   }
		}
		String str = "        ";
		find(arr , n-1 , str, 0);
	}

}

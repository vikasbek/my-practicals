package com.sample.test;

import java.util.ArrayList;
import java.util.List;

public class Wendy {
   public static String removeColor(String colors, char c){

      for(int i=1;i<colors.length() - 1 ; i++){
          if(c == colors.charAt(i-1) && colors.charAt(i-1) == colors.charAt(i+1) ){
              String first=colors.substring(0, i);
              String second = colors.substring(i+1, colors.length());
              return first+second;
          }
      }
      return colors;
  }
  public static String gameWinner(String colors) {

          String player1 = "wendy";
          String player2 = "bob";
          boolean p1Chance = true;

          String remainingColors = colors;
//          p1Chance=false;
          while(true){
              if(p1Chance){
                  remainingColors = removeColor(colors, 'w');
                  p1Chance=false;
                  if(remainingColors.equals(colors)){
                      break;
                      //return player2;
                  }
                  
              }else{
                 remainingColors = removeColor(colors, 'b'); 
                 p1Chance=true;
                 if(remainingColors.equals(colors)){
                      break;
                      //return player1;
                  }
              }
              colors = remainingColors;
          }

          if(p1Chance){
              return player1;
          } else{
              return player2;
          }
  }

	public static void main(String[] args) {
//		int[] temp = new int[4];
//		int[] temp2 = new int[temp.length];
//		
//		System.out.println(gameWinner("wwwbbb"));
System.out.println(countPalindrome("dskjkd"));
	}
	
	public static int countPalindrome(String str) {
		List<String> palindrome = new ArrayList<>();
		for(int i=0;i<str.length();i++) {
			for(int j=0;j<=i;j++) {
				String subString = str.substring(j, i+1);
				if(isPalindrome(subString)) {
					palindrome.add(subString);
				}
			}
		}
		
		System.out.println(palindrome);
		return palindrome.size();
	}

	private static boolean isPalindrome(String subString) {
		boolean isPalindrome = true;
		for (int i = 0, j = subString.length() - 1; i <= j; i++, j--) {
			if (subString.charAt(i) != subString.charAt(j)) {
				isPalindrome = false;
			}
		}
		return isPalindrome;
	}

}

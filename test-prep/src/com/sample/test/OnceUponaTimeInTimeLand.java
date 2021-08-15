package com.sample.test;
/* IMPORTANT: Multiple classes and nested static classes are supported */

//import for Scanner and other utility classes
import java.util.Arrays;
import java.util.Scanner;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail


public class OnceUponaTimeInTimeLand {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        int testcase = Integer.parseInt(name);
        while(testcase>0){
            String l1 = s.nextLine();
            Integer [] arrl1 = Arrays.stream(l1.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            int n = arrl1[0];
            int k = arrl1[1];
            Long [] arr = Arrays.stream(s.nextLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);
            long [] dp = new long[n];
   			long maxi = 0;
   			for(int i=0;i<=k;i++){
   				dp[i]=Math.max(dp[i], arr[i-1]);
   			}
   			
   			for(int i=k+1;i<=n;i++){
   				dp[i]=Math.max(dp[i-k-1]+arr[i-1],arr[i-1]);
   				dp[i]=Math.max(dp[i],dp[i-1]);
   				maxi=Math.max(maxi, dp[i]);
   			}
   			for(int i=0;i<=n;i++){
   				System.out.print(dp[i] + " ");
   			}
   			System.out.println();
   			System.out.println(maxi);
            testcase--;
        }
        

        // Write your code here

    }


}

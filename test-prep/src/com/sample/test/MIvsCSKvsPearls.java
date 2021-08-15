package com.sample.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class MIvsCSKvsPearls {
    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long K = Integer.parseInt(input[1]);
        long arr[] = new long[N];
//        long dp[] = new long[N+1];
        input = in.readLine().split(" ");
        for(int i = 0 ; i<N ; i++){
            arr[i] = Long.parseLong(input[i]);
        }
 
        long prev = 0;
        long minPriceTillNow = arr[0];
 
        for(int i = 2; i<=N ; i++){
 
            if(arr[i-2] < minPriceTillNow){
                minPriceTillNow = arr[i-2];
            }
 
            prev = Math.max(prev,arr[i-1]-minPriceTillNow);
        }
 
        System.out.println(prev*K);
    }
}
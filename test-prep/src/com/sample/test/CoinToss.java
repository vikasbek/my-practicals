package com.sample.test;

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
 
class CoinToss {
    private static final long MOD = 1000000007;
    public static void main(String args[] ) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
// 
//        int testCases = Integer.parseInt(str);
//        long testArr[] = new long [testCases];
        long cur = 4l;
//        for(int i = 0; i < testCases ; i++) {
//            cur = Long.parseLong(br.readLine());
//            System.out.println(Math.pow(2, cur)- fib(cur));
            System.out.println(fib(cur));
//        }
    }
    
    static long fib(long n) 
    { 
    long F[][] = new long[][]{{1L,1L,1L},{1L,0L,0L},{0L,1L,0L}}; 
    if (n == 0) 
        return 0L;
    if ( n == 1)
        return 2L;
    if ( n == 2)
        return 4L;
    if ( n == 3)
        return 7L;
        
    power(F, n-3); 
       
    return ((F[0][0] * 7)%MOD + (F[0][1] * 4)%MOD + (F[0][2] * 2)%MOD)%MOD; 
    } 
       
    static void multiply(long F[][], long M[][]) 
    { 
    long a1 =  (F[0][0]*M[0][0])%MOD + (F[0][1]*M[1][0])%MOD + (F[0][2]*M[2][0])%MOD; 
    long a2 =  (F[0][0]*M[0][1])%MOD + (F[0][1]*M[1][1])%MOD + (F[0][2]*M[2][1])%MOD; 
    long a3 =  (F[0][0]*M[0][2])%MOD + (F[0][1]*M[1][2])%MOD + (F[0][2]*M[2][2])%MOD; 
    long b1 =  (F[1][0]*M[0][0])%MOD + (F[1][1]*M[1][0])%MOD + (F[1][2]*M[2][0])%MOD; 
    long b2 =  (F[1][0]*M[0][1])%MOD + (F[1][1]*M[1][1])%MOD + (F[1][2]*M[2][1])%MOD; 
    long b3 =  (F[1][0]*M[0][2])%MOD + (F[1][1]*M[1][2])%MOD + (F[1][2]*M[2][2])%MOD; 
    long c1 =  (F[2][0]*M[0][0])%MOD + (F[2][1]*M[1][0])%MOD + (F[2][2]*M[2][0])%MOD; 
    long c2 =  (F[2][0]*M[0][1])%MOD + (F[2][1]*M[1][1])%MOD + (F[2][2]*M[2][1])%MOD; 
    long c3 =  (F[2][0]*M[0][2])%MOD + (F[2][1]*M[1][2])%MOD + (F[2][2]*M[2][2])%MOD; 
      
    F[0][0] = a1%MOD; 
    F[0][1] = a2%MOD; 
    F[0][2] = a3%MOD; 
    F[1][0] = b1%MOD; 
    F[1][1] = b2%MOD; 
    F[1][2] = b3%MOD; 
    F[2][0] = c1%MOD; 
    F[2][1] = c2%MOD; 
    F[2][2] = c3%MOD; 
    }
    
    static void power(long F[][], long n) 
    { 
    if( n == 0 || n == 1) 
      return; 
    long M[][] = new long[][]{{1L,1L,1L},{1L,0L,0L},{0L,1L,0L}}; 
       
    power(F, n/2); 
    multiply(F, F); 
       
    if (n%2 != 0) 
       multiply(F, M); 
    } 
}
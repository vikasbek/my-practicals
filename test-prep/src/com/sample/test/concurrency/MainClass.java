package com.sample.test.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Foo1 {

   volatile int i=1;
   volatile boolean printfirst=false;
   volatile boolean printsecond=false;
   volatile boolean printthird=false;
   public Foo1() {
       
   }

   public void first(Runnable printFirst) throws InterruptedException {
       
       // printFirst.run() outputs "first". Do not change or remove this line.
       while(!printfirst){
           printFirst.wait();
       }
       printFirst.run();
       printfirst=true;
   }

   public void second(Runnable printSecond) throws InterruptedException {
       
       // printSecond.run() outputs "second". Do not change or remove this line.
       if(printfirst && !printsecond){
           printSecond.wait();
       }
       printSecond.run();
       printsecond=true;
       
       
   }

   public void third(Runnable printThird) throws InterruptedException {
       
       // printThird.run() outputs "third". Do not change or remove this line.
       if(printsecond && !printthird){
           printThird.wait();
       }
       printThird.run();
       printthird=true;
       
   }
}

public class MainClass {
   public static int[] stringToIntegerArray(String input) {
       input = input.trim();
       input = input.substring(1, input.length() - 1);
       if (input.length() == 0) {
         return new int[0];
       }
   
       String[] parts = input.split(",");
       int[] output = new int[parts.length];
       for(int index = 0; index < parts.length; index++) {
           String part = parts[index].trim();
           output[index] = Integer.parseInt(part);
       }
       return output;
   }
   
   public static void main(String[] args) throws IOException {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       String line;
       while ((line = in.readLine()) != null) {
           int[] nums = stringToIntegerArray(line);
           
//           int ret = new Solution().foobar(nums);
//           
//           String out = String.valueOf(ret);
           
//           System.out.print(out);
       }
   }
}

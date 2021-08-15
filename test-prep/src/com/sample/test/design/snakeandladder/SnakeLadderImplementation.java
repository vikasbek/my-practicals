package com.sample.test.design.snakeandladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SnakeLadderImplementation {
//		public static void main (String[] args) {
//			Scanner in =new Scanner(System.in);
//			int t=in.nextInt();
//			int sol;
//			
//			//ArrayList<ArrayList<Integer>> fm;
//			HashMap<Integer,Integer> hm;
//			ArrayList<Integer> q;
//			while(t>0){
//			    sol=in.nextInt();
//			    if(sol==0){
//			        System.out.println(5);
//			        t--;
//			        continue;
//			    }
//			    
//			    int[] dis=new int[30];
//			    dis[0]=0;
//			    for(int k=1;k<30;k++)
//			        dis[k]=-1;
//			    q=new ArrayList<>();
//			    hm=new HashMap<>();
//			    //fm=new ArrayList<>();
//			    while(sol>0){
//			        hm.put(in.nextInt(),in.nextInt());
//			        sol--;
//			    }
//			    q.add(1);
//			    int cp,d;
//			    
//			    while(!q.isEmpty()){
//			        cp=q.remove(0);
//			        d=dis[cp-1];
//			        for(int k=cp+1;k<=cp+6 && k<=30;k++){
//			            if(dis[k-1]==-1 || dis[k-1]>d+1){
//			                if(!hm.containsKey(k)){
//			                    dis[k-1]=d+1;
//			                    q.add(k);
//			                }
//			                else if(dis[hm.get(k)-1]==-1 || dis[hm.get(k)-1]>d+1){
//			                    dis[hm.get(k)-1]=d+1;
//			                    q.add(hm.get(k));
//			                }
//			                
//			            }
//			        }
//			    }
//			    System.out.println(dis[29]);
//			    t--;
//			}
//		}
	
	
	
	public static void main(String[] args) {
		
		int [][] arr = new int[3][5];
		
		System.out.println(arr.length);
		System.out.println(arr[2].length);
		
		
	}
}

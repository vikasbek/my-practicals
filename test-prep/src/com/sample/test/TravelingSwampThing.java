package com.sample.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TravelingSwampThing {
	
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
 
        int n = s.nextInt(); // cities
        int m = s.nextInt(); // roads/edges
        int E = s.nextInt(); // energy
 
        Graph g = new Graph();
        g.maxEnergy = E;
        
        for(int i=1;i<=n;i++) {
            Node node = new Node();
            node.id= i;
            g.nodes.put(i, node);
        }
        
        for(int i=0;i<m;i++) {
            int st = s.nextInt();
            int dt = s.nextInt();
            int d = s.nextInt();
            int e = s.nextInt();
            
            Node stn = g.nodes.get(st);
            Node dtn = g.nodes.get(dt);
            
            Edge ed = new Edge();
            ed.d = d;
            ed.e = e;
            
            stn.neig.put(dtn, ed);
            dtn.neig.put(stn, ed);
        }
        
        System.out.println(g.dfs());      
    }
}
 
class Node {
    public int id;
    public boolean visited;
    public Map<Node, Edge> neig = new HashMap<Node, Edge>();
}
 
class Edge {
    public int d; // distance
    public int e; // energy
}
 
class Graph {
    public Map<Integer, Node> nodes = new HashMap<Integer, Node>();
    public int maxEnergy = 0;
    public int infinity = 100_000_000;
    public int[][][] dp;
    
    public int dfs(){
        int maxN = 14;
        // dp = [Node.id][available energy][visited mask]
        int visitedMask = 1 << (maxN+1);
        // ith bit is used for node i+1.  0<=i<=13
        dp = new int[maxN +1 ]
                    [maxEnergy + 1]
                    [visitedMask];
 
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) {
                for(int k=0;k<dp[0][0].length;k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
 
        int result = dfsH(nodes.get(1), 1, maxEnergy);
        if(result == infinity){
            return -1;
        }
        return result;
    }
    
    // return min distance using energyAvailable
    // and visiting all unvisited nodes.
    private int dfsH(Node n, int visitedMask, int energyAvailable) {
        //System.out.println("node:" + n.id + ", energyAvailable:" + energyAvailable + ", visitedMask:" + Integer.toBinaryString(visitedMask));
 
        if(dp[n.id][energyAvailable][visitedMask] != -1) {
            return dp[n.id][energyAvailable][visitedMask];
        }
 
        if(energyAvailable >= 0 && visitedMask == (1 << nodes.size()) - 1) {
            return 0;
        }
        
        if(energyAvailable <= 0) {
            return infinity;
        }
 
        int minDistance = infinity;
        
        for(Map.Entry<Node,Edge> entry: n.neig.entrySet()) {
            Node neighbour = entry.getKey();
            Edge edge = entry.getValue();
            
            int remainingEnergy = energyAvailable - edge.e;
            if((visitedMask & (1 <<neighbour.id-1)) != 0) {
                continue;
            }
 
            if(remainingEnergy < 0) {
                continue;
            }
 
            int dist = edge.d;
            dist += dfsH(neighbour, visitedMask | (1<<neighbour.id-1), remainingEnergy);
            if(minDistance > dist) {
                minDistance = dist;
            }
        }
 
        //System.out.println("\nnode:" + n.id  + ", energyAvailable:" + energyAvailable + ", minDistance:" + minDistance);
        dp[n.id][energyAvailable][visitedMask] = minDistance;
        return minDistance;
    }
}
 
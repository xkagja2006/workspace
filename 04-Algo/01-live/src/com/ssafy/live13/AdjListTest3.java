package com.ssafy.live13;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;


public class AdjListTest3 {    
    
    static ArrayList<Integer>[] adjList;
    static int V;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int E = sc.nextInt();
        
        adjList = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        
        int from, to;
        for(int i = 0; i < E; i++) {
            from = sc.nextInt();
            to = sc.nextInt();
            
            // 무향 그래프
            adjList[from].add(to);
            adjList[to].add(from);
        }
        bfs(0);
    }
    
    private static void bfs(int start) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[V];
        
        queue.offer(start);
        visited[start] =  true;
        
        int current = 0;
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.println((char)(current+65));  // 탐색할때 해야할일!
            
            for(int vertex : adjList[current]) {    // adjList[current] : ArrayList
                if(!visited[vertex]) {
                    queue.offer(vertex);
                    visited[vertex] = true;
                }
                
            }
        }
        
    }
}
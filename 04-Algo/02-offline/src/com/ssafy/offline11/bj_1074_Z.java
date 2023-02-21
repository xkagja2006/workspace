package com.ssafy.offline11;

import java.util.Scanner;

public class bj_1074_Z {
    
    static int cnt;
    static int r;
    static int c;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //N = 2 
        N = 1<<N;  //N = 4
        r = sc.nextInt();
        c = sc.nextInt();
        System.out.println(cut(N, N, 0, N*N));
    }

    // 0 , 16
    // n = 4;  
    // num = 8
        
                        //n = 4X4  min 0  max 16
    private static int cut(int idxr, int idxc,  int min, int max) {
        System.out.println("=================");
        //System.out.println(n +" "+ min+" "+ max);
        if(idxr < 0 && idxc < 0) return max;
        //if(n == 0) return max;
        
        int num = max/2;
        
        System.out.println("idxr "+ idxr);
        System.out.println("idxc "+ idxc);
        System.out.println("min " + min +" max" +max);
        
        
        if(r < idxr/2 && c < idxc/2) {
            System.out.println("1");
            return cut(idxr/2-1, idxc/2-1 , min, max/4-1);  // 0 ~ 3
        }
        if(r < idxr/2 && c >= idxc/2) { 
            System.out.println("2");
            return cut(idxr/2-1, idxc-1, max/4, max/2-1);  // 4   7
        }
        if(r >= idxr/2 && c < idxc/2) {
            System.out.println("3");
            return cut(idxr-1, idxc/2-1, max/2, max/2+max/4-1);  // 8  11
        }
        if(r >= idxr/2 && r >= idxc/2) {
            System.out.println("4");
            return cut(idxr-1, idxc-1,max/2+max/4, max);                       //12  16
        }
        return 0;
        
    }
    
    
}

package com.ssafy.day01;
import java.util.*;

class Test01{
 public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int a = sc.nextInt();
	int sum = 0;
	for(int i = 0; i < a; i++){
		sum += sc.nextInt();
	}
	System.out.println(sum);
 }
}

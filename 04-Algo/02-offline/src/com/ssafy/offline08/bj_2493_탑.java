package com.ssafy.offline08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

/*
 탑의 경우 일반적으로 풀면 시간초가 발생
 50만개를 배열에 넣고! <- 가면서 자신 앞에 인덱스를 조회하면서 자신보다 큰친구를 조회! 
 */

public class bj_2493_탑 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//입력이 50만이기 때문에 Scanner 입력하면 안된다!. - Buffered 개념으로 !!
		BufferedReader br = new BufferedReader(new StringReader("5\r\n" + "6 9 5 7 4"));
		
		int N = Integer.parseInt(br.readLine());
	

		//데이터 보관할 배열
		int[] data = new int[N + 1];
		//위치 정보를 담을 배열 
		int[] D = new int[N + 1];
		
		StringTokenizer st = new  StringTokenizer(br.readLine(), " ");
		
		//데이터 보관함 배열에 값 입력!
		for(int i = 1; i < N; i++) data[i] = Integer.parseInt(st.nextToken());
		
		D[1] = 0;
		for(int i = 2; i <= N; i++) {
			
			int j = i - 1;  //비교할 인덱스 초기
			while(j > 0) {
				//내꺼랑 내앞에 값이 크다면 내앞의 위치정보를 내위치 정보에 주면된다.
				if(data[i] < data[j]) {
					D[i] = j;
					break;
				}
				// j가 내 앞에 있는 애의 j 값이 된다!
				j = D[j];
			}
		}
		for(int i = 0; i <= N; i++) System.out.println(D[i] + " "); 	
	}
}

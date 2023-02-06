package com.ssafy.offline01;

public class Quiz01 {
	public static void main(String[] args) {
		System.out.println(solve("korea", 0, "")); // k,o,r,e,a
	}

	private static String solve(String string, int i, String string2) {
		if(i >= string.length())
			return string2.substring(0, string2.length()-1);
		return  string2 +  solve(string, i+1, "" + string.charAt(i) + ",");
	}
}

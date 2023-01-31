
public class Test2 {

	public static void main(String[] args) {
		int[] su = { 45, 80, 68, 19, 34, 55, 27, 63, 38, 7 };
		int[] abs = new int[su.length];
		int sum = 0;
		double avg = 0.0;
		for (int i = 0; i < su.length; i++) {
			sum += su[i];
		}
		//형변환
		avg = sum / (double) (su.length);
		
		int max = 0;
		int idx = 0;
		//절대값이 가장 큰 경우의 인덱스를 구한다.
		for (int i = 0; i < su.length; i++) {
			abs[i] = Math.abs(sum - su[i]);
			if (max < abs[i]) {
				idx = i;
			}
		}
		System.out.println(avg + " " + su[idx]);
	}
}

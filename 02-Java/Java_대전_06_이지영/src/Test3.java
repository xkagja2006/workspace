import java.util.Arrays;

public class Test3 {

	public void execute(String msg) {
		//0~9의 수를 인덱스로 가지는 배열을 만든다.
		int[] nums = new int[10];
		
		//입력받은 문자열의 각 숫자를 정수형으로 변환하고 해당 숫자의 인덱스를 가진 원소를 +1 한다.
		for (int i = 0; i < msg.length(); i++) {
			int a = msg.charAt(i) - 48;
			nums[a]++;
		}
		for (int i = 0; i < 10; i++) {
			if (nums[i] != 0)
				System.out.println(i + " : " + nums[i]);
		}
	}

	public static void main(String[] args) {
		Test3 c = new Test3();
		c.execute("53290539955364534323455987827332679340558347453272569584");
		System.out.println("=======");
		c.execute("13334444555557777777");
	}
}

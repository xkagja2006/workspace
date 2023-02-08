import java.util.*;
import java.io.*;

public class Main2 {

	static int n;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
<<<<<<< HEAD
		int n = br.read() - 48;
		System.out.print("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

		String str = "\"재귀함수가 뭔가요?\"\r\n" + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\r\n"
				+ "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\r\n"
				+ "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\r\n" + "재귀함수는 자기 자신을 호출하는 함수라네.\r\n"
				+ "라고 답변하였지.\r\n";
		
		recur(str, n);
	}

	private static void recur(String str, int n) {
		StringTokenizer st = new StringTokenizer(str, "\r\n");
		String str1 = "----" + st.nextToken();
		String str2 = "----" + st.nextToken();
		String str3 = "----" + st.nextToken();
		String str4 = "----" + st.nextToken();

		String str5 = "----" + st.nextToken();
		String str6 = "----" + st.nextToken();
		
		if (n == 0) {
			System.out.print("\n" +str1 + "\n" +str5);
			return;
		}

		str = "\n" + str1 + "\n" + str2 + "\n" + str3 + "\n" + str4;
		System.out.print(str);
		str += "\n" + str5 + "\n" + str6;
		recur(str, n - 1);
		System.out.print("\n" + str6);
	}
}
=======
        n = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recur(0, "");
        
	}
    
    static void recur(int dpt, String str){
            
        if(dpt == n) {
            System.out.println(str+"\"재귀함수가 뭔가요?\"");
            System.out.println(str+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(str+"라고 답변하였지.");
        	return;
        }
        System.out.println(str+"\"재귀함수가 뭔가요?\"");
        System.out.println(str+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(str+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(str+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        
        recur(dpt+1, str+"____");
        System.out.println(str+"라고 답변하였지.");
    }
}
>>>>>>> 59236a801adc822cf7b3e9d629563f9561d93e46

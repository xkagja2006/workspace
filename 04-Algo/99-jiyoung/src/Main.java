import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int people = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < people; i++) {
			list.add(i + 1);
		}
		int idx = -1;
		String result = "<";
		while (!list.isEmpty()) {
			idx += num;
			idx = idx%list.size();
			result += list.get(idx) + ", ";
//			System.out.println(result);
			list.remove(idx);
			idx--;
		}
		result = result.substring(0, result.length() - 2);
		System.out.println(result + ">");
	}
}
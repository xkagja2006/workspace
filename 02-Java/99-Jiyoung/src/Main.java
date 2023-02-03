import java.util.Arrays;

class User{
	int id;
	String name;
	User(){
		id = 1;
		name = "지영";
	}
}

public class Main {
	public static void main(String[] args) {
		String s1 = "Cat";
		String s2 = "Cat";
		String s3 = new String("Cat");
		System.out.println(s1 == s2); // (1)
		System.out.println(s1 == s3); // (2)
		System.out.println(s1.equals(s3)); //
	}
}
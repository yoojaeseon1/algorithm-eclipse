package backjoon;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		String inputString = br.readLine();
//		
//		String[] croatias = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
//		
//		for(int i = 0; i < croatias.length; i++) {
//			inputString = inputString.replace(croatias[i], "0"); // 계속 String 인스턴스 생성(실행할 때마다 heap영역에 쌓인다.)
//		}
//		
//		System.out.println(inputString);
//		System.out.println(inputString.length());
		
//		String test = "haha";
		
//		callByRefTest(test);
		
//		Test test = new Test();
		
//		test.
//		
//		System.out.println(test);
		
		RefTest test = new RefTest();
		test.setStr("haha");
		
		
		System.out.println(test.getStr());
		callByRefTest(test);
		
		System.out.println(test.getStr());
		
//		String test = "haha";
//		String test = new String("haha");
//		System.out.println(test);
//		test.concat("hoho");
//		test = test.toUpperCase();
//		callByRefTest(test);
//		System.out.println(test);
		
		
		
	}
	
	static void callByRefTest(RefTest str) {
		
//		str.setStr("hoho");
	}
	static void callByRefTest(String str) {
		
	}
	

}


class RefTest {
	
	private String str;
	
	public RefTest() {
		// TODO Auto-generated constructor stub
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
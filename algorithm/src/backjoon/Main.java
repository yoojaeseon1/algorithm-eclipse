package backjoon;

import java.io.IOException;
import java.util.StringTokenizer;

// checkPalin method 조건 수정해야 됨
// 미완성

public class Main {
	public static void main(String[] args) throws IOException {
		
		String temp = "$1is$1string$1haha";
		
		StringTokenizer st = new StringTokenizer(temp, "$");
		
		System.out.println(st.nextToken());
		System.out.println(st.nextToken("$1"));
		System.out.println(st.nextToken());
	}
}
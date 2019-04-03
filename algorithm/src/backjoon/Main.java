package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inputString = br.readLine();
		
		String[] croatias = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i = 0; i < croatias.length; i++) {
			inputString = inputString.replace(croatias[i], "0"); // 계속 String 인스턴스 생성(실행할 때마다 heap영역에 쌓인다.)
		}
		
		System.out.println(inputString);
		System.out.println(inputString.length());
		
	}
}
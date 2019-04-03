package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder inputString = new StringBuilder(br.readLine());
		char curChar;
		int totalCount = 0;
		int startIndex = 0;
		

		for (int i = 1; i < inputString.length(); i++) {
			curChar = inputString.charAt(i);
			System.out.println("start index : " + startIndex);
			if (curChar == '=' || curChar == '-' || curChar == 'j') {
				if(curChar == '=') {
					if(inputString.charAt(i-1) == 'c' || inputString.charAt(i-1) == 's' || inputString.charAt(i-1) == 'z') {
						totalCount++;
						totalCount += (i-1) - startIndex;
						System.out.println("i : " + i);
						System.out.println("total count : " + totalCount);
						startIndex = i+1;
					} else if(i != 1 && inputString.charAt(i-2) == 'z' && inputString.charAt(i-1) == 'd') {
						totalCount++; // 위의 if문 한번 걸치고 온다.
						System.out.println("i : " + i);
						totalCount += (i - 2) - startIndex;
						System.out.println("total count : " + totalCount);
						startIndex = i+1;
					}
				} else if(curChar == '-') {
					if(inputString.charAt(i-1) == 'c' || inputString.charAt(i-1) == 'd') {
						totalCount++;
						totalCount += (i-1) - startIndex;
						startIndex = i+1;
					}
				} else if(curChar == 'j') {
					totalCount++;
					totalCount += (i-1) - startIndex;
					startIndex = i+1;
				}
			}
		}
		System.out.println("start index : " + startIndex);
		
		if(startIndex != inputString.length()) {
			totalCount += inputString.length() - startIndex;
		}
		
		System.out.println(totalCount);

	}
}
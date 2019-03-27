package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int commitTest = 1;

		// 앞의 인덱스와 같은지 확인 -> 아니면 contain확인 -> 포함 안되있으면 추가 -> 돼있으면  그룹단어 X
		
		int n = Integer.parseInt(br.readLine());
		List<Character> checkList = new ArrayList<>();
		
		StringBuilder word;
		char currentChar;
		boolean checkGroup = true;
		int groupCount = 0;
		
		for(int i = 0; i < n; i++) {
			word = new StringBuilder(br.readLine());
			checkList.add(word.charAt(0));
//			System.out.println("word : " + word);
			
			for(int j = 1; j < word.length(); j++) {
				currentChar = word.charAt(j);
//				System.out.println("current Char : " + currentChar);
				if(currentChar != word.charAt(j - 1)) {
					if(!checkList.contains(currentChar)) {
						checkList.add(currentChar);
					} else{
						checkGroup = false;
						break;
					}
				}
			}
			
			if(checkGroup) {
				groupCount++;
			} else {
				checkGroup = true;
			}
			checkList = new ArrayList<>();
		}
		System.out.println(groupCount);

	}
}

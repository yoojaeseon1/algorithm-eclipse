package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1316 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ���� �ε����� ������ Ȯ�� -> �ƴϸ� containȮ�� -> ���� �ȵ������� �߰� -> ��������  �׷�ܾ� X
		
		int n = Integer.parseInt(br.readLine());
		List<Character> checkList = new ArrayList<>();
		
		StringBuilder word;
		char currentChar;
		boolean checkGroup = true;
		int groupCount = 0;
		
		for(int i = 0; i < n; i++) {
			word = new StringBuilder(br.readLine());
			checkList.add(word.charAt(0));
			
			for(int j = 1; j < word.length(); j++) {
				currentChar = word.charAt(j);
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

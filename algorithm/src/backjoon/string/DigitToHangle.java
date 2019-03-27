package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitToHangle {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// StringBuilder inputNum = new StringBuilder(br.readLine());
		String inputNum = "212000000001";
		int reversedIndex = 0;
		char currentDigit;
		StringBuilder result = new StringBuilder();

		String[] digits = { "", "ÀÏ", "ÀÌ", "»ï", "»ç", "¿À", "À°", "Ä¥", "ÆÈ", "±¸" };

		String[] units = { "", "¸¸", "¾ï", "Á¶", "°æ" };
		int unitCheck = 1;

		String[] units2 = { "", "½Ê", "¹é", "Ãµ" };

		for (int i = inputNum.length() - 1; i >= 0; i--) {
			currentDigit = inputNum.charAt(i);
			System.out.println("currentDigit : " + currentDigit);
			if (currentDigit != '0') {
				unitCheck++;
			}
			if (reversedIndex % 4 != 0) {
				if (currentDigit != '0') {
					result.insert(0, units2[reversedIndex % 4]);
				}
				if (currentDigit != '1') {
					result.insert(0, digits[(int) currentDigit - 48]);
				}
				System.out.println(result);
			} else {
				if (unitCheck == 0) {
					result.delete(0, 1);
				}
				result.insert(0, units[reversedIndex / 4]);
				if(reversedIndex != 0) {
					unitCheck = 0;
				}
				result.insert(0, digits[(int) currentDigit - 48]);
				System.out.println(result);
			}
			reversedIndex++;
		}

		System.out.println(result);

	}

}

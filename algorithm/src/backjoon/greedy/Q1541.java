package backjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1541 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder input = new StringBuilder(br.readLine());
		StringBuilder numString = new StringBuilder();
		int tempSum = 0;
		int resultSum = 0;
		boolean minusFlag = false;
		int firstIndex = 0;
		char sign = ' ';

		while (input.charAt(firstIndex) != '+' && input.charAt(firstIndex) != '-') {
			numString.append(input.charAt(firstIndex));
			firstIndex++;
		}

		// System.out.println(numString);
		// System.out.println(firstIndex);

		resultSum += Integer.parseInt(numString.toString());
		numString.setLength(0);
		int j;

		for (int i = firstIndex; i < input.length(); i++) {
			sign = input.charAt(i);
			System.out.println(sign);
			j = i + 1;
			while (j < input.length() && input.charAt(j) != '+' && input.charAt(j) != '-') {
				// System.out.println(input.charAt(j));
				numString.append(input.charAt(j));
				j++;
			}
			// System.out.println("----");
			if (sign == '+') {
				if (minusFlag)
					tempSum += Integer.parseInt(numString.toString());
				else {
					resultSum += Integer.parseInt(numString.toString());
					numString.setLength(0);
				}
			} else {
				if (minusFlag) {
					resultSum -= tempSum;
					tempSum = 0;
					// minusFlag = false;
				} else {
					tempSum += Integer.parseInt(numString.toString());
					numString.setLength(0);
					minusFlag = true;
				}
			}
			// System.out.println(resultSum);
			// System.out.println("-----------");
			i = j - 1;
		}

		if (sign == '-' && minusFlag)
			resultSum -= tempSum;
		else if (sign == '-' && !minusFlag)
			resultSum += tempSum;
		else {
			resultSum += tempSum;
			System.out.println("haha");
		}
		// System.out.println(tempSum);
		// resultSum += tempSum;

		System.out.println(resultSum);

	}

}

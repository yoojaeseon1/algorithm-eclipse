package programmers.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class TheBiggestNumber {

	public static void main(String[] args) {

//		 int[] numbers = { 6, 10, 2 };
		int[] numbers = { 3, 30, 34, 5, 9 };

		System.out.println(solution(numbers));

	}

	public static String solution(int[] numbers) {

		StringBuilder answer = new StringBuilder();

		String[] numbersToStr = new String[numbers.length];

		for (int ni = 0; ni < numbersToStr.length; ni++) {
			numbersToStr[ni] = Integer.toString(numbers[ni]);
		}

		Arrays.sort(numbersToStr, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {

				if (arg0.length() == arg1.length()) {

					for (int ai = 0; ai < arg0.length(); ai++) {
						if (arg0.charAt(ai) != arg1.charAt(ai)) {
							if ((int) arg0.charAt(ai) >= (int) arg1.charAt(ai))
								return -1;
							else
								return 0;
						}
					}
					return 0;

				} else {
//					int shorterLength  = Math.max(arg0.length(), arg1.length());
					int arg0OriginalLength = arg0.length();
					int arg1OriginalLength = arg1.length();
					
					if(arg0.length() > arg1.length()) {
						for(int ai = 0; ai < arg0.length() - arg1.length(); ai++)
							arg1 += "0";
					} else {
						for(int ai = 0; ai < arg1.length() - arg0.length(); ai++)
							arg0 += "0";
					}
					
					
					for (int ai = 0; ai < arg0.length(); ai++) {
						if (arg0.charAt(ai) != arg1.charAt(ai)) {
							if ((int) arg0.charAt(ai) >= (int) arg1.charAt(ai))
								return -1;
							else
								return 0;
						}
					}
					
					if(arg0OriginalLength > arg1OriginalLength) return 1;
					else return -1;
					
					
				}
			}

		});
		
		

		for (int ni = 0; ni < numbersToStr.length; ni++) {
			answer.append(numbersToStr[ni]);
		}

		return answer.toString();
	}

}

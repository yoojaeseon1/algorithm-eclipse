package programmers;

public class Solution {

	public static void main(String[] args) {

//		 int brown = 10;
//		 int red = 2;
//		 int brown = 8;
//		 int red = 1;
		int brown = 16;
		int red = 9;

		int[] answer = solution(brown, red);

		System.out.println(answer[0] + ", " + answer[1]);

	}

	public static int[] solution(int brown, int red) {
		int[] answer = new int[2];

		if (red % 2 == 1) {
			answer[0] = red + 2;
			answer[1] = 3;
			} else {
			int redRow = 1;
			int redColumn = red;

			while (redColumn >= redRow) {

				int currentBrownCount = (redColumn + 2) * 2 + (redRow * 2);
				System.out.println("current redColumn : " + redColumn);
				System.out.println("current redRow : " + redRow);
				System.out.println("currentBrownCount : " + currentBrownCount);
				System.out.println("-----------");

				if (brown == currentBrownCount)
					break;
				else {
					// redColumn /= 2;
					redRow++;
//					redColumn--;
					while (redColumn * redRow != red && redColumn * redRow >= 1)
						redColumn--;
				}
			}
			
//			answer[0] = redColumn + 2;
//			answer[1] = redRow + 2;
			answer[0] = Math.max(redColumn + 2, redRow+2);
			answer[1] = Math.min(redColumn + 2, redRow+2);

		}

		return answer;
	}

}

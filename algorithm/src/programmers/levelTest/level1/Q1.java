package programmers.levelTest.level1;

public class Q1 {
	
	public static void main(String[] args) {
		
		System.out.println(solution(5));

	}

	public static int solution(int n) {

		int answer = n;

		for (int divisor = n / 2; divisor >= 1; divisor--) {
			if (n % divisor == 0)
				answer += divisor;
		}

		return answer;
	}

}

package programmers.levelTest.level2;

public class Q2 {
	
	public static void main(String[] args) {
		
		int[] arr = {2,6,8,14};
		
		System.out.println(solution(arr));

	}
	
	public static int solution(int[] arr) {
		
	      int answer = lcm(arr);
	      
	      return answer;
	  }
	
	public static int lcm(int[] num) {
		
		int answer = num[0];
		int small = 0;
		int big = 0;
		
		for(int ni = 1; ni < num.length ; ni++ ){
			small = Math.min(answer,  num[ni]);
			big = Math.max(answer, num[ni]);
			
			answer = (small * big) / gcd(small, big);
		}
		
		return answer;
		
	}
	
	public static int gcd(int small, int big) {
		
		int answer = 0;
		
		for(int i = 1; i <= small; i++) {
			if(small % i == 0 && big % i == 0) answer = i;
		}
		
		return answer;
	}

}

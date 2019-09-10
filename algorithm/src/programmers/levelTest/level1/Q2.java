package programmers.levelTest.level1;

public class Q2 {
	
	public static void main(String[] args) {
		
		
		System.out.println(solution("a B z", 4));
		
		

	}

	public static String solution(String s, int n) {

		StringBuilder answer = new StringBuilder();
		
		for(int si = 0; si < s.length(); si++) {
			
			int curCharAscii = (int)s.charAt(si);
			
			if(curCharAscii == (int)' ') answer.append(' ');
			else if(curCharAscii>= 65 && curCharAscii <= 90){
				if(curCharAscii + n > 90) {
					answer.append((char)(curCharAscii + n - 26));
				} else {
					answer.append((char)(curCharAscii + n));
				}
			} else {
				if(curCharAscii + n > 122) {
					answer.append((char)(curCharAscii + n - 26));
				} else {
					answer.append((char)(curCharAscii + n));
				}
			}
		}
		
		
		return answer.toString();
	}

}

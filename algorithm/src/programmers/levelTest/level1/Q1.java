package programmers.levelTest.level1;

public class Q1 {
	
	public static void main(String[] args) {
		
		
		
		
	}
	
    public String solution(String[] seoul) {
        
        
        for(int seoulI = 0; seoulI < seoul.length; seoulI++) {
        	if(seoul[seoulI].equals("Kim"))
        		return "�輭���� " + seoulI + "�� �ִ�.";
        }
		
        return "";
        
    }

}

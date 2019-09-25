package programmers.sorting;

import java.util.Arrays;

public class KthNumber {
	
	public static void main(String[] args) {

		int[] array = {1, 5, 2, 6, 3, 7, 4};
		
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		solution(array, commands);

	}

	public static int[] solution(int[] array, int[][] commands) {
		
        int[] answer = new int[commands.length];
        
        for(int ci = 0; ci < commands.length; ci++) {
        	int i = commands[ci][0];
        	int j = commands[ci][1];
        	int k = commands[ci][2];
        	
        	int[] dividedArray = new int[j-i+1];
        	
        	System.arraycopy(array, i-1, dividedArray, 0, dividedArray.length);
        	
        	Arrays.sort(dividedArray);
        	
        	answer[ci] = dividedArray[k-1];
        	
        }
        
        return answer;
    }

}

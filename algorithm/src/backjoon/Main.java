package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] original = {{1,2},{3,4},{5,6}};
		
//		int[][] copied = original;
		int[][] copied = copyArray(original);
		
		original[1][1] = 8;
		
//		int[] copied = new int[original.length];
		
//		System.arraycopy(original, 0, copied, 0, original.length);
		
//		original[1] = 8;
		
		for(int i = 0; i < copied.length; i++) {
			System.out.println(copied[i][0] + " " + copied[i][1]);
		}
		
	}
	
	static int[][] copyArray(int[][] original) {
		
		int[][] copied = new int[original.length][original[0].length];
		
		for(int i = 0; i < original.length; i++) {
			System.arraycopy(original[i], 0, copied[i], 0, original[i].length);
		}
		
		return copied;
		
		
	}
}
package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] field = new int[n+1][m+1];
		
		for(int fi = 1; fi < field.length ; fi++) {
			
			st = new StringTokenizer(br.readLine());
			for(int fj = 1; fj < field[fi].length; fj++) {
				field[fi][fj] = Integer.parseInt(st.nextToken());
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
		for(int caseCount = 1; caseCount <= k; caseCount++) {
			
			st = new StringTokenizer(br.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int sumOfCoordi = 0;
			
			for(int iCount = i; iCount <= x; iCount++) {
				
				for(int jCount = j; jCount <= y; jCount++) {
					sumOfCoordi += field[iCount][jCount];
				}
			}	
			System.out.println(sumOfCoordi);
		}
	}
}
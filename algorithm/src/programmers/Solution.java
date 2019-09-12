package programmers;

import java.math.BigInteger;

public class Solution {

	static int MOD = 20170805;

	public static void main(String[] args) {

		
		int[][] cityMap = new int[3][3];
		
		System.out.println(solution(1, 2, cityMap));

	}

	  public static int solution(int m, int n, int[][] cityMap) {      
		  
		  int answer = 0;
		  
		  
		  long[][][] routeCountMap = new long[m][n][2];
		  
		  routeCountMap[0][0][0] = 1;
		  routeCountMap[0][0][1] = 1;
		  
			for (int rj = 1; rj < routeCountMap[0].length; rj++) {
				if (cityMap[0][rj] == 0) {
					routeCountMap[0][rj][0] = 1;
					routeCountMap[0][rj][1] = 1;
				} else if(cityMap[0][rj] == 1)
					break; // after this (0,0)
				else {
					routeCountMap[0][rj][0] = 1;
				}
			}
		  
			for (int ri = 1; ri < routeCountMap.length; ri++) {
				if (cityMap[ri][0] == 0) {
					routeCountMap[ri][0][0] = 1;
					routeCountMap[ri][0][1] = 1;
				} else if(cityMap[ri][0] == 1) 
					break;
				else {
					routeCountMap[ri][0][1] = 1;
				}
			}
			
		for(int ci = 1; ci < routeCountMap.length; ci++) {
			for(int cj = 1; cj < routeCountMap[ci].length; cj++) {
				
				if(cityMap[ci][cj] == 0) {
					routeCountMap[ci][cj][0] = routeCountMap[ci][cj-1][0] + routeCountMap[ci-1][cj][1];
					routeCountMap[ci][cj][0] %= MOD;
					routeCountMap[ci][cj][1] = routeCountMap[ci][cj-1][0] + routeCountMap[ci-1][cj][1];
					routeCountMap[ci][cj][1] %= MOD;
				} else if(cityMap[ci][cj] == 1) {
					routeCountMap[ci][cj][0] = 0;
					routeCountMap[ci][cj][1] = 0;
				} else {
					routeCountMap[ci][cj][0] = routeCountMap[ci][cj-1][0];
					routeCountMap[ci][cj][0] %= MOD;
					routeCountMap[ci][cj][1] = routeCountMap[ci-1][cj][1];
					routeCountMap[ci][cj][1] %= MOD;
				}
			}
		}
		
		answer = (int)routeCountMap[m-1][n-1][0]; 
		  
		  return answer;
	  }

}

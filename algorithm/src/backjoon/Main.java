package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wines = new int[n+1];
		long maxSum = 0;
		
		for(int i = 1; i <= n; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}
		
		long[][] dp = new long[n+1][2];
		dp[1][0] = wines[1];
		dp[1][1] = wines[1];
		
		for(int i = 2; i <= n; i++) {
			dp[i][0] = wines[i]+dp[i-1][1];
			dp[i][1] = wines[i]+Math.max(dp[i-2][0], dp[i-2][1]);
//			System.out.println("i : " + i);
//			System.out.println("0 : " + dp[i][0]);
//			System.out.println("1 : " + dp[i][1]);
//			System.out.println("-------------");
		}
		
		maxSum = Math.max(dp[n][0], dp[n][1]);
		maxSum = Math.max(maxSum, dp[n-1][0]);
		maxSum = Math.max(maxSum, dp[n-1][1]);
		
		System.out.println(maxSum); // max : 6667000
	}
}
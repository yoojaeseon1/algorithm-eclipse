package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int friendsCnt = 0;
		boolean[][] friends = new boolean[n+1][n+1];
		boolean[] visited = new boolean[n+1];

		int temp1, temp2;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			temp1 = Integer.parseInt(st.nextToken());
			temp2 = Integer.parseInt(st.nextToken());
			friends[temp1][temp2] = true;
			friends[temp2][temp1] = true;
			list.add(temp2);
			visited[temp2] = true;
			// System.out.println(temp1 + " " + temp2);
		}
		
		for(int i = 1; i < friends[1].length; i++) {
			if(friends[1][i]){
				for(int j = 1; j < friends[i].length; j++) {
					if(friends[i][j] && !visited[j]) {
						visited[j] = true;
					}
				}
			}
		}
		
		for(int i = 2; i < visited.length; i++) {
			if(visited[i]) {
//				System.out.println(i);
				friendsCnt++;
			}
		}
		System.out.println(friendsCnt);
	}
}
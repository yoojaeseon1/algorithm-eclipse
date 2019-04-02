package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] fieldArr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		fieldArr = new int[n][n];

		StringTokenizer st;

		for (int i = 0; i < fieldArr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < fieldArr[i].length; j++) {
				fieldArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		doOccupy(0, 0);

		for (int i = 0; i < fieldArr.length; i++) {
			for (int j = 0; j < fieldArr[i].length; j++) {
				System.out.print(fieldArr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void doOccupy(int x, int y) {

		int[] dx = { 1, 1, -1, -1 };
		int[] dy = { -1, 1, 1, -1 };

		for (int i = 0; i < dx.length; i++) {
			for (int j = 1; j <= 4; j++) {
//				System.out.println("moved x : " + (x + (dx[i] * j)));
//				System.out.println("moved y : " + (y + (dy[i] * j)));
				
				if (x + (dx[i] * j) >= 0 && x + (dx[i] * j) < fieldArr[0].length && y + (dy[i] * j) >= 0 && y + (dy[i] * j) < fieldArr.length) {
//					System.out.println("into if : " + fieldArr[y + (dy[i] * j)][x + (dx[i] * j)]);
					if (fieldArr[y + (dy[i] * j)][x + (dx[i] * j)] == 1) {
						fieldArr[y + (dy[i] * j)][x + (dx[i] * j)] = 2;
					}
				}
			}
		}
	}
}

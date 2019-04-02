package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] fieldArr;
	static int n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		fieldArr = new int[n][n];
		int[][] copiedArr = new int[n][n];
		int bCount;
		int maxBCount = 0;

		StringTokenizer st;

		for (int i = 0; i < fieldArr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < fieldArr[i].length; j++) {
				fieldArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		copiedArr = copyArr(fieldArr);

		for (int i = 0; i < fieldArr.length; i++) {
			bCount = 0;
			fieldArr = copyArr(copiedArr);
//			System.out.println("first loop i : " + i);
			for (int j = 0; j < fieldArr[i].length; j++) {
				if (fieldArr[i][j] == 1) {
//					System.out.println("j : " + j);
					bCount = doOccupy(j, i, bCount);
//					System.out.println("b count : " + bCount);
				}
				// System.out.print(copiedArr[i][j] + " ");
			}
//			System.out.println("first change end");
			for (int j = 0; j < fieldArr.length; j++) {
				for (int k = 0; k < fieldArr[j].length; k++) {
					bCount = doOccupy(k, j, bCount);
				}
			}
			
/*			for(int j = 0; j < fieldArr.length; j++) {
				for(int k = 0; k < fieldArr[j].length; k++) {
					System.out.print(fieldArr[j][k] + " ");
				}
				System.out.println();
			}*/
			
			
			maxBCount = Math.max(maxBCount, bCount);
			System.out.println("bCount : " + bCount);
			System.out.println("max count : " + maxBCount);
			System.out.println("-------------");

			// System.out.println();
		}
		
		System.out.println(maxBCount);

		/*
		 * for (int i = 0; i < fieldArr.length; i++) { for (int j = 0; j <
		 * fieldArr[i].length; j++) { System.out.print(fieldArr[i][j] + " "); }
		 * System.out.println(); }
		 */
	}

	static int doOccupy(int x, int y, int bCount) {

		int[] dx = { 1, 1, -1, -1 };
		int[] dy = { -1, 1, 1, -1 };

		if (fieldArr[y][x] == 1) {
//			System.out.println("i : " + y);
//			System.out.println("j : " + x);
			fieldArr[y][x] = 2;
			bCount++;
			for (int i = 0; i < dx.length; i++) {
				for (int j = 1; j <= n - 1; j++) {
					// System.out.println("moved x : " + (x + (dx[i] * j)));
					// System.out.println("moved y : " + (y + (dy[i] * j)));

					if (x + (dx[i] * j) >= 0 && x + (dx[i] * j) < fieldArr[0].length && y + (dy[i] * j) >= 0
							&& y + (dy[i] * j) < fieldArr.length) {
						// System.out.println("into if : " + fieldArr[y + (dy[i]
						// *
						// j)][x + (dx[i] * j)]);
						if (fieldArr[y + (dy[i] * j)][x + (dx[i] * j)] == 1) {
//							System.out.println("----");
//							System.out.println("i : " + i);
//							System.out.println("j : " + j);
//							System.out.println("changed i : " + (y + (dy[i] * j)));
//							System.out.println("changed j : " + (x + (dx[i] * j)));
//							System.out.println("----");
							fieldArr[y + (dy[i] * j)][x + (dx[i] * j)] = 3;
						}
					}
				}
			}
		}
		return bCount;
	}

	static int[][] copyArr(int[][] original) {

		int[][] copy = new int[original.length][original[0].length];

		for (int i = 0; i < original.length; i++) {

			System.arraycopy(original[i], 0, copy[i], 0, original[i].length);

		}

		return copy;

	}
}

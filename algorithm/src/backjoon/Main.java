package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Object[]> boardStack = new Stack<>();

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int maxCount = 0;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		int curX, curY;

		String[][] board = new String[r][c];
		String tempInput;
		for (int i = 0; i < r; i++) {
			tempInput = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = tempInput.substring(j, j + 1);
			}
		}

		Object[] curPosition = new Object[3];
		StringBuilder movedRoute = new StringBuilder();
		movedRoute.append(board[0][0]);
		curPosition[0] = 0;
		curPosition[1] = 0;
		curPosition[2] = movedRoute;
		boardStack.push(curPosition);
		Object[] nextPosition;
		StringBuilder nextRoute;
		StringBuilder maxRoute = new StringBuilder();
		while (!boardStack.isEmpty()) {
			curPosition = boardStack.pop();
			curX = (int) curPosition[0];
			curY = (int) curPosition[1];
			movedRoute = (StringBuilder) curPosition[2];
			// System.out.println("maxCount : " + maxCount);
			// System.out.println("movedRoute : " + movedRoute);
			if (movedRoute.length() > maxCount) {
				maxCount = Math.max(maxCount, movedRoute.length());
				maxRoute.setLength(0);
				maxRoute.append(movedRoute);
			}

			for (int i = 0; i < 4; i++) {
				if (curX + dx[i] >= 0 && curX + dx[i] < c && curY + dy[i] >= 0 && curY + dy[i] < r) {
					if (movedRoute.indexOf(board[curY + dy[i]][curX + dx[i]]) == -1) {
						nextPosition = new Object[3];
						nextRoute = new StringBuilder();
						nextRoute.append(movedRoute);
						nextRoute.append(board[curY + dy[i]][curX + dx[i]]);
						nextPosition[0] = curX + dx[i];
						nextPosition[1] = curY + dy[i];
						nextPosition[2] = nextRoute;
						// System.out.println(nextRoute);
						// System.out.println("-------------");
						boardStack.push(nextPosition);
					}
				}
			}
		}

		System.out.println(maxCount);
//		System.out.println(maxRoute);

		// for(int i = 0; i < r; i++) {
		// for(int j = 0; j < c; j++) {
		// System.out.print(board[i][j] + " ");
		// }
		// System.out.println();
		// }
	}
}
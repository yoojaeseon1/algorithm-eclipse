package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[][] field;
	static int minTryCnt;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int rX = 0;
		int rY = 0;
		int bX = 0;
		int bY = 0;

		StringBuilder line = new StringBuilder();
		field = new char[n][m];

		for (int i = 0; i < n; i++) {
			line.append(br.readLine());
			for (int j = 0; j < m; j++) {
				field[i][j] = line.charAt(j);
				if (field[i][j] == 'R') {
					rX = j;
					rY = i;
				}
				if (field[i][j] == 'B') {
					bX = j;
					bY = i;
				}
			}
			line.setLength(0);
		}
		minTryCnt = 10;
		System.out.println("rX : " + rX);
		System.out.println("rY : " + rY);
		System.out.println("bX : " + bX);
		System.out.println("bY : " + bY);

		moveRB(rX, rY, bX, bY, 9, 2);

		System.out.println(10 - minTryCnt);

		// answer is 10 - minTryCnt

		// input test

		// for(int i = 0; i < n; i++) {
		// for(int j = 0; j < m; j++) {
		// System.out.print(field[i][j] + " ");
		// }
		// System.out.println();
		// }

		// first red / blue position check

	}

	static void moveRB(int rX, int rY, int bX, int bY, int tryCnt, int endFlag) { // endFlag
																					// :
																					// 0
																					// -
																					// only
																					// red,
																					// 1-both
																					// or
																					// only
																					// blue,
																					// 2-continue
		if (endFlag == 0) {
			minTryCnt = Math.min(minTryCnt, tryCnt);
			return;
		}
		if (tryCnt == -1 || tryCnt >= minTryCnt || endFlag == 1) {
			return;
		}

		minTryCnt = Math.min(minTryCnt, tryCnt);
		boolean rSuccessCheck = false;
		boolean bSuccessCheck = false;
		boolean rMovableCheck = true;
		boolean bMovableCheck = true;
		int rMoveCnt = 1;
		int bMoveCnt = 1;
		char nextRed, nextBlue;

		for (int i = 0; i < 4; i++) {
			System.out.println("i : " + i);
			while ((rMovableCheck || bMovableCheck)) {
				System.out.println("loop count : ");
				nextRed = field[rY + (dy[i] * rMoveCnt)][rX + (dx[i] * rMoveCnt)];
				nextBlue = field[bY + (dy[i] * bMoveCnt)][bX + (dx[i] * bMoveCnt)];
				if (nextRed == 'O') {
					System.out.println("red : O");
					rSuccessCheck = true;
				} else if (rMovableCheck && rY + (dy[i] * rMoveCnt) >= 0 && rY + (dy[i] * rMoveCnt) < field.length
						&& rX + (dx[i] * rMoveCnt) >= 0 && rX + (dx[i] * rMoveCnt) < field[0].length) {
					if ((nextRed != '#' && nextRed != 'B') || ((rY + (dy[i] * (rMoveCnt + 1)) >= 0)
							&& (rY + (dy[i] * (rMoveCnt + 1)) < field.length) && (rX + (dx[i] * (rMoveCnt + 1)) >= 0)
							&& (rX + (dx[i] * (rMoveCnt + 1)) < field[0].length)
							&& (field[rY + (dy[i] * (rMoveCnt + 1))][rX + (dx[i] * (rMoveCnt + 1))] != '#'
									&& nextRed == 'B'))) { // not next,
															// current
															// red
						System.out.println("red : move");
						rMoveCnt++;
					} else {
						System.out.println("red : can't move");
						rMovableCheck = false;
					}
				}
				if (nextBlue == 'O') {
					bSuccessCheck = true;
					System.out.println("blue : O");
				} else if (bMovableCheck && bY + (dy[i] * bMoveCnt) >= 0 && bY + (dy[i] * bMoveCnt) < field.length
						&& bX + (dx[i] * bMoveCnt) >= 0 && bX + (dx[i] * bMoveCnt) < field[0].length) {
					if ((nextBlue != '#' && nextBlue != 'B') || ((bY + (dy[i] * (bMoveCnt + 1)) >= 0)
							&& (bY + (dy[i] * (bMoveCnt + 1)) < field.length) && (bX + (dx[i] * (bMoveCnt + 1)) >= 0)
							&& (bX + (dx[i] * (bMoveCnt + 1)) < field[0].length)
							&& (field[bY + (dy[i] * bMoveCnt + 1)][bX + (dx[i] * bMoveCnt + 1)] != '#'
									&& nextBlue == 'B'))) { // not next
															// current
															// red
						bMoveCnt++;
						System.out.println("blue : move");
					} else {
						bMovableCheck = false;
						System.out.println("blue : can't move");
					}
				}
			}

			// if((rSuccessCheck && !bSuccessCheck) || bSuccessCheck)
			if (rSuccessCheck && !bSuccessCheck) {
				System.out.println("success only red");
				moveRB(rX + (dx[i] * rMoveCnt), rY + (dy[i] * rMoveCnt), bX + (dx[i] * bMoveCnt), tryCnt - 1,
						bY + (dy[i] * bMoveCnt), 0);
			} else if (bSuccessCheck) {
				System.out.println("fail");
				moveRB(rX + (dx[i] * rMoveCnt), rY + (dy[i] * rMoveCnt), bX + (dx[i] * bMoveCnt), tryCnt - 1,
						bY + (dy[i] * bMoveCnt), 1);
			} else {
				System.out.println("continue");
				moveRB(rX + (dx[i] * rMoveCnt), rY + (dy[i] * rMoveCnt), bX + (dx[i] * bMoveCnt), tryCnt - 1,
						bY + (dy[i] * bMoveCnt), 2);
			}
		}
	}
}
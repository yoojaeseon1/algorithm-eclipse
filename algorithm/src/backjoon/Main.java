package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] field = new int[n][n];

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };

		StringBuilder tempLine = new StringBuilder();
		for (int fi = 0; fi < field.length; fi++) {
			tempLine.append(br.readLine());
			for (int fj = 0; fj < field[fi].length; fj++) {

				field[fi][fj] = Integer.parseInt(tempLine.substring(fj, fj + 1));

			}
			tempLine.setLength(0);
		}

		List<Integer> areaList = new ArrayList<>();
		Queue<int[]> searchQueue = new LinkedList<>();

		for (int fi = 0; fi < field.length; fi++) {
			for (int fj = 0; fj < field[fi].length; fj++) {

				if (field[fi][fj] == 1) {
					
					int[] curPosition = new int[2];
					curPosition[0] = fj;
					curPosition[1] = fi;
					
					searchQueue.add(curPosition);
					field[fi][fj] = 2;
					int areaCount = 0;
					
					while (!searchQueue.isEmpty()) {

						curPosition = searchQueue.poll();

						int curX = curPosition[0];
						int curY = curPosition[1];
						areaCount++;
//						field[curY][curX] = 2;

						for (int di = 0; di < 4; di++) {

							if (curX + dx[di] >= 0 && curX + dx[di] < field[fi].length && curY + dy[di] >= 0
									&& curY + dy[di] < field.length) {
								if(field[curY+dy[di]][curX+dx[di]] == 1) {
									int[] pushedPosition = new int[2];
									pushedPosition[0] = curX + dx[di];
									pushedPosition[1] = curY + dy[di];
									searchQueue.add(pushedPosition);
									field[curY+dy[di]][curX+dx[di]] = 2;
								}
							}
						}
					}
//					System.out.println("area count : " + areaCount);
					areaList.add(areaCount);
				}

			}
		}
		
		System.out.println(areaList.size());
		for(int ai = 0; ai < areaList.size(); ai++) {
			System.out.println(areaList.get(ai));
		}

		// for(int fi = 0; fi < field.length; fi++) {
		// for(int fj = 0; fj < field[fi].length; fj++) {
		//
		// System.out.print(field[fi][fj] + " ");
		// }
		// System.out.println();
		// }

	}
}
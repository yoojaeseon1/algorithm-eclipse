package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][][] field = new int[N][M][2];

		StringBuilder oneLine = new StringBuilder();
		List<int[]> walls = new ArrayList<>();
		List<int[]> roads = new ArrayList<>();
		int[] firstPosition = { 0, 0 };
		walls.add(firstPosition);
		for (int fieldI = 0; fieldI < field.length; fieldI++) {
			oneLine.append(br.readLine());
			for (int fieldJ = 0; fieldJ < field[fieldI].length; fieldJ++) {
				if (oneLine.charAt(fieldJ) == '0') {
					field[fieldI][fieldJ][0] = 0;
					int[] road = { fieldJ, fieldI };
					roads.add(road);
				} else {
					field[fieldI][fieldJ][1] = -1;
					int[] wall = { fieldJ, fieldI };
					walls.add(wall);
				}
			}
			oneLine.setLength(0);
		}

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };

		// int[][] copiedField = copyArray(field);
		int minDistance = Integer.MAX_VALUE;

		Queue<int[]> fieldQueue = new LinkedList<>();

		for (int wallsI = 0; wallsI < walls.size(); wallsI++) {

			for (int roadsI = 0; roadsI < roads.size(); roadsI++) {
				int[] road = roads.get(roadsI);
				field[road[1]][road[0]][0] = 0;
			}

			int[] oneOfWall = walls.get(wallsI);
			boolean isSearchNM = false;
			field[oneOfWall[1]][oneOfWall[0]][0] = 0;

			field[0][0][0] = 1;

			int[] startPosition = { 0, 0 };
			fieldQueue.add(startPosition);

			while (!fieldQueue.isEmpty() && !isSearchNM) {

				int[] currentPosition = fieldQueue.poll();

				int currentX = currentPosition[0];
				int currentY = currentPosition[1];

				for (int di = 0; di < dx.length; di++) {

					if (currentX + dx[di] >= 0 && currentX + dx[di] < field[0].length && currentY + dy[di] >= 0
							&& currentY + dy[di] < field.length) {
						if (field[currentY + dy[di]][currentX + dx[di]][0] == 0) {

							field[currentY + dy[di]][currentX + dx[di]][0] = field[currentY][currentX][0] + 1;
//							if (currentY + dy[di] == N && currentX + dx[di] == M) {
//								isSearchNM = true;
//								break;
//							}
							int[] addedPosition = { currentX + dx[di], currentY + dy[di] };

							fieldQueue.add(addedPosition);
						}
					}
				}
			}

			if (field[N - 1][M - 1][0] > 0)
				minDistance = Math.min(minDistance, field[N - 1][M - 1][0]);
			field[oneOfWall[1]][oneOfWall[0]][0] = -1;
		}

		if (minDistance == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minDistance);

		// for (int fieldI = 0; fieldI < field.length; fieldI++) {
		// for (int fieldJ = 0; fieldJ < field[fieldI].length; fieldJ++) {
		// System.out.print(copiedField[fieldI][fieldJ] + " ");
		// }
		// System.out.println();
		// }
		// for(int fieldI = 0; fieldI < field.length; fieldI++) {
		// for(int fieldJ = 0; fieldJ < field[fieldI].length; fieldJ++) {
		// System.out.print(field[fieldI][fieldJ] + " ");
		// }
		// System.out.println();
		// }

	}

	public static int[][] copyArray(int[][] source) {

		int[][] copied = new int[source.length][source[0].length];

		for (int sourceI = 0; sourceI < source.length; sourceI++) {

			int[] oneLineOfCopied = new int[source[sourceI].length];

			System.arraycopy(source[sourceI], 0, oneLineOfCopied, 0, source[sourceI].length);
			copied[sourceI] = oneLineOfCopied;
		}

		return copied;
	}

}
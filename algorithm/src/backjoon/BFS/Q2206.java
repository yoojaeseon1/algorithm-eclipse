package backjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][][] field = new int[N][M][2];

		StringBuilder oneLine = new StringBuilder();
		for (int fieldI = 0; fieldI < field.length; fieldI++) {
			oneLine.append(br.readLine());
			for (int fieldJ = 0; fieldJ < field[fieldI].length; fieldJ++) {
				if (oneLine.charAt(fieldJ) == '0') {
					field[fieldI][fieldJ][0] = 0;
				} else {
					field[fieldI][fieldJ][0] = 1;
				}
				field[fieldI][fieldJ][1] = 2;
			}
			oneLine.setLength(0);
		}

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };

		int minDistance = Integer.MAX_VALUE;

		Queue<int[]> fieldQueue = new LinkedList<>();

		int[] firstPosition = { 0, 0 };
		
		field[0][0][0] = 1;
		field[0][0][1] = 0;
		fieldQueue.add(firstPosition);

		while (!fieldQueue.isEmpty()) {

			int[] currentPosition = fieldQueue.poll();

			int currentX = currentPosition[0];
			int currentY = currentPosition[1];
			if(currentX == M-1 && currentY == N-1){
				System.out.println(field[currentY][currentX][0]);
				break;
			}

			for (int di = 0; di < dx.length; di++) {

				if (currentX + dx[di] >= 0 && currentX + dx[di] < field[0].length && currentY + dy[di] >= 0
						&& currentY + dy[di] < field.length) {
					
					if(field[currentY + dy[di]][currentX + dx[di]][1] <= field[currentY][currentX][1])
						continue;

					if (field[currentY + dy[di]][currentX + dx[di]][0] == 0) {

						field[currentY + dy[di]][currentX + dx[di]][0] = field[currentY][currentX][0] + 1;
						field[currentY + dy[di]][currentX + dx[di]][1] = field[currentY][currentX][1];
						int[] addedPosition = { currentX + dx[di], currentY + dy[di] };
						
						fieldQueue.add(addedPosition);

					} else if (field[currentY + dy[di]][currentX + dx[di]][0] == 1
							&& field[currentY][currentX][1] == 0) {
						
						field[currentY + dy[di]][currentX + dx[di]][1] = 1;
						field[currentY + dy[di]][currentX + dx[di]][0] = field[currentY][currentX][0] + 1;
						int[] addedPosition = { currentX + dx[di], currentY + dy[di] };
						fieldQueue.add(addedPosition);

					}
				}
			}
		}

		if (field[N - 1][M - 1][0] == 0)
			System.out.println(-1);
		else
			System.out.println(field[N-1][M-1][0]);

	}

}

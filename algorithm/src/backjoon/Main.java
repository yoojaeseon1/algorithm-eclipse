package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		boolean[][] field = new boolean[n][n];

		StringBuilder lineWord = new StringBuilder();

		for (int fi = 0; fi < field.length; fi++) {

			lineWord.append(br.readLine());

			for (int fj = 0; fj < field[fi].length; fj++) {
				if (lineWord.charAt(fj) == '1')
					field[fi][fj] = true;
				else
					field[fi][fj] = false;
			}
			lineWord.setLength(0);
		}
		
//		for (int fi = 0; fi < field.length; fi++) {
//			for (int fj = 0; fj < field[fi].length; fj++) {
//				System.out.print(field[fi][fj] + " ");
//			}
//			System.out.println();
//		}
		
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		
		Queue<int[]> searchingQueue = new LinkedList<>();

		boolean[][] isEnqueued = new boolean[n][n];
		List<Integer> houseCountList = new ArrayList<>();
		
		for (int fy = 0; fy < n; fy++) {
			for (int fx = 0; fx < n; fx++) {
//				System.out.println("cx : " + cx);
//				System.out.println("cy : " + cy);
//				System.out.println(isEnqueued[cy][cx]);
				if (field[fy][fx] && !isEnqueued[fy][fx]) {
					int houseCount = 0;
//					System.out.println("into if");
//					System.out.println("cx : " + cx);
//					System.out.println("cy : " + cy);
					int[] currentPosition = new int[2];

					currentPosition[0] = fx;
					currentPosition[1] = fy;

					searchingQueue.add(currentPosition);
					isEnqueued[fy][fx] = true;

					while (!searchingQueue.isEmpty()) {
						
						houseCount++;
						
						currentPosition = searchingQueue.poll();

						int currentX = currentPosition[0];
						int currentY = currentPosition[1];
//						System.out.println("current position");
//						System.out.println(currentPosition[0] + ", " + currentPosition[1]);

						for (int di = 0; di < dx.length; di++) {
							if (currentX + dx[di] >= 0 && currentX + dx[di] < n && currentY + dy[di] >= 0
									&& currentY + dy[di] < n) {
								if (field[currentY + dy[di]][currentX + dx[di]]
										&& !isEnqueued[currentY + dy[di]][currentX + dx[di]]) {
									int[] enqueuedPosition = new int[2];
//									System.out.println("is enqueued");
									enqueuedPosition[0] = currentX + dx[di];
									enqueuedPosition[1] = currentY + dy[di];
//									System.out.println(enqueuedPosition[0] + ", " + enqueuedPosition[1]);
									searchingQueue.add(enqueuedPosition);
									isEnqueued[currentY + dy[di]][currentX + dx[di]] = true;
								}
							}
						}
					}
//					System.out.println("------------");
					houseCountList.add(houseCount);
					
				}
			}
		}
		
		System.out.println(houseCountList.size());
		
		Collections.sort(houseCountList);
		
		for(int hci = 0; hci < houseCountList.size(); hci++) {
			System.out.println(houseCountList.get(hci));
		}

	}
}
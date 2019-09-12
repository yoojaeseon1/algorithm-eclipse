package programmers.levelTest.level3;

import java.util.LinkedList;
import java.util.Queue;

public class Q1BFSFail {
	
	// time over
	
	static int MOD = 20170805;
	static Queue<int[]> searchQueue = new LinkedList<>();
	static int[][] modifiedMap;

	public static void main(String[] args) {

//		int[][] cityMap = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
//		int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
//		int[][] cityMap = {{0, 2, 2, 0}, {2, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
		int[][] cityMap = new int[10][10]; // output : 48620
//		int[][] cityMap = new int[11][11]; // output : 184756(time over)
		
		
		
//		System.out.println(solution(3,3,cityMap));
//		System.out.println(solution(3,6,cityMap));
//		System.out.println(solution(4,4,cityMap));
		System.out.println(solution(10,10,cityMap)); 
//		System.out.println(solution(11,11,cityMap)); 

	}

	public static int solution(int m, int n, int[][] cityMap) {

		int answer = 0;

		modifiedMap = new int[m][n];

		for (int mi = 0; mi < modifiedMap.length; mi++) {
			for (int mj = 0; mj < modifiedMap[mi].length; mj++) {
				modifiedMap[mi][mj] = cityMap[mi][mj];
			}
		}

		int[] currentPosition = new int[2];
		currentPosition[0] = 0;
		currentPosition[1] = 0;

		searchQueue.add(currentPosition);

		while (!searchQueue.isEmpty()) {

			currentPosition = searchQueue.poll();

			int currentN = currentPosition[0];
			int currentM = currentPosition[1];

			if (enqueuePosition(currentN, currentM) == 1)
				answer++;

		}

		return answer % MOD;
	}

	public static int enqueuePosition(int currentN, int currentM) {

		int[] nextPosition = new int[2];
		if (currentN == modifiedMap[0].length - 1 && currentM == modifiedMap.length - 1) {
			return 1;
		}
		// move right
		if (currentM >= 0 && currentM < modifiedMap.length && currentN + 1 >= 0
				&& currentN + 1 < modifiedMap[0].length) {
			if (modifiedMap[currentM][currentN + 1] == 0) {
				nextPosition[0] = currentN + 1;
				nextPosition[1] = currentM;
				searchQueue.add(nextPosition);
//				System.out.println("enqueued N:" + nextPosition[0]);
//				System.out.println("enqueued M:" + nextPosition[1]);
				
			} else if (modifiedMap[currentM][currentN + 1] == 2) {
				int movedN = currentN + 1;
//				System.out.println("movedN : " + movedN);
				while (movedN + 1 < modifiedMap[0].length) {
//					System.out.println("moved right : " + (movedN + 1));
//					System.out.println("moved right : " +modifiedMap[currentM][movedN + 1]);
					if (modifiedMap[currentM][movedN + 1] == 1)
						break;
					else if (modifiedMap[currentM][movedN + 1] == 2) {
						movedN++;
//						System.out.println("moved added");
					}
					else {
						nextPosition[0] = movedN + 1;
						nextPosition[1] = currentM;
						searchQueue.add(nextPosition);
//						System.out.println("moved");
//						System.out.println("enqueued N:" + nextPosition[0]);
//						System.out.println("enqueued M:" + nextPosition[1]);
						break;
					}
				}
			}
		}
		
//		System.out.println("------------");

		// move bottom

		nextPosition = new int[2];

		if (currentM + 1 >= 0 && currentM + 1 < modifiedMap.length && currentN >= 0
				&& currentN < modifiedMap[0].length) {
			if (modifiedMap[currentM + 1][currentN] == 0) {
				nextPosition[0] = currentN;
				nextPosition[1] = currentM + 1;
				searchQueue.add(nextPosition);
			} else if (modifiedMap[currentM + 1][currentN] == 2) {
				int movedM = currentM + 1;
				while (movedM + 1 < modifiedMap.length) {
					if (modifiedMap[movedM+1][currentN] == 1)
						break;
					else if (modifiedMap[movedM+1][currentN] == 2)
						movedM++;
					else {
						nextPosition[0] = currentN;
						nextPosition[1] = movedM + 1;
						searchQueue.add(nextPosition);
						break;
					}
				}
			}
		}
		return 0;
	}

}

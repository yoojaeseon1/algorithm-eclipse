package programmers.levelTest.level3;

public class Q1DPFail {

	static int MOD = 20170805;

	public static void main(String[] args) {

//		int[][] cityMap = new int[1][1];
		int[][] cityMap = new int[1][2];
//		int[][] cityMap = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };

//		 int[][] cityMap = new int[3][3];


//		System.out.println(solution(1, 1, cityMap));
		System.out.println(solution(1, 2, cityMap));
//		System.out.println(solution(3, 6, cityMap));
//		 System.out.println(solution(3, 3, cityMap));

	}

	public static int solution(int m, int n, int[][] cityMap) {

		// m = i
		// n = j

		int answer = 0;

		long[][][] routeCountMap = new long[m][n][2];
		// BigInteger[][][] routeCountMap = new BigInteger[m][n][2];

		 routeCountMap[0][0][0] = 1;
		// routeCountMap[0][0][1] = 1;

		for (int rj = 1; rj < routeCountMap[0].length; rj++) {
			// System.out.println("hoho");
			if (cityMap[0][rj] == 0 || cityMap[0][rj] == 2) {
				// System.out.println("rj : " + rj);
				routeCountMap[0][rj][0] = 1;
				// routeCountMap[0][rj][0] = new BigInteger("1");
				 routeCountMap[0][rj][1] = 1;
			} else
				break; // after this (0,0)
		}
		// System.out.println("answer left : " + routeCountMap[m - 1][n - 1][0]
		// );
		// System.out.println("answer top : " + routeCountMap[m - 1][n - 1][1]
		// );

		for (int ri = 1; ri < routeCountMap.length; ri++) {
//			System.out.println("haha");
			if (cityMap[ri][0] == 0 || cityMap[ri][0] == 2) {
				routeCountMap[ri][0][1] = 1;
				// routeCountMap[ri][0][1] = new BigInteger("1");
			} else
				break;
		}

		for (int ri = 1; ri < routeCountMap.length; ri++) {
			// System.out.println("haha");
			for (int rj = 1; rj < routeCountMap[ri].length; rj++) {

				if (cityMap[ri][rj] == 1) {
					routeCountMap[ri][rj][0] = 0;
					routeCountMap[ri][rj][1] = 0;
					// routeCountMap[ri][rj][0] = new BigInteger("0");;
					// routeCountMap[ri][rj][1] = new BigInteger("0");;
					continue;
				}

				// check left route

				if (cityMap[ri][rj - 1] == 0) {
					routeCountMap[ri][rj][0] = routeCountMap[ri][rj - 1][0] + routeCountMap[ri][rj - 1][1];
					routeCountMap[ri][rj][0] %= MOD;
				} else if (cityMap[ri][rj - 1] == 1) {
					routeCountMap[ri][rj][0] = 0;
				} else {
					routeCountMap[ri][rj][0] = routeCountMap[ri][rj-1][0];
					routeCountMap[ri][rj][0] %= MOD;
//					int movedJ = rj - 1;
//					while (movedJ >= 0) {
//						if (cityMap[ri][movedJ] == 0) {
//							routeCountMap[ri][rj][0] = routeCountMap[ri][movedJ][0] + routeCountMap[ri][movedJ][1];
//							break;
//						} else if (cityMap[ri][movedJ] == 1) {
//							routeCountMap[ri][rj][0] = 0;
//							break;
//						} else {
//							routeCountMap[ri][rj][0] = routeCountMap[ri][movedJ][0];
////							movedJ--;
//						}
//					}
				}

				// check upper route

				if (cityMap[ri - 1][rj] == 0) {
					routeCountMap[ri][rj][1] = routeCountMap[ri - 1][rj][0] + routeCountMap[ri - 1][rj][1];
					routeCountMap[ri][rj][1] %= MOD;
				} else if (cityMap[ri - 1][rj] == 1) {
					routeCountMap[ri][rj][1] = 0;
				} else {
					routeCountMap[ri][rj][1] = routeCountMap[ri-1][rj][1];
					routeCountMap[ri][rj][1] %= MOD;
					
//					int movedI = ri - 1;
//					while (movedI >= 0) {
//						if (cityMap[movedI][rj] == 0) {
//							routeCountMap[ri][rj][1] = routeCountMap[movedI][rj][0] + routeCountMap[movedI][rj][1];
//							break;
//						} else if (cityMap[movedI][rj] == 1) {
//							routeCountMap[ri][rj][1] = 0;
//							break;
//						} else
//							movedI--;
//					}
				}
			}
		}

		// System.out.println("answer left : " + routeCountMap[m - 1][n - 1][0]
		// );
		// System.out.println("answer top : " + routeCountMap[m - 1][n - 1][1]
		// );

		answer = (int)(routeCountMap[m - 1][n - 1][0] + routeCountMap[m - 1][n - 1][1]);

		// for(long ri = 0; ri < routeCountMap.length; ri++) {
		// for(long rj = 0; rj < routeCountMap[ri].length; rj++) {
		// System.out.prlong("(" + routeCountMap[ri][rj][0] + " , " +
		// routeCountMap[ri][rj][1] + ") ");
		// }
		// System.out.prlongln();
		// }

		return answer;
		// return answer;
	}

}

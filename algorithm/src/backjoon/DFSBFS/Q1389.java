package backjoon.DFSBFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1389 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int maxRelation = 100;
		boolean[][] relations = new boolean[maxRelation][maxRelation];
		int visitCount;
		// int relationCount;
		int[] relationCnts = new int[maxRelation];
		int[] kebinCounts = new int[maxRelation];
		int kebin = 101;
		int x, y;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			relations[y - 1][x - 1] = true;
			relations[x - 1][y - 1] = true;
		}

		Stack<int[]> relationStack = new Stack<>();
		int[] pushedIndex;
		int[] curIndex;
		for (int i = 0; i < maxRelation; i++) {
			// System.out.println("i : " + (i+1));
			relationCnts = new int[maxRelation];
			visitCount = 0;
			// relationCount = 1;
			// System.out.println("i : " + i);
			for (int j = 0; j < maxRelation; j++) {
				if (relations[i][j]) {
					// System.out.println("visit : " + (j+1));
					relationCnts[j] = 1;
					pushedIndex = new int[2];
					pushedIndex[0] = j;
					pushedIndex[1] = 1;
					relationStack.push(pushedIndex);
					visitCount++;
				}
			}
			// relationCount++;

			while (!relationStack.isEmpty()) {
				curIndex = relationStack.pop();
				// System.out.println("curIndex : " + (curIndex[0]+1));
				for (int j = 0; j < maxRelation; j++) {
					if (relations[curIndex[0]][j] && relationCnts[j] == 0 && i != j) {
						// System.out.println("visit : " + (j+1));
						relationCnts[j] = curIndex[1] + 1;
						pushedIndex = new int[2];
						pushedIndex[0] = j;
						pushedIndex[1] = curIndex[1] + 1;
						relationStack.push(pushedIndex);
						visitCount++;
					}
					// System.out.println("visitCount : " + visitCount);
					if (visitCount == n - 1) {
						relationStack.clear();
						break;
					}
				}
			}
			// System.out.println(kebinCounts[i]);
			System.out.println("i : " + (i + 1));
			for (int j = 0; j < 5; j++) {
				System.out.println((j + 1) + " : " + relationCnts[j]);
				kebinCounts[i] += relationCnts[j];
				// System.out.print(relationCnts[j] + " ");
			}
			System.out.println("---------------");
			// System.out.println();
			// System.out.println("--------------");
			if (kebinCounts[i] != 0) {
				kebin = Math.min(kebin, kebinCounts[i]);
			}
			// System.err.println("kebin : " + kebin);
			// System.out.println();
		}
		// System.err.println("kebin : " + kebin);

		for (int i = 0; i < kebinCounts.length; i++) {
			// System.out.println(kebinCounts[i]);
			if (kebinCounts[i] == kebin) {
				System.out.print(i + 1);
				break;
			}
		}
	}

}

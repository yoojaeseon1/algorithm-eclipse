package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] fees = new int[n + 1][n + 1];

		StringTokenizer st;

		for (int i = 0; i < m; i++) {

			st = new StringTokenizer(br.readLine());
			int startLocation = Integer.parseInt(st.nextToken());
			int endLocation = Integer.parseInt(st.nextToken());
			int fee = Integer.parseInt(st.nextToken());

			if (fees[startLocation][endLocation] == 0)
				fees[startLocation][endLocation] = fee;
			else
				fees[startLocation][endLocation] = Math.min(fees[startLocation][endLocation], fee);

		}

		Stack<FloydPosition> routeStack = new Stack<>();
		int[][] minFees = new int[n + 1][n + 1];
		// boolean[][] pushed = new boolean[n+1][n+1];
		boolean[] visited;
		FloydPosition curPosition;

		for (int fi = 1; fi < fees.length; fi++) {
			// pushed = new boolean[n+1][n+1];
//			System.out.println("fi: " + fi);
			for (int fj = 1; fj < fees[fi].length; fj++) {
				if (fees[fi][fj] > 0) {
					minFees[fi][fj] = fees[fi][fj];
					// curPosition = new int[2];
					// curPosition[0] = fj;
					// curPosition[1] = minFees[fi][fj];
					visited = new boolean[n + 1];
					visited[fi] = true;
					routeStack.push(new FloydPosition(fj, minFees[fi][fj], visited));
					// pushed[fi][fj] = true;
//					System.out.println("push(fj): " + fj);
				}
			}

			while (!routeStack.isEmpty()) {
				curPosition = routeStack.pop();
				// pushed[fi][curPosition[0]] = true;
				curPosition.setVisitedElement(curPosition.getCurPosition());
				int position = curPosition.getCurPosition();
//				System.out.println("pop : " + position);
				// System.out.println("curPosition : " + curPosition[0]);
				for (int fj = 1; fj < fees[fi].length; fj++) {

					if (fees[position][fj] > 0 && !curPosition.getVisited()[fj]) {

//						System.out.println("fj : " + fj);
//						System.out.println("before minFee : " + minFees[fi][fj]);
//						System.out.println("sumOfFee : " + curPosition.getSumOfFee());
//						System.out.println("new sum : " + curPosition.getSumOfFee() + fees[curPosition.getCurPosition()][fj]);
						if (minFees[fi][fj] == 0)
							minFees[fi][fj] = curPosition.getSumOfFee() + fees[curPosition.getCurPosition()][fj];
						else
							minFees[fi][fj] = Math.min(minFees[fi][fj],
									curPosition.getSumOfFee() + fees[curPosition.getCurPosition()][fj]);

						boolean[] nextVisited = new boolean[n + 1];
						System.arraycopy(curPosition.getVisited(), 0, nextVisited, 0, n + 1);

						FloydPosition nextPosition = new FloydPosition(fj,
								curPosition.getSumOfFee() + fees[curPosition.getCurPosition()][fj], nextVisited);

						routeStack.push(nextPosition);
//						System.out.println("changed : " + minFees[fi][fj]);

					}

					// if(fees[curPosition[0]][fj] > 0 &&
					// !pushed[fj][curPosition[0]]) {
					// System.out.println("push(fj): " + fj);
					// System.out.println("---------");
					// minFees[fi][fj] = Math.min(minFees[fi][fj],
					// fees[curPosition[0]][fj] + curPosition[1]);
					// int[] nextPosition = new int[2];
					// nextPosition[0] = fj;
					// nextPosition[1] = minFees[fi][fj];
					// routeStack.push(nextPosition);
					// pushed[curPosition[0]][fj] = true;
					// }

				}

			}
//			System.out.println("-------------");

		}

		for (int fi = 1; fi < fees.length; fi++) {
			for (int fj = 1; fj < fees[fi].length; fj++) {
				System.out.print(minFees[fi][fj] + " ");
			}
			System.out.println();
		}

		// System.out.println("-----------");
		//
		// for (int fi = 1; fi < fees.length; fi++) {
		// for (int fj = 1; fj < fees[fi].length; fj++) {
		// System.out.print(fees[fi][fj] + " ");
		// }
		// System.out.println();
		// }
	}
}

class FloydPosition {

	private int curPosition;
	private int sumOfFee;
	private boolean[] visited;

	public FloydPosition() {
		// TODO Auto-generated constructor stub
	}

	public FloydPosition(int curPosition, int sumOfFee, boolean[] visited) {
		this.curPosition = curPosition;
		this.sumOfFee = sumOfFee;
		this.visited = visited;
	}

	public int getCurPosition() {
		return curPosition;
	}

	public int getSumOfFee() {
		return sumOfFee;
	}

	public boolean[] getVisited() {
		return visited;
	}

	public void setCurPosition(int curPosition) {
		this.curPosition = curPosition;
	}

	public void setSumOfFee(int sumOfFee) {
		this.sumOfFee = sumOfFee;
	}

	public void setVisited(boolean[] visited) {
		this.visited = visited;
	}

	public void setVisitedElement(int location) {
		this.visited[location] = true;
	}

}
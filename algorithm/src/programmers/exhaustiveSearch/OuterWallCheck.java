package programmers.exhaustiveSearch;

public class OuterWallCheck {
	
	public static void main(String[] args) {

		int[] source = { 1, 2, 3, 4, 5 };

		// int[] permuted = doPermutation(source, source.length, 2,
		// selectedIndices, 0, visited);
		// doPermutation(source, source.length, 2, selectedIndices, 0, visited);

		int n = 12;

		int[] weak = { 1, 5, 6, 10 };
		int[] dist = { 1, 2, 3, 4 };
//		int[] weak = {1,3,4,9,10};
//		int[] dist = {3,5,7};
		

		System.out.println("main's answer : " + solution(n, weak, dist));

	}

	static int n;
	static int answer;
	static int[][] rearrangedWeak;
	static int[] dist;

	public static int solution(int n, int[] weak, int[] dist) {

		OuterWallCheck.n = n;
		OuterWallCheck.dist = dist;
		OuterWallCheck.answer = dist.length+1;

		int[][] rearrangedWeak = new int[weak.length][weak.length];

		for (int rwi = 0; rwi < rearrangedWeak.length; rwi++) {

			rearrangedWeak[rwi][0] = weak[rwi];

			for (int rwj = 1; rwj < rearrangedWeak.length; rwj++) {

				if (rwi + rwj < rearrangedWeak.length)
					rearrangedWeak[rwi][rwj] = weak[rwi + rwj];
				else {
					rearrangedWeak[rwi][rwj] = weak[rwi + rwj - weak.length] + n;
				}

				// for (int wi = rwi + 1; wi != rwi; wi++) {
				//
				// if(wi > rwi) rearrangedWeak[rwi][wi] = weak[]
				//
				//
				//
				// if (wi + 1 > weak.length)
				// wi = -1;
			}
		}

		OuterWallCheck.rearrangedWeak = rearrangedWeak;

		int[] selectedIndices = new int[dist.length];

		boolean[] visited = new boolean[dist.length];

		for (int di = 1; di <= dist.length; di++) {
			doPermutation(dist, dist.length, di, selectedIndices, 0, visited);
		}

		// for(int rwi = 0; rwi < rearrangedWeak.length; rwi++) {
		//
		// for(int rwj = 0; rwj < rearrangedWeak.length; rwj++) {
		//
		// System.out.print(rearrangedWeak[rwi][rwj] + " ");
		//
		// }
		// System.out.println();
		//
		// }

		return answer;
	}

	// public static int[] doPermutation(int[] source, int n, int r, int[]
	// selectedIndices, int selectedIndex, boolean[] visited) {
	public static void doPermutation(int[] source, int n, int r, int[] selectedIndices, int selectedIndex,
			boolean[] visited) {

		if (r == 0) {

			int[] pickedNums = new int[selectedIndex];

			for (int selectedI = 0; selectedI < selectedIndex; selectedI++) {
				pickedNums[selectedI] = source[selectedIndices[selectedI]];
				 System.out.print(pickedNums[selectedI] + " ");
			}
			 
			System.out.println();
			System.out.println("----------");

			int minDist = calculateMinDist(pickedNums);
//			System.out.println("------------------------------");
			System.out.println("minDist : " + minDist);
			if (minDist != -1 && minDist != dist.length+1) {
				System.out.println("into if-minDist : " + minDist);
				System.out.println("into if-answer : " + answer);
				
				answer = Math.min(answer, minDist);
				System.out.println("answer : " + answer);
				return;
			}
			System.out.println("--------------");

			// return pickedNums;

		} else if (r >= answer) {
			System.out.println("else if");
			return;
		}
		else {

			// si means source's index

			for (int si = 0; si < n; si++) {
				if (!visited[si]) {
					visited[si] = true;
					selectedIndices[selectedIndex] = si;
					doPermutation(source, n, r - 1, selectedIndices, selectedIndex + 1, visited);
					visited[si] = false;
					selectedIndices[selectedIndex] = -1;
				}
			}
		}

		// int[] pickedNums = {1,2};
		// int[] pickedNums = {7,8};
		//
		// return pickedNums;

	}

	public static int calculateMinDist(int[] pickedNums) {
		
		System.out.println("calculateMinDist's pickedNums.length : " + pickedNums.length);

		int begin = 0;
		int end = 1;

		int pi = 0;

		int answer = -1;

		for (int rwi = 0; rwi < rearrangedWeak.length; rwi++) {
			
			for(int rwj = 0; rwj  < rearrangedWeak.length; rwj++)
				System.out.print(rearrangedWeak[rwi][rwj] + " ");
			System.out.println();
			begin = 0;
			end = 1;
			pi = 0;
			int distance = Integer.MAX_VALUE;
			while (end < rearrangedWeak.length && pi < pickedNums.length) {
				distance = rearrangedWeak[rwi][end] - rearrangedWeak[rwi][begin];

				if (distance < pickedNums[pi]) {
					System.out.println("next");
					end++;
				} else if (distance > pickedNums[pi]) {
					System.out.println("one selected");
					begin = end;
					end = begin + 1;
					pi++;
				} else {
					System.out.println("one more selected");
					begin = end + 1;
					end = begin + 1;
					pi++;
				}
			}
			
			System.out.println("end : " + end);
			System.out.println("pi : " + pi);
			if (end == rearrangedWeak.length + 1 && (pi == pickedNums.length || (pi == pickedNums.length - 1 && distance < pickedNums[pi])) ) {
				System.out.println("correct answer-------------");
				return pickedNums.length;
			}
			System.out.println("-------------");
		}

		return -1;

	}

}

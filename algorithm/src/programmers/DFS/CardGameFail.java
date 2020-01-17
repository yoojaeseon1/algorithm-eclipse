package programmers.DFS;


// most of cases : time over

// ���̿� �ִ� ī����� �ʹ� ���Ƽ� ���� Ž���ϸ� Ž���ؾ� �ϴ� ����� ���� �ʹ� ��������.

public class CardGameFail {
	
	
	
	public static void main(String[] args) {

		int[] left = { 3, 2, 5 };

		int[] right = { 2, 4, 1 };

		System.out.println(solution(left, right));

	}

	private static int maxPoint;

	public static int solution(int[] left, int[] right) {

		maxPoint = 0;

		doDFS(left, right, 0, 0, 0);

		return maxPoint;
	}

	public static void doDFS(int[] left, int[] right, int currentLeftIndex, int currentRightIndex, int point) {
		

		if (currentLeftIndex  > left.length - 1 || currentRightIndex > right.length - 1) {
			maxPoint = Math.max(maxPoint, point);
			return;
		}
		
		currentLeftIndex++;
		doDFS(left, right, currentLeftIndex, currentRightIndex, point);
		
		currentRightIndex++;
		doDFS(left, right, currentLeftIndex, currentRightIndex, point);
		
		currentLeftIndex--;
		currentRightIndex--;
		if (right[currentRightIndex] < left[currentLeftIndex]) {
			point += right[currentRightIndex++];
			doDFS(left, right, currentLeftIndex, currentRightIndex, point);
		}	
	}

}

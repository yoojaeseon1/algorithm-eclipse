package programmers.levelTest.level2;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
	
	static List<int[]> combiList = new ArrayList<>();

	public static void main(String[] args) {

		// int n = 5;
		//
		// int r = 3;
		//
		// int[] combArr = new int[n];
		//
		// int[] arr = {1,2,7,6,4};
		//
		// doCombination(combArr, n,r,0,0,arr);
		// System.out.println("-----------");

		int[] nums = { 1,2,3,4 };

		System.out.println(solution(nums));

	}

	public static int solution(int[] nums) {

		int[] combArr = new int[nums.length];

		int n = nums.length;

		int r = 3;
		
		int primeCount = 0;

		doCombination(combArr, n, r, 0, 0, nums);

		for (int ci = 0; ci < combiList.size(); ci++) {

			int combiSum = combiList.get(ci)[0] + combiList.get(ci)[1] + combiList.get(ci)[2];
			
			if(checkIsPrime(combiSum)) primeCount++;
			
		}

		return primeCount;

	}

	public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr) {
		// System.out.println("=> " + n + " " + r + " " + index + " " + target);

		// r ==0 이란 것은 뽑을 원소를 다 뽑았다는 뜻.
		if (r == 0) {
			// System.out.println(Arrays.toString(combArr));
			int[] combiArray = new int[3];
			for (int i = 0; i < index; i++) {
				combiArray[i] = arr[combArr[i]];
				// System.out.print(arr[combArr[i]] + " ");
			}
			combiList.add(combiArray);
			// System.out.println();

		} else if (target == n) {

			return;

		} else {
			combArr[index] = target;
			doCombination(combArr, n, r - 1, index + 1, target + 1, arr);

			doCombination(combArr, n, r, index, target + 1, arr);
		}
	}

	public static boolean checkIsPrime(int num) {

		if (num == 2)
			return true;
		else if (num % 2 == 0)
			return false;
		else {

			for (int checkNum = num / 2; checkNum > 1; checkNum--) {
				if (num % checkNum == 0)
					return false;
			}
			return true;
		}
	}

}

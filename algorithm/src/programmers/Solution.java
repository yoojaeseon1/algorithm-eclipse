package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

//		int[] progresses = { 93, 30, 55 };
//		int[] speeds = { 1, 30, 5 };
//
////		System.out.println(solution(progresses, speeds));
//		
//		
//		Map<Integer, String> testMap = new HashMap<>();
//		
//		testMap.put(1, "haha");
//		testMap.put(2, "hoho");
//		
//		List<Integer> testList = new ArrayList<>();
//		
//		testList.addAll(testMap.keySet());
//		
//		
//		for(int testListI = 0; testListI < testList.size(); testListI++) {
//			
//			System.out.println(testList.get(testListI));
//			
//		}
		
		int[][] testArray = new int[5][5];
		
		Arrays.sort(testArray, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});
		
		
		
	}

	public static int[] solution(int[] progresses, int[] speeds) {

		int[] requiredDates = new int[progresses.length];
		int currentRequiredDate = 0;
		for (int pi = 0; pi < progresses.length; pi++) {
			currentRequiredDate = 0;
			while (progresses[pi] < 100) {
				progresses[pi] += speeds[pi];
				currentRequiredDate++;
			}
			requiredDates[pi] = currentRequiredDate;
		}

		List<Integer> progressesList = new ArrayList<>();
		int currentDate = requiredDates[0];
		int progressCount = 1;
		for (int ci = 1; ci < requiredDates.length; ci++) {

			if (requiredDates[ci] <= currentDate)
				progressCount++;
			else {
				progressesList.add(progressCount);
				currentDate = requiredDates[ci];
				progressCount = 1;
			}
		}
		progressesList.add(progressCount);
		
		int[] answer = new int[progressesList.size()];
		for (int ai = 0; ai < answer.length; ai++) {
			answer[ai] = progressesList.get(ai);
		}

		return answer;
	}
}
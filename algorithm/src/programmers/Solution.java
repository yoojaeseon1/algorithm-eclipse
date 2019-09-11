package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	static List<List<Integer>> combiList;
	
	public static void main(String[] args) {

		// boolean[] source = {true,true,false};
		//
		// Position test = new Position(5, source);
		//
		// source[1] = false;

//		int[] numbers = { 1, 1, 1, 1, 1 };
//
//		System.out.println(solution(numbers, 3));
		
		int[] source = {1,1,1,1,1};
		int[] selectedIndices = new int[source.length];
		
		int n = source.length;
		int r = 3;
		
		System.out.println(solution(source, 3));
		
//		doCombination(source, n, r, selectedIndices, 0,0);

	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;
		
		combiList = new ArrayList<>();
		
		int[] selectedIndices = new int[numbers.length];
		
		for(int ni = 1; ni <= numbers.length; ni++) {
			
			doCombination(numbers, numbers.length, ni, selectedIndices, 0, 0);
			
		}
		
		for(int ci = 0; ci < combiList.size(); ci++) {
			for(int cj = 0; cj < combiList.get(ci).size(); cj++) {
//				System.out.print(combiList.get(ci).get(cj) + " ");
			}
//			System.out.println();
		}
//		System.out.println("haha");
		
		
//		doCombination(numbers, numbers.length, 3, selectedIndices, 0, 0);
		
		int sumOfNumbers = 0;
		
		for(int ni = 0; ni < numbers.length; ni++) {
			sumOfNumbers += numbers[ni];
		}
		
		
		for(int ci = 0; ci < combiList.size(); ci++) {
			int minucedSum = sumOfNumbers;
			for(int cj = 0; cj < combiList.get(ci).size(); cj++) {
				minucedSum -= (numbers[combiList.get(ci).get(cj)] * 2);
			}
//			System.out.println("ci : " + ci);
//			System.out.println("minuced sum : " + minucedSum);
			if(target == minucedSum) {
				answer++;
			}
			
		}
		return answer;
	}
	
	public static void doCombination(int[] source, int n, int r, int[] selectedIndices, int selectedIndex,  int target) {
		
		if(r == 0) {
			
			List<Integer> currentCombiList = new ArrayList<>();
			for(int si = 0; si < selectedIndex; si++) {
				currentCombiList.add(selectedIndices[si]);

			}

			combiList.add(currentCombiList);
			
		} else if(n == target) return;
		else {
			
			selectedIndices[selectedIndex] = target;
//			System.out.println("do combi");
			doCombination(source, n, r-1, selectedIndices, selectedIndex+1, target+1);
			
			doCombination(source, n, r, selectedIndices, selectedIndex, target+1);

		}
	
	}

}


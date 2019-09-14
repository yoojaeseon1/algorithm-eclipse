package programmers.BFSDFS;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SearchingPrime {
	
	// static List<Integer> permuList;
	static Set<Integer> permuSet;

	public static void main(String[] args) {

		 System.out.println(solution("17"));
//		System.out.println(solution("11110"));

		// for(int pi = 0; pi < permuList.size(); pi++) {
		// System.out.println(permuList.get(pi));
		// }

		// System.out.println(Integer.parseInt("011"));

	}

	public static int solution(String numbers) {

		// permuList = new ArrayList<>();
		permuSet = new HashSet<>();

		for (int ni = 1; ni <= numbers.length(); ni++) {

			boolean[] visited = new boolean[numbers.length()];
			int[] selectedIndices = new int[ni];
			doPermutation(numbers, numbers.length(), ni, selectedIndices, 0, visited);
		}

		Iterator permuIter = permuSet.iterator();
		int maxNum = 0;
		while (permuIter.hasNext()) {
			int currentNum = (int) permuIter.next();
			// System.out.println(currentNum);
			maxNum = Math.max(maxNum, currentNum);
		}
//		System.out.println(maxNum);

		int[] prime = makePrimeArray(maxNum);
		int answer = 0;
		permuIter = permuSet.iterator();
		while (permuIter.hasNext()) {
			int currentNum = (int) permuIter.next();
			if (prime[currentNum] != 0)
				answer++;
		}

		// List<Integer> answerList = new ArrayList<>();
		// Map<Integer, Integer> answerMap = new HashMap<>();

		// for (int pi = 0; pi < permuList.size(); pi++) {
		//
		// int currentNumber = permuList.get(pi);
		// // System.out.println("currentNumber : " + currentNumber);
		// if (checkIsPrime(currentNumber) &&
		// !answerList.contains(currentNumber)) {
		// // if(checkIsPrime(currentNumber) &&
		// // !answerMap.containsKey(currentNumber)) {
		// System.out.println("prime : " + currentNumber);
		// answerList.add(currentNumber);
		// // answerMap.put(currentNumber, 0);
		// }
		// }

		// return permuList.size();
		// return answerMap.size();
		// return permuSet.size();
		return answer;
	}

	public static void doPermutation(String source, int n, int r, int[] selectedIndices, int selectedIndex,
			boolean[] visited) {

		if (r == selectedIndex) {
			StringBuilder permuStr = new StringBuilder();
			for (int si = 0; si < selectedIndex; si++) {
				permuStr.append(source.charAt(selectedIndices[si]));
			}
			// System.out.println(permuStr);
			// int permuNum = Integer.parseInt(permuStr.toString());
			// if (checkIsPrime(permuNum))
			permuSet.add(Integer.parseInt(permuStr.toString()));

			return;
		}
		for (int vi = 0; vi < n; vi++) {
			if (!visited[vi]) {
				visited[vi] = true;
				selectedIndices[selectedIndex] = vi;
				doPermutation(source, n, r, selectedIndices, selectedIndex + 1, visited);
				visited[vi] = false;
				selectedIndices[selectedIndex] = 0;
			}
		}
	}

	public static boolean checkIsPrime(int num) {

		if (num == 2)
			return true;
		else if (num <= 1 || num % 2 == 0)
			return false;
		else {

			for (int checkNum = num / 2; checkNum > 1; checkNum--) {
				if (num % checkNum == 0)
					return false;
			}
			return true;
		}
	}

	public static int[] makePrimeArray(int maxNum) {

		int[] answer = new int[maxNum + 1];

		for (int ai = 2; ai <= maxNum; ai++) {
			answer[ai] = ai;
		}

		for (int ai = 2; ai <= maxNum; ai++) {
			if (answer[ai] == 0)
				continue;
			for (int aj = 2 * ai; aj <= maxNum; aj += ai) {
				answer[aj] = 0;
			}
		}

		return answer;
	}

}

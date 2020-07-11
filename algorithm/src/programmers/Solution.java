package programmers;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

>>>>>>> branch 'master' of https://github.com/yoojaeseon1/algorithm
public class Solution {

	public static void main(String[] args) {

<<<<<<< HEAD
//		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
//				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
//				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
//				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
//				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		
		char[][] board = 	{
				  {'8','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				};
		System.out.println(isValidSudoku(board));

=======
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
		
		
		
>>>>>>> branch 'master' of https://github.com/yoojaeseon1/algorithm
	}

	public static boolean isValidSudoku(char[][] board) {

		boolean[] isUsed = new boolean[10];

		for (int boardI = 0; boardI < board.length; boardI++) {
			isUsed = new boolean[10];
			// System.out.println("boardI : " + boardI);
			for (int boardJ = 0; boardJ < board[boardI].length; boardJ++) {
				// System.out.println("boardJ : " + boardJ);
				int positionNumber = (int) board[boardI][boardJ] - 48;
				if (positionNumber > 0 && positionNumber < 10) {

					if (!isUsed[positionNumber])
						isUsed[positionNumber] = true;
					else
						return false;
				}

			}
			// System.out.println("------");
		}
		for (int boardI = 0; boardI < board.length; boardI++) {
			isUsed = new boolean[10];
			for (int boardJ = 0; boardJ < board[boardI].length; boardJ++) {
				int positionNumber = (int) board[boardJ][boardI] - 48;
				if (positionNumber > 0 && positionNumber < 10) {
					if (!isUsed[positionNumber])
						isUsed[positionNumber] = true;
					else {
						return false;
					}
				}
			}
			// System.out.println("------");
		}

		int[][] blockNumber = { { 0, 0 }, { 0, 3 }, { 0, 6 }, { 3, 0 }, { 3, 3 }, { 3, 6 }, { 6, 0 }, { 6, 3 },
				{ 6, 6 } };

		for (int blockI = 0; blockI < blockNumber.length; blockI++) {
			int startI = blockNumber[blockI][0];
			int startJ = blockNumber[blockI][1];
			isUsed = new boolean[10];
			for (int boardI = startI; boardI < startI + 3; boardI++) {
				for (int boardJ = startJ; boardJ < startJ + 3; boardJ++) {
					int positionNumber = (int) board[boardI][boardJ] - 48;
					if (positionNumber > 0 && positionNumber < 10) {
						if (!isUsed[positionNumber])
							isUsed[positionNumber] = true;
						else {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
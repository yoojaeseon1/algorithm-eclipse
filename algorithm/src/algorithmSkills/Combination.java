package algorithmSkills;

public class Combination {

	public static void main(String[] args) {

		Combination ex = new Combination();
		int[] source = { 1, 2, 3, 4, 5 };
		int n = source.length;
		int r = 2;
		int[] selectedIndice = new int[r];

//		ex.doCombination(source, n, r, selectedIndice, 0, 0);  // n = 5, r = 2
		
		System.out.println(computeCombiValue(4,2));
		
	}

	
	// other method name : searchAllRoute, searchAllCases
	
	public void doCombination(int[] source, int n, int r, int[] selectedIndices, int selectedIndex, int targetIndex) {
		// System.out.println("=> " + n + " " + r + " " + index + " " + target);

		// r ==0 means already selectd enough elements
		if (r == 0) {
			// System.out.println(Arrays.toString(combArr));
			
			System.out.println("selectedIndex : " + selectedIndex);
			for (int si = 0; si < selectedIndex; si++) {
				System.out.print(source[selectedIndices[si]] + " ");
				
			}
			System.out.println();

		} else if (targetIndex == n) {

			System.out.println("target : " + targetIndex);
			System.out.println("n : " + n);
			return;

		} else {
			selectedIndices[selectedIndex] = targetIndex;

			// select a element in source array
			doCombination(source, n, r - 1, selectedIndices, selectedIndex + 1, targetIndex + 1);

			// not select and plus one index of source array(target)
			doCombination(source, n, r, selectedIndices, selectedIndex, targetIndex + 1);
		}
	}
	
	
	public static int computeCombiValue(int n, int r) {
		
		int answer = computePactorial(n) / (computePactorial(r) * computePactorial(n-r));
		
		
		return answer;
	}
	
	public static int computePactorial(int n) {
		
		if(n == 1)
			return 1;
		else
			return computePactorial(n-1) * n;
		
		
	}
	
	public static int computePermuValue(int n, int r) {
		
		int answer = computePactorial(n) / computePactorial(n-r);
		
		return answer;
		
	}
}
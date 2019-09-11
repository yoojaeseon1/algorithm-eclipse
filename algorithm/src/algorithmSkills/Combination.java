package algorithmSkills;

public class Combination {
	
	public static void main(String[] args) {
		
		Combination ex = new Combination();
		int[] source = {1,2,3,4,5};
		int n = source.length;
		int r = 2;
		int[] selectedIndice = new int[n];

		ex.doCombination(source, n, r, selectedIndice, 0, 0); // n = 3, r = 2
	}

	public void doCombination( int[] source, int n, int r, int[] selectedIndice, int selectedIndex, int target) {
//		System.out.println("=> " + n + " " + r + " " + index + " " + target);

		// r ==0 means already selectd enough elements
		if (r == 0) {
//			System.out.println(Arrays.toString(combArr));
			for (int si = 0; si < selectedIndex; si++)
				System.out.print(source[selectedIndice[si]] + " ");

			System.out.println();

		} else if (target == n) {
			
			System.out.println("target : " + target);
			System.out.println("n : " + n);
			return;

		} else {
			selectedIndice[selectedIndex] = target;
			
			// select a element in source array
			doCombination(source,  n, r - 1, selectedIndice, selectedIndex + 1, target + 1);

			// not select and plus one index of source array(target)
			doCombination(source, n, r, selectedIndice, selectedIndex, target + 1);
		}
	}
}
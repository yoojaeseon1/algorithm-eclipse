package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int goodWordCount = 0;
		for (int wordCount = 0; wordCount < N; wordCount++) {

			StringBuilder currentWord = new StringBuilder(br.readLine());

			int first, last = 0;
			boolean[] visitedCheck = new boolean[currentWord.length()];

			first = 0;
			visitedCheck[0] = true;
			for (int wi = 1; wi < currentWord.length(); wi++) {
				if (currentWord.charAt(first) == currentWord.charAt(wi)) {
					last = wi;
					visitedCheck[last] = true;
					break;
				}
			}
			int nextFirst;
			boolean goodCheck = true;
			for (int wi = 1; wi < currentWord.length(); wi++) {
				if (!visitedCheck[wi]) {
					nextFirst = wi;
					for (int wj = wi + 1; wj < currentWord.length(); wj++) {
						if (!visitedCheck[wj] && (currentWord.charAt(wj) == currentWord.charAt(nextFirst))) {
							if (last > nextFirst && last < wj) {
								goodCheck = false;
								break;
							} else {
								first = nextFirst;
								last = wj;
								visitedCheck[first] = true;
								visitedCheck[last] = true;
								break;
							}
						}
					}
					if (!goodCheck)
						break;
				}
			}
			
			if(goodCheck) goodWordCount++;
		}
		System.out.println(goodWordCount);
	}
}
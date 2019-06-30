package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int J = Integer.parseInt(br.readLine());
		int minRange = 1;
		int maxRange = M;
		int minMoveCount = 0;
		
		for(int appleCount = 0; appleCount < J; appleCount++) {
			int moveCount = 0;
			int appleLocation = Integer.parseInt(br.readLine());
			
			if(appleLocation < minRange) {
				
				while(appleLocation != minRange) {
					minRange--;
					moveCount++;
				}
//				minRange = appleLocation;
				maxRange = maxRange - moveCount;
				
			} else if(appleLocation > maxRange) {
				while(appleLocation != maxRange) {
					maxRange++;
					moveCount++;
				}
				minRange = minRange + moveCount;
//				maxRange = appleLocation;
			}
			minMoveCount += moveCount;
		}
		System.out.println(minMoveCount);
	}
}
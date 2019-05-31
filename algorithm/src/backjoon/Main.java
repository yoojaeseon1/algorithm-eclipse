package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		
		String[] DNAs = new String[N]; // 자체가 약어일 때 변수명 짓는 방법 알아보자
		
		for(int di = 0; di < N; di++) {
			DNAs[di] = br.readLine();
		}
		
		Map<String, Integer> DNAMap = new HashMap<>();
//		StringBuilder currentDNA = new StringBuilder();
//		StringBuilder comparedDNA = new StringBuilder();
		int curHamDistanceSum = 0;
		int minHamDistanceSum = (N-1) * M;
		
		for(int curI = 0; curI < N; curI++) {
			for(int comI = 0; comI < N; comI++) {
				if(curI == comI) continue;
				for(int bothI = 0; bothI < M; bothI++) {
					if(DNAs[curI].charAt(bothI) != DNAs[comI].charAt(bothI)) {
						curHamDistanceSum++;
						System.out.print(DNAs[curI].charAt(bothI) + " ");
					}
				}
				System.out.println();
				System.out.println("-----------");
			}
			System.out.println("end");
			minHamDistanceSum = Math.min(minHamDistanceSum, curHamDistanceSum);
			DNAMap.put(DNAs[curI], curHamDistanceSum);
			curHamDistanceSum = 0;
		}
		
		Iterator DNAIter = DNAMap.keySet().iterator();
		
		while(DNAIter.hasNext()) {
			String currentDNA = (String)DNAIter.next();
//			System.out.println("DNA : " + currentDNA);
//			System.out.println("ham distance sum : " + DNAMap.get(currentDNA));
//			System.out.println("--------------");
			
		}
		
		
	}
}

class DNA {
	
	private String DNAName;
	private int hamDistanceSum;
	
	public DNA() {
		// TODO Auto-generated constructor stub
	}
	
	public DNA(String DNAName, int hamDistanceSum) {
		this.DNAName = DNAName;
		this.hamDistanceSum = hamDistanceSum;
	}

	public String getDNAName() {
		return DNAName;
	}

	public void setDNAName(String dNAName) {
		DNAName = dNAName;
	}

	public int getHamDistanceSum() {
		return hamDistanceSum;
	}

	public void setHamDistanceSum(int hamDistanceSum) {
		this.hamDistanceSum = hamDistanceSum;
	}
	
	
	
}
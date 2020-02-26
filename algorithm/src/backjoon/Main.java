package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int testCases = 1; testCases <= t; testCases++) {

			int n = Integer.parseInt(br.readLine());

			String[] phoneNumbers = new String[n];
			

			for (int phoneI = 0; phoneI < n; phoneI++) {
				phoneNumbers[phoneI] = br.readLine();
			}
			
			
			Arrays.sort(phoneNumbers, new Comparator<String>() {
				
				@Override
				public int compare(String o1, String o2) {
					
					if (o1.length() > o2.length())
						return 1;
					else if(o1.length() == o2.length())
						return 0;
					else
						return -1;
				}
			});

			if (isConsistent(phoneNumbers))
				System.out.println("YES");
			else
				System.out.println("NO");

		}

	}

	public static boolean isConsistent(String[] phoneNumbers) {

		for (int phoneI = 0; phoneI < phoneNumbers.length; phoneI++) {
			String currentPhoneNum = phoneNumbers[phoneI];

			for (int phoneJ = phoneI + 1; phoneJ < phoneNumbers.length; phoneJ++) {
				if (currentPhoneNum.length() == phoneNumbers[phoneJ].length())
					continue;
				if (currentPhoneNum.equals(phoneNumbers[phoneJ].substring(0, currentPhoneNum.length())))
					return false;
			}
		}
		return true;
	}

}
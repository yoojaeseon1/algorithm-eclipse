package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int M = Integer.parseInt(br.readLine());

		boolean[] isDeadButton = new boolean[10];

		int[] livedButtons = new int[10 - M];
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int tokenCount = 1; tokenCount <= M; tokenCount++) {
				isDeadButton[Integer.parseInt(st.nextToken())] = true;
			}
		}

		int livedI = 0;

		for (int isDeadI = 0; isDeadI < isDeadButton.length; isDeadI++) {
			if (!isDeadButton[isDeadI])
				livedButtons[livedI++] = isDeadI;
		}

		// for (livedI = 0; livedI < livedButtons.length; livedI++)
		// System.out.println(livedButtons[livedI]);
		// System.out.println("livedButtons.length : " + livedButtons.length);
		// System.out.println("------");

		channels.add(100);

		int nLength = Integer.toString(N).length();
		int[] selectedIndices = new int[nLength];

		searchChannels(livedButtons, 10 - M, nLength, selectedIndices, 0);

		// for(int channel : channels) {
		// System.out.println(channel);
		// }

		if (livedButtons.length > 0) {
			StringBuilder maxUnderN = new StringBuilder();

			for (int maxUnderLength = 1; maxUnderLength < nLength; maxUnderLength++) {
				maxUnderN.append(livedButtons[livedButtons.length - 1]);
			}
			channels.add(Integer.parseInt(maxUnderN.toString()));

			StringBuilder minOverN = new StringBuilder();

			for (int minUnderLength = 1; minUnderLength <= nLength + 1; minUnderLength++) {
				minOverN.append(livedButtons[0]);
			}

//			System.out.println(minOverN);

			if (minOverN.length() > 0)
				channels.add(Integer.parseInt(minOverN.toString()));
		}

		int minChannelGap = Integer.MAX_VALUE;
		int minGapChannel = Integer.MAX_VALUE;
		for (int channelsI = 0; channelsI < channels.size(); channelsI++) {

			int currentChannel = channels.get(channelsI);
			int channelGap = Math.abs(N - currentChannel);

			if (channelGap < minChannelGap) {
				minChannelGap = channelGap;
				minGapChannel = currentChannel;
			}

		}

		// System.out.println(livedButtons[livedButtons.length-1]);
		// System.out.println(maxUnderN);
		// System.out.println(minOverN);

		// if (Math.abs(N - Integer.parseInt(maxUnderN.toString())) <=
		// minChannelGap) {
		// minChannelGap = Math.abs(N - Integer.parseInt(maxUnderN.toString()));
		// System.out.println(Math.min(Math.abs(100 - minGapChannel),
		// maxUnderN.length() + minChannelGap));
		// } else if (Math.abs(N - Integer.parseInt(minUnderN.toString())) <
		// minChannelGap) {
		// minChannelGap = Math.abs(N - Integer.parseInt(minUnderN.toString()));
		// System.out.println(Math.min(Math.abs(100 - minGapChannel),
		// minUnderN.length() + minChannelGap));
		// } else

//		System.out.println(minChannelGap);
//		System.out.println(minGapChannel);
//		System.out.println(Math.abs(100 - minGapChannel));
//		System.out.println(Integer.toString(minGapChannel).length() + minChannelGap);
		System.out.println(
				Math.min(Math.abs(100 - minGapChannel), Integer.toString(minGapChannel).length() + minChannelGap));

	}

	private static List<Integer> channels = new ArrayList<>();

	public static void searchChannels(int[] source, int n, int r, int[] selectedIndices, int selectedIndex) {

		if (selectedIndex > 1 && source[selectedIndices[0]] == 0)
			return;

		if (r == 0) {
			StringBuilder numberSB = new StringBuilder();

			for (int selectedI = 0; selectedI < selectedIndex; selectedI++) {
				numberSB.append(source[selectedIndices[selectedI]]);
			}
			// System.out.println(numberSB);

			channels.add(Integer.parseInt(numberSB.toString()));
			return;
		}

		for (int sourceI = 0; sourceI < source.length; sourceI++) {

			selectedIndices[selectedIndex] = sourceI;
			searchChannels(source, n, r - 1, selectedIndices, selectedIndex + 1);

		}
	}
}

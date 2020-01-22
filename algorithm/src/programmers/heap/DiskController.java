package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {

	public static void main(String[] args) {

		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };

		Integer[][] jobsCopied = new Integer[jobs.length][jobs[0].length];

		System.out.println(solution(jobs));

	}

	public static int solution(int[][] jobs) {
		Integer[][] jobsCopied = new Integer[jobs.length][jobs[0].length];

		for (int jobsI = 0; jobsI < jobs.length; jobsI++) {
			jobsCopied[jobsI][0] = jobs[jobsI][0];
			jobsCopied[jobsI][1] = jobs[jobsI][1];
		}

		Arrays.sort(jobsCopied, new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if (o1[0] != o2[0])
					return Integer.compare(o1[0], o2[0]);
				else
					return Integer.compare(o1[1], o2[1]);

			}
		});

		int jobsI = 0;
		int computedTime = 0;

		int startTime = jobs[jobsI][0];
		int endTime = jobs[jobsI][0];

		Queue<Integer[]> jobsQueue = new PriorityQueue<>(new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[1], o2[1]);
			}

		});

		while (jobsI < jobsCopied.length && jobsCopied[jobsI][0] == startTime) {
			jobsQueue.add(jobsCopied[jobsI++]);
		}

		while (jobsI < jobsCopied.length) {

			// startTime = jobs[jobsI][0];
			// endTime = startTime + jobs[jobsI][1];
			//
			// computedTime += endTime - startTime;
			// System.out.println("1. computedTime : " + computedTime);
			//
			// // jobsQueue.add(jobs[jobsI]);
			// jobsI++;

			while (!jobsQueue.isEmpty()) {
				Integer[] currentJob = jobsQueue.poll();
				startTime = endTime;
				endTime = startTime + currentJob[1];
				computedTime += endTime - currentJob[0];
				System.out.println("2. computedTime : " + computedTime);
				while (jobsI < jobsCopied.length && jobsCopied[jobsI][0] > startTime
						&& jobsCopied[jobsI][0] <= endTime) {
					System.out.println("added : " + jobsI);
					jobsQueue.add(jobsCopied[jobsI++]);
					System.out.println("added end");
				}
			}

			if (jobsI < jobsCopied.length)
				startTime = jobsCopied[jobsI++][0];

			while (jobsI < jobsCopied.length && jobsCopied[jobsI][0] == startTime) {
				jobsQueue.add(jobsCopied[jobsI++]);
			}

		}

		return computedTime / jobs.length;
	}

}

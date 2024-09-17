package june.programming.interview.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ranking {

	public static void main(String[] args) {
		//int[] inputArray = { 100, 90, 90, 80, 70 };
		//int[] testArray = { 5, 85, 120 };
		try (Scanner sc = new  Scanner(System.in)) {
			int n =sc.nextInt();
			int[] inputArray = new int[n];
			for (int i = 0; i < inputArray.length; i++) {
				inputArray[i]=sc.nextInt();
			}
			
			int m =sc.nextInt();
			int[] testArray = new int[m];
			for (int i = 0; i < testArray.length; i++) {
				testArray[i]=sc.nextInt();
			}
			

			int[] ranks = getRanks(inputArray);
			System.out.println("Ranks of input array: " + Arrays.toString(ranks));

			int[] testRanks = getTestRanks(inputArray, testArray);
			System.out.println("Ranks of test array: " + Arrays.toString(testRanks));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public static int[] getRanks(int[] scores) {
		int[] sortedScores = Arrays.copyOf(scores, scores.length);
		Arrays.sort(sortedScores);

		Map<Integer, Integer> scoreToRank = new HashMap<>();
		int rank = 1;

		for (int i = sortedScores.length - 1; i >= 0; i--) {
			if (!scoreToRank.containsKey(sortedScores[i])) {
				scoreToRank.put(sortedScores[i], rank);
				rank++;
			}
		}

		int[] ranks = new int[scores.length];
		for (int i = 0; i < scores.length; i++) {
			ranks[i] = scoreToRank.get(scores[i]);
		}

		return ranks;
	}

	public static int[] getTestRanks(int[] inputArray, int[] testArray) {
		int[] sortedInput = Arrays.copyOf(inputArray, inputArray.length);
		Arrays.sort(sortedInput);

		Map<Integer, Integer> scoreToRank = new HashMap<>();
		int rank = 1;

		for (int i = sortedInput.length - 1; i >= 0; i--) {
			if (!scoreToRank.containsKey(sortedInput[i])) {
				scoreToRank.put(sortedInput[i], rank);
				rank++;
			}
		}

		int[] testRanks = new int[testArray.length];
		for (int i = 0; i < testArray.length; i++) {
			testRanks[i] = getRank(scoreToRank, sortedInput, testArray[i]);
		}

		return testRanks;
	}

	public static int getRank(Map<Integer, Integer> scoreToRank, int[] sortedScores, int score) {
		for (int i = sortedScores.length - 1; i >= 0; i--) {
			if (score >= sortedScores[i]) {
				return scoreToRank.get(sortedScores[i]);
			}
		}
		return scoreToRank.size() + 1;
	}
}

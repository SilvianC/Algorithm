package D0413.P150367;

import java.util.*;

public class Solution {

	public static int[] solution(long[] numbers) {
		int n = numbers.length;
		int[] answer = new int[n];

		for (int i = 0; i < n; i++) {
			int size = (int) (Math.log(numbers[i]) / Math.log(2));
			boolean[] binaryTree = new boolean[++size];
			
			for (int j = 0; Math.pow(2, j) < numbers[i]; j++) {
				if ((numbers[i] & (1 << j)) != 0)
					binaryTree[j] = true;
			}

			System.out.println(Arrays.toString(binaryTree));;
			
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long[] numbers = new long[1];
		for (int i = 0; i < 1; i++) {
			numbers[i] = sc.nextLong();
		}
		int[] ans = solution(numbers);

		System.out.println(Arrays.toString(ans));
	}

}

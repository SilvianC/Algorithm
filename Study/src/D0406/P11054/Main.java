package D0406.P11054;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] leftLis = new int[N];
		int[] rightLis = new int[N];

		// ?��쪽의 경우
		for (int i = 0; i < N; i++) {
			leftLis[i] = 1;
			for (int j = 0; j <= i - 1; j++) {
				if (arr[i] > arr[j] && leftLis[i] < leftLis[j] + 1)
					leftLis[i] = leftLis[j] + 1;
			}
		}
		// ?��른쪽?�� 경우
		for (int i = N - 1; i >= 0; i--) {
			rightLis[i] = 1;
			for (int j = N - 1; j >= i; j--) {
				if (arr[i] > arr[j] && rightLis[i] < rightLis[j] + 1)
					rightLis[i] = rightLis[j] + 1;
			}
		}
		// ?���? 최�?
		int max = 0;
		// ?���? 최�?
		int leftMax = 0;
		for (int i = 0; i < N; i++) {
			leftMax = Math.max(leftMax, leftLis[i]);
			int rightMax = 0;
			// ?��른쪽 최�?
			for (int j = N - 1; j >= i; j--) {
				rightMax = Math.max(rightMax, rightLis[j]);
				// ?��계�? 최�? ?��것을 구하?��
				max = Math.max(max, leftMax + rightMax - 1);
			}
		}
		System.out.println(max);
	}
}

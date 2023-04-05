package D0404.P12015;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int len = 0;
		for (int i = 1; i < N; i++) {
			boolean flag = false;
			
			// 큰 수 일 경우 마지막에 붙임
			if (len == 0 || arr[i] > dp[len-1]) {
				dp[len++] = arr[i];
				continue;
			}

			// 작은 수일 시 이진 탐색
			int low = 0, mid = 0, high = len-1;
			while (low <= high) {
				mid = (low + high) / 2;

				if (dp[mid] == arr[i]) {
					flag = true;
					break;
				}

				if (dp[mid] < arr[i]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			if (!flag) {
				dp[mid] = arr[i];
			}
			System.out.println(Arrays.toString(dp));
		}
		
	}
}

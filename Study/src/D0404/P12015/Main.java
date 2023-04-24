package D0404.P12015;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int len = 0;
		for (int i = 0; i < N; i++) {
			if (len == 0 || arr[i] > dp[len - 1]) {
				dp[len++] = arr[i];
				continue;
			}

			int low = 0, mid = 0, high = len - 1;
			// ��ġ�ϴ� ���� ã�� ��
			int flag = mid;
			while (low <= high) {
				mid = (low + high) / 2;

				// Ŭ ���
				if (dp[mid] < arr[i]) {
					low = mid + 1;
				}
				// ���� ���
				else if (dp[mid] > arr[i]) {
					high = mid - 1;
					flag = mid;
				}
				// ������ ���
				else {
					flag = mid;
					break;
				}
			}
			dp[flag] = arr[i];
		}
		System.out.println(len);
	}
}
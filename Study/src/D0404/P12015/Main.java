package D0404.P12015;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int idx = 0;
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			// ���� ���� ��  �ٲ��ش�
			if(dp[idx] < arr[i])
				dp[idx] = arr[i];

		}
	}

}


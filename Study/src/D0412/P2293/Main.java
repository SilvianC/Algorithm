package D0412.P2293;

import java.io.*;
import java.util.*;

public class Main {
	static int N, coins[];
	static int[] dp = new int[10002];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		coins = new int[N];

		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		getCnt(K);
		System.out.println(dp[0] - 1);
	}

	private static void getCnt(int num) {
		dp[num] = 1;
		for (int i = num; i > 0; i--) {
			int idx;

			if (dp[i] == 0)
				continue;

			for (int j = 0; j < coins.length; j++) {
				idx = i - coins[j];

				if (idx < 0)
					continue;

				}
			}
		}
	}

}
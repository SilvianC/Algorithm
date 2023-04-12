package D0407.P9465;

import java.io.*;
import java.util.*;

public class Main {
	static int N, sticker[][], dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());

			sticker = new int[2][N];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = getMax();
			System.out.println(ans);
		}

	}

	private static int getMax() {
		dp = new int[2][N];

		for (int j = 0; j < N; j++) {
			dp[0][j] = sticker[0][j];
			dp[1][j] = sticker[1][j];

			if (j > 0) {
				dp[0][j] = Math.max(dp[0][j - 1], dp[1][j - 1] + dp[0][j]);
				dp[1][j] = Math.max(dp[1][j - 1], dp[0][j - 1] + dp[1][j]);
			}
		}

		return Math.max(dp[0][N - 1], dp[1][N - 1]);
	}

}

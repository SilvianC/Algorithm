package D0406.P2169;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = getMax();
		System.out.println(ans);
	}

	private static int getMax() {
		// 0:왼쪽, 1:오른쪽, 2:아래
		int[][][] dp = new int[N][M][3];

		// 첫줄
		for (int j = 0; j < M; j++) {
			dp[0][j][1] = map[0][j];
			if (j > 0) {
				dp[0][j][1] += dp[0][j - 1][1];
			}
			dp[0][j][2] = dp[0][j][1];
		}

		if (N > 2) {
			// 중간 줄
			for (int i = 1; i < N - 1; i++) {
				for (int j = 0; j < M; j++) {
					dp[i][j][1] = map[i][j];
					if (j > 0) {
						dp[i][j][1] += Math.max(dp[i - 1][j][2], dp[i][j - 1][1]);
					} else {
						dp[i][j][1] += dp[i - 1][j][2];
					}
				}

				for (int j = M - 1; j >= 0; j--) {
					dp[i][j][0] = map[i][j];
					if (j < M - 1) {
						dp[i][j][0] += Math.max(dp[i - 1][j][2], dp[i][j + 1][0]);
					} else {
						dp[i][j][0] += dp[i - 1][j][2];
					}
				}

				for (int j = 0; j < M; j++) {
					dp[i][j][2] = Math.max(dp[i][j][0], dp[i][j][1]);
				}
			}
		}

		if (N > 1) {
			// 막줄
			for (int j = 0; j < M; j++) {
				dp[N - 1][j][1] = map[N - 1][j];
				if (j > 0) {
					dp[N - 1][j][1] += Math.max(dp[N - 2][j][2], dp[N - 1][j - 1][1]);
				} else {
					dp[N - 1][j][1] += dp[N - 2][j][2];
				}
			}
		}
		return dp[N - 1][M - 1][1];
	}

}

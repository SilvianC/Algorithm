package D0406.P2407;

import java.math.*;
import java.util.*;

public class Main_dp {
	static BigInteger[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		System.out.println(comb(n, m));
	}

	private static BigInteger comb(int N, int M) {

		dp = new BigInteger[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == j) {
					dp[i][j] = new BigInteger("1");
				} else {
					dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
				}

				if (i == N && j == M) {
					return dp[i][j];
				}
			}
		}
		return null;
	}
}

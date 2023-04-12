package D0406.SWEA5607;

import java.util.*;

public class Solution {
	static final int MOD = 1234567891;
	static long dp[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int R = sc.nextInt();
			dp = new long[N + 1];

			facto(N);
			long ans = comb(N, R);
			System.out.println("#" + tc + " " + ans);
		}

	}

	private static long comb(int n, int r) {
		long ans = ((dp[n] % MOD) * (pow(dp[n - r], MOD - 2) % MOD)) % MOD;
		ans = (ans * (pow(dp[r], MOD - 2) % MOD)) % MOD;

		return ans;
	}

	private static void facto(long num) {
		for (int i = 1; i <= num; i++) {
			if (i == 1) {
				dp[i] = i;
				continue;
			}
			if (dp[i] == 0) {
				dp[i] = (dp[i - 1] * i) % MOD;
			}
		}
	}

	private static long pow(long x, int y) {
		if (y == 0) {
			return 1;
		}

		long num = pow(x, y / 2) % MOD;
		long res = (num * num) % MOD;
		if (y % 2 == 0) {
			return res;
		} else {
			return (res * x) % MOD;
		}
	}

}
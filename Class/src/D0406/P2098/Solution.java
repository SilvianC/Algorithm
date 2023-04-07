package D0406.P2098;

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
			System.out.println(dp[5]);
			long ans = comb(N, R);
			System.out.println("#" + tc + " " + ans);
		}

	}

	private static long comb(int n, int r) {
		long ans = (dp[n] % MOD) * (pow(dp[n - r], MOD - 2) % MOD) * (pow(dp[r], MOD - 2) % MOD);

		return ans % MOD;
	}

	private static void facto(int num) {
		for (int i = 1; i <= num; i++) {
			if (i == 1) {
				dp[i] = 1;
				continue;
			}
			if (dp[i] == 0) {
				dp[i] = (dp[i - 1] * i) % MOD;
			}
		}
	}

	private static long pow(long x, int y) {
		if (y == 1) {
			return x;
		}

		long num = pow(x, y / 2) % MOD;
		if (y % 2 == 0) {
			return (num % MOD) * (num % MOD) % MOD;
		} else {
			return ((num % MOD) * (num % MOD) * (x % MOD)) % MOD;
		}
	}

}

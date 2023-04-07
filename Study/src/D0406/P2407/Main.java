package D0406.P2407;

import java.util.*;

public class Main {
	static int N, M, ans;
	static boolean isSelected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		isSelected = new boolean[N];
		comb(0, 0);

		System.out.println(ans);
	}

	private static void comb(int st, int cnt) {
		if (cnt == M) {
			ans++;
			return;
		}

		for (int i = st; i < N; i++) {
			isSelected[i] = true;
			comb(i + 1, cnt + 1);
			isSelected[i] = false;
		}
	}

}

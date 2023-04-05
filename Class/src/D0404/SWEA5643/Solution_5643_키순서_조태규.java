package D0404.SWEA5643;

import java.io.*;
import java.util.*;

// Floyd Warshall
public class Solution_5643_키순서_조태규 {

	static int N;
	static boolean hiOrder[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			hiOrder = new boolean[N + 1][N + 1];

			StringTokenizer st = null;
			int smallP, tallP;
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				smallP = Integer.parseInt(st.nextToken());
				tallP = Integer.parseInt(st.nextToken());

				hiOrder[smallP][tallP] = true;
			}
			int ans = Floyd();
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static int Floyd() {
		int cnt = 0;
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k)
					continue;
				for (int j = 1; j <= N; j++) {
					if (j == k || j == i)
						continue;
					hiOrder[i][j] = (hiOrder[i][k] && hiOrder[k][j]) || hiOrder[i][j];
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			boolean orderCheck = true;
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				if (hiOrder[i][j] == false) {
					if (hiOrder[j][i] == false) {
						orderCheck = false;
					}
				}
			}
			if (orderCheck == true) {
				cnt++;
			}
		}
		return cnt;
	}
}
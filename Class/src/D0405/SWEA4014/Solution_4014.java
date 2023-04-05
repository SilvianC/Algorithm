package D0405.SWEA4014;

import java.io.*;
import java.util.*;

public class Solution_4014 {
	static int N, X, ans, map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			// ���� ���� �Է�
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			getCnt();

			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void getCnt() {
		// �� �м�
		for (int i = 0; i < N; i++) {
			int height = 0, sameCnt = 0;
			for (int j = 0; j < N; j++) {
				// ���� �ٸ� ���
				if (height != map[i][j]) {

					height = map[i][j];
					// 1�� ���� ����
					if (map[i][j] - height == 1 && sameCnt > X) {
						ans++;
					}
				}
				// ���� ���� ���
				else {
					sameCnt++;
				}
			}
		}
	}
}

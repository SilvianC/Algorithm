package D0405.SWEA4014;

import java.io.*;
import java.util.*;

public class Solution_4014_활주로건설_조태규 {
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

			// 지형 높이 입력
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
		// 행 분석
		for (int i = 0; i < N; i++) {
			int height = 0, sameCnt = 0;
			for (int j = 0; j < N; j++) {
				// 높이 다른 경우
				if (height != map[i][j]) {

					height = map[i][j];
					// 1만 차이 날때
					if (map[i][j] - height == 1 && sameCnt > X) {
						ans++;
					}
				}
				// 높이 같은 경우
				else {
					sameCnt++;
				}
			}
		}
	}
}

package D0405.SWEA5643;

import java.io.*;
import java.util.*;

public class 키순서3_플로이드 {

	static int N, M, cnt, ans;
	static int adj[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			adj = new int[N + 1][N + 1]; // 占쌘신븝옙占쏙옙 큰 占쏙옙占쏙옙 표占쏙옙

			StringTokenizer st = null;
			int smallP, tallP;
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				smallP = Integer.parseInt(st.nextToken());
				tallP = Integer.parseInt(st.nextToken());

				adj[smallP][tallP] = 1; // 占쏙옙占쏙옙 占쌓뤄옙占쏙옙
			}
			// 占쏙옙占쏙옙 占싻삼옙
			for (int k = 1; k <= N; k++) {
				// 占쏙옙占� 占싻삼옙
				for (int i = 1; i <= N; i++) {
					if (i == k || adj[i][k] == 0)
						continue;
					// 占쏙옙占쏙옙 占싻삼옙
					for (int j = 1; j <= N; j++) {
						// 占싱뱄옙 키 占쏙옙占쏙옙占쏙옙 占싯곤옙 占쏙옙占쏙옙占쏙옙 pass
						if (adj[i][j] == 1)
							continue;
						adj[i][j] = adj[i][k] & adj[k][j];
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
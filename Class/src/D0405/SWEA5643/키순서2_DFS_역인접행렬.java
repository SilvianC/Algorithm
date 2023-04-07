package D0405.SWEA5643;

import java.io.*;
import java.util.*;

public class 키순서2_DFS_역인접행렬 {

	static int N, M, cnt, ans;
	static int adj[][], radj[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			adj = new int[N + 1][N + 1]; // 占쌘신븝옙占쏙옙 큰 占쏙옙占쏙옙 표占쏙옙
			radj = new int[N + 1][N + 1];

			StringTokenizer st = null;
			int smallP, tallP;
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				smallP = Integer.parseInt(st.nextToken());
				tallP = Integer.parseInt(st.nextToken());

				radj[tallP][smallP] = adj[smallP][tallP] = 1; // 占쏙옙占쏙옙 占쌓뤄옙占쏙옙
			}

			for (int i = 1; i <= N; i++) {
				cnt = 0;
				dfs(i, adj,new boolean[N + 1]);
				dfs(i, radj,new boolean[N + 1]);
				if (cnt == N - 1)
					ans++;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void dfs(int cur, int[][] adj, boolean[] visited) {
		// adj : 占쌘신븝옙占쏙옙 큰 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙見占� 占쌘신븝옙占쏙옙 큰 占쏙옙占쏙옙 탐占쏙옙
		// radj : 占쌘신븝옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙見占� 占쌘신븝옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 탐占쏙옙
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (adj[cur][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i, adj, visited);
			}
		}
	}
}
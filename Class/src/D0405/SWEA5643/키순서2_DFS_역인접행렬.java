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

			adj = new int[N + 1][N + 1]; // 자신보다 큰 관계 표현
			radj = new int[N + 1][N + 1];

			StringTokenizer st = null;
			int smallP, tallP;
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				smallP = Integer.parseInt(st.nextToken());
				tallP = Integer.parseInt(st.nextToken());

				radj[tallP][smallP] = adj[smallP][tallP] = 1; // 유향 그래프
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
		// adj : 자신보다 큰 관계 인접행렬이면 자신보다 큰 정점 탐색
		// radj : 자신보다 작은 관계 인접행렬이면 자신보다 작은 정점 탐색
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (adj[cur][i] == 1 && !visited[i]) {
				cnt++;
				dfs(i, adj, visited);
			}
		}
	}
}
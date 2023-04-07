package D0405.SWEA5643;

import java.io.*;
import java.util.*;

public class Ű����1_DFS {

	static int N, M, cnt, ans;
	static int adj[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			adj = new int[N + 1][N + 1]; // �ڽź��� ū ���� ǥ��

			StringTokenizer st = null;
			int smallP, tallP;
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				smallP = Integer.parseInt(st.nextToken());
				tallP = Integer.parseInt(st.nextToken());

				adj[smallP][tallP] = 1; // ���� �׷���
			}

			for (int i = 1; i <= N; i++) {
				cnt = 0;
				gtDFS(i, new boolean[N + 1]);
				ltDFS(i, new boolean[N + 1]);
				if (cnt == N - 1)
					ans++;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void gtDFS(int cur, boolean[] visited) {
		// cur ���� �������� �ڽź��� ū ���� Ž��
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (adj[cur][i] == 1 && !visited[i]) {
				cnt++;
				gtDFS(i, visited);
			}
		}
	}

	private static void ltDFS(int cur, boolean[] visited) {
		// cur ���� �������� �ڽź��� ū ���� Ž��
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (adj[i][cur] == 1 && !visited[i]) {
				cnt++;
				ltDFS(i, visited);
			}
		}
	}
}
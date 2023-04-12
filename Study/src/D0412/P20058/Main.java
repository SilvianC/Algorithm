package D0412.P20058;

import java.io.*;
import java.util.*;

public class Main {
	static int N, Q, sum, range, L[];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean visited[][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		N = (int) Math.pow(2, N);
		int[][] A = new int[N][N];
		L = new int[Q];

		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < N; y++)
				A[x][y] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		int[][] ans = fireStorm(A);
		getAns(ans);
	}

	private static void getAns(int[][] map) {
		visited = new boolean[N][N];

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (!visited[x][y] && map[x][y] > 0) {
					visited[x][y] = true;
					sum += map[x][y];
					bfs(map, x, y);
				}
			}
		}
		System.out.println(sum);
		System.out.println(range);
	}

	private static void bfs(int[][] map, int x, int y) {
		Queue<int[]> q = new ArrayDeque<int[]>();

		q.add(new int[] { x, y });
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] dot = q.poll();

			int nx, ny;
			for (int d = 0; d < 4; d++) {
				nx = dot[0] + dx[d];
				ny = dot[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
					continue;
				if (map[nx][ny] == 0)
					continue;

				q.add(new int[] { nx, ny });
				visited[nx][ny] = true;
				sum += map[nx][ny];
				cnt++;
			}
		}
		range = Math.max(range, cnt);
	}

	private static int[][] fireStorm(int[][] map) {
		int[][] tmp1, tmp2;
		for (int i = 0; i < Q; i++) {
			tmp1 = new int[N][N];
			rotate(map, tmp1, L[i]);

			// 회전한 맵
			tmp2 = new int[N][N];
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					tmp2[x][y] = tmp1[x][y];
				}
			}
			crashIce(tmp1, tmp2);
			// 얼음 파괴된 맵
			map = tmp2;
		}
		return map;

	}

	private static void rotate(int[][] map, int[][] temp, int n) {
		int size = (int) Math.pow(2, n);
		for (int x = 0; x < N; x += size) {
			for (int y = 0; y < N; y += size) {

				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						temp[x + i][y + j] = map[x + size - j - 1][y + i];
					}
				}
			}
		}
	}

	private static void crashIce(int[][] map, int[][] temp) {

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (map[x][y] == 0) {
					continue;
				}

				int nx, ny;
				int iceSum = 0;
				for (int d = 0; d < 4; d++) {
					nx = x + dx[d];
					ny = y + dy[d];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					if (map[nx][ny] > 0)
						iceSum++;
				}
				if (iceSum < 3)
					temp[x][y]--;
			}
		}
	}

}

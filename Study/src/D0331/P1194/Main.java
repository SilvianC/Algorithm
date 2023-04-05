package D0331.P1194;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int N, M;
	static boolean[][][] visited;
	static char[][] map;
	static int answer = -1;

	static class moon {
		int r;
		int c;
		int flag;
		int count;

		public moon(int r, int c, int flag, int count) {
			this.r = r;
			this.c = c;
			this.flag = flag;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		visited = new boolean[N][M][1 << 6];

		int startX = 0;
		int startY = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == '0') {
					startX = i;
					startY = j;
				}
			}
		}
		bfs(startX, startY);

		System.out.println(answer);
	}

	static public void bfs(int x, int y) {
		Queue<moon> queue = new LinkedList<>();

		queue.add(new moon(x, y, 0, 0));

		while (!queue.isEmpty()) {
			moon Cur = queue.poll();

			// 도착
			if (map[Cur.r][Cur.c] == '1') {
				answer = Cur.count;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = Cur.r + dr[d];
				int nc = Cur.c + dc[d];
				int flag = Cur.flag;
				int count = Cur.count;

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#' || visited[nr][nc][flag])
					continue;

				// 키
				if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {

					visited[nr][nc][flag | 1 << map[nr][nc] - 'a'] = true;
					queue.add(new moon(nr, nc, flag | 1 << map[nr][nc] - 'a', count + 1));
				}
				// 대문
				else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {

					// 키 보유
					if ((flag & (1 << map[nr][nc] - 'A')) != 0) {

						visited[nr][nc][flag] = true;
						queue.add(new moon(nr, nc, flag, count + 1));
					}
				} else {
					visited[nr][nc][flag] = true;
					queue.add(new moon(nr, nc, flag, count + 1));

				}
			}
		}
	}
}

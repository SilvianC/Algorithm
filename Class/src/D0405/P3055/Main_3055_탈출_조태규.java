package D0405.P3055;

import java.io.*;
import java.util.*;

public class Main_3055_탈출_조태규 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static List<int[]> waterList;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		waterList = new ArrayList<int[]>();
		visited = new boolean[R][C];

		int hedgeX = 0, hedgeY = 0;
		for (int i = 0; i < R; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				switch (s[j]) {
				case 'S':
					hedgeX = i;
					hedgeY = j;
					visited[i][j] = true;
					break;
				case '*':
					waterList.add(new int[] { i, j });
					visited[i][j] = true;
					break;
				}
			}
			map[i] = s;
		}

		int ans = moveHedge(hedgeX, hedgeY);
		System.out.println(ans == 0 ? "KAKTUS" : ans);
	}

	public static int moveHedge(int hedgeX, int hedgeY) {
		Queue<int[]> hedgeQ = new LinkedList<int[]>();

		int cnt = -1;
		hedgeQ.add(new int[] { hedgeX, hedgeY, 0 });
		while (!hedgeQ.isEmpty()) {
			int[] hedge = hedgeQ.poll();

			// 비버의 굴에 도착한 경우
			if (map[hedge[0]][hedge[1]] == 'D') {
				return hedge[2];
			}

			if(cnt < hedge[2]) {
				moveWater();
				cnt = hedge[2];
			}
				
			// 고슴도치 탐색
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = hedge[0] + dx[i];
				ny = hedge[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny])
					continue;
				if (map[nx][ny] == 'X')
					continue;

				visited[nx][ny] = true;
				hedgeQ.add(new int[] { nx, ny, hedge[2] + 1 });
			}
		}
		return 0;
	}

	public static void moveWater() {
		Queue<int[]> waterQ = null;
		// 물이 담긴 큐 선언
		waterQ = new LinkedList<int[]>();
		// 물이 담긴 리스트로 탐색
		for (int i = 0; i < waterList.size(); i++) {
			int[] water = waterList.get(i);
			waterQ.add(water);
		}

		// 물 리스트 초기화
		waterList = new ArrayList<int[]>();
		// 물 사방 퍼지기
		while (!waterQ.isEmpty()) {
			int[] water = waterQ.poll();

			int waterX, waterY;
			for (int i = 0; i < 4; i++) {
				waterX = water[0] + dx[i];
				waterY = water[1] + dy[i];

				if (waterX < 0 || waterY < 0 || waterX >= R || waterY >= C || visited[waterX][waterY])
					continue;
				if (map[waterX][waterY] == 'X' || map[waterX][waterY] == 'D')
					continue;

				visited[waterX][waterY] = true;
				// water 좌표 선언
				waterList.add(new int[] { waterX, waterY });
			}
		}
	}
}

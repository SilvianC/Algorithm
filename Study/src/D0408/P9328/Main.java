package D0408.P9328;

import java.io.*;
import java.util.*;

public class Main {
	static char map[][], key[];
	static boolean visited[][];
	static int H, W, keyIdx, ans;
	static int[] dh = { -1, 0, 1, 0 };
	static int[] dw = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			keyIdx = 0;
			ans = 0;

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H + 2][W + 2];
			visited = new boolean[H + 2][W + 2];

			for (int h = 0; h < H + 2; h++) {
				for (int w = 0; w < W + 2; w++) {
					map[h][w] = '.';
				}
			}

			for (int h = 0; h < H; h++) {
				map[h] = br.readLine().toCharArray();
			}

			key = br.readLine().toCharArray();
			for (int i = 0; i < key.length; i++) {
				if (key[i] != '0') {
					keyIdx = keyIdx | 1 << key[i];
				}
			}
			System.out.println(keyIdx);
			// 위 아래쪽
			for (int w = 0; w < W; w++) {
				dfs(0, w);
				dfs(H - 1, w);
			}
			// 처음 맨끝쪽
			for (int h = 1; h < H - 1; h++) {
				dfs(h, 0);
				dfs(h, W - 1);
			}
			System.out.println(keyIdx);
			System.out.println(ans);
		}
	}

	private static void dfs(int h, int w) {

		// 도착 한 경우
		if (map[h][w] == '$') {
			ans++;
			map[h][w] = '.';
		}
		// 열쇠 인 경우
		if (map[h][w] >= 'a' && map[h][w] <= 'z') {
			visited[h][w] = true;
		}

		int nh, nw;
		for (int d = 0; d < 4; d++) {
			nh = h + dh[d];
			nw = w + dw[d];

			if (nh < 0 || nw < 0 || nh >= H || nw >= W || visited[nh][nw])
				continue;
			if(map[nh][nw] == '*')
				continue;
			
			// 열쇠 없는 경우
			if (map[h][w] >= 'A' && map[h][w] <= 'Z') {
				if ((keyIdx & (map[h][w] - 'A')) == 0)
					continue;
			}

			visited[nh][nw] = true;
			dfs(nh, nw);
			visited[nh][nw] = false;

		}

	}
}

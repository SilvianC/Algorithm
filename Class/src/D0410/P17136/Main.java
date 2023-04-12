package D0410.P17136;

import java.io.*;
import java.util.*;

public class Main {
	static final int MAX_LEN = 10;
	static int ans, maxPaper[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int board[][] = new int[MAX_LEN][MAX_LEN];
		for (int i = 0; i < MAX_LEN; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < MAX_LEN; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		maxPaper = new int[] { 0, 5, 5, 5, 5, 5 };
		ans = Integer.MAX_VALUE;

		dfs(0, board);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	private static void dfs(int cnt, int[][] board) {

		// 가지치기
		if (cnt >= ans) {
			return;
		}
		// 완료 도달
		if (isFinished(board)) {
			ans = Math.min(ans, cnt);
			return;
		}

		for (int i = 0; i < MAX_LEN; i++) {
			for (int j = 0; j < MAX_LEN; j++) {
				// 1을 발견
				if (board[i][j] == 1) {
					for (int len = 5; len >= 1; len--) {
						if (maxPaper[len] > 0) {
							if (isAvailable(i, j, len, board)) {
								maxPaper[len]--;
								coverPaper(i, j, len, board);
								dfs(cnt + 1, board);
								removePaper(i, j, len, board);
								maxPaper[len]++;
							}
						}
					}
					return;
				}
			}
		}

	}

	private static void removePaper(int i, int j, int len, int[][] board) {
		for (int x = i; x < i + len; x++) {
			for (int y = j; y < j + len; y++) {
				board[x][y] = 1;
			}
		}
	}

	private static void coverPaper(int i, int j, int len, int[][] board) {
		for (int x = i; x < i + len; x++) {
			for (int y = j; y < j + len; y++) {
				board[x][y] = 0;
			}
		}		
	}

	private static boolean isFinished(int[][] board) {
		for (int i = 0; i < MAX_LEN; i++) {
			for (int j = 0; j < MAX_LEN; j++) {
				if (board[i][j] == 1)
					return false;
			}
		}
		return true;
	}

	private static boolean isAvailable(int x, int y, int len, int[][] board) {
		for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				if (i < 0 || i >= 10 || j < 0 || j >= 10) {
					return false;
				}
				if (board[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}

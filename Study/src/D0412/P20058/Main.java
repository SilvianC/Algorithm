package D0412.P20058;

import java.io.*;
import java.util.*;

public class Main {
	static int N, Q, len, L[], A[][];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		len = (int) Math.pow(2, N);
		A = new int[len][len];
		L = new int[Q];

		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			L[i] = Integer.parseInt(st.nextToken());
		}

		fireStorm();

	}

	private static void fireStorm() {
		for (int i = 0; i < Q; i++) {
			rotate(L[i]);
			crashIce();
		}
	}

	private static int[][] rotate(int n) {
		int size = (int) Math.pow(2, n);
		int[][] temp = new int[len][len];

		// 구간 나누기
		for (int i = 0; i < N; i += size) {
			for (int j = 0; j < N; j += size) {
				// 90도 회전
				while (size > 1) {
					// 배열 돌리기

					for (int x = i; x < i + size; x++) {
						for (int y = i; y < j + size; y++) {
							temp[x][y] = A[][]
						}
					}

				}

			}
		}

		return temp;
	}

	private static void crashIce() {

	}

}

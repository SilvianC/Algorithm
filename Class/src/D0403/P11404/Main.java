package D0403.P11404;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D[][];
	final static int INF = 1000000002;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		D = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				if (D[i][j] == 0)
					D[i][j] = INF;
			}
		}
		
		int a, b, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if(D[a][b] > c)
				D[a][b] = c;
		}
		solve();
		print();
	}

	private static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(D[i][j] >= INF)
					D[i][j] = 0;
				System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void solve() {

		// 경유지
		for (int k = 1; k <= N; k++) {
			// 출발지
			for (int i = 1; i <= N; i++) {
				// 도착지
				for (int j = 1; j <= N; j++) {
					D[i][j] = Math.min(D[i][k] + D[k][j], D[i][j]);
				}
			}
		}

	}

}

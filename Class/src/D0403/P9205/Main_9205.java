package D0403.P9205;

import java.util.*;

public class Main_9205 {
	static int pos[][], D[][];
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;

		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			pos = new int[N + 2][2];
			D = new int[N + 2][N + 2];

			for (int i = 0; i < N + 2; i++) {
				pos[i][0] = sc.nextInt();
				pos[i][1] = sc.nextInt();
			}

			for (int i = 0; i < N + 2; i++) {
				for (int j = i + 1; j < N + 2; j++) {
					int dis = Math.abs(pos[i][0] - pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]);
					D[j][i] = D[i][j] = dis>1000?INF:dis;
				}
			}
			// ������
			for (int k = 0; k < N+2; k++) {
				// �����
				for (int i = 0; i < N + 2; i++) {
					if (i == k)
						continue;
					// ������
					for (int j = 0; j < N + 2; j++) {
						if (D[i][k] == INF || D[k][j] == INF || j == k || j == i)
							continue;
						D[i][j] = Math.min(D[i][k] + D[k][j], D[i][j]);
					}
				}
			}

			System.out.println(D[0][N+1] == INF?"sad":"happy");
		}
	}
}

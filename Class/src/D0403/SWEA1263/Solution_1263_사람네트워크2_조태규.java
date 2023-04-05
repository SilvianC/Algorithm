package D0403.SWEA1263;

import java.io.*;
import java.util.*;

public class Solution_1263_사람네트워크2_조태규 {
	static int N, D[][];
	final static int INF = 10000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());

			D = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					D[i][j] = num==0&&i!=j?INF:num;
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if(i == k)
						continue;
					for (int j = 0; j < N; j++) {
						if(j == k || j == i)
							continue;
						D[i][j] = Math.min(D[i][k] + D[k][j], D[i][j]);
					}
				}
			}
			int ans = INF;
			for(int i = 0;i<N;i++) {
				int sum = 0;
				for(int j = 0;j<N;j++) {
					sum += D[i][j];
				}
				ans = Math.min(ans, sum);
			}
			System.out.println("#" + test_case + " " + ans);
		}	
	}
}

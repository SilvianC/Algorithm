package D0407.P2042;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long arr[], tree[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new long[N + 1];
		tree = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			long num = Long.parseLong(br.readLine());
			arr[i] = num;
			update(i, num);
		}

		int a, b;
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if (a == 1) {
				long c = Long.parseLong(st.nextToken());
				update(b, c - arr[b]);
				arr[b] = c;
				continue;
			}

			if (a == 2) {
				int c = Integer.parseInt(st.nextToken());
				long result = sum(c) - sum(b - 1);
				bw.append(result + "\n");
			}

		}
		bw.flush();
		bw.close();
	}

	// 구간 합 구하기
	private static long sum(int idx) {
		long sum = 0;
		while (0 < idx) {
			sum += tree[idx];
			idx -= (idx & -idx);
		}
		return sum;

	}

	// 2의 제곱수의 tree 인덱스 값 생성
	private static void update(int i, long num) {
		while (i <= N) {
			tree[i] += num;
			i += (i & -i);
		}
	}

}

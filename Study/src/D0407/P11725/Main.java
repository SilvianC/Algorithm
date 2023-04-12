package D0407.P11725;

import java.io.*;
import java.util.*;

public class Main {
	static int N, parent[];
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		list = new ArrayList[N + 1];
		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}
		parent[1] = 1;
		dfs(1, 0);
		
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}

	}

	private static void dfs(int x, int cnt) {
		int size = list[x].size();
		for (int i = 0; i < size; i++) {
			int num = list[x].get(i);
			if (parent[num] == 0) {
				parent[num] = x;
				dfs(num, cnt + 1);
			}
		}
	}

}

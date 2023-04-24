package D0418.P1504;

import java.io.*;
import java.util.*;

public class Main {

	static int N, E;
	static ArrayList<Edge> edgeList;
	static int distance[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		edgeList = new ArrayList<Edge>();

		int from, to, weight;
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(from, to, weight));
			edgeList.add(new Edge(to, from, weight));
		}

		st = new StringTokenizer(br.readLine());
		int node1 = Integer.parseInt(st.nextToken());
		int node2 = Integer.parseInt(st.nextToken());

		// 첫번재 경로
		dijkstra(1, node1);
		dijkstra(node1, node2);
		dijkstra(node2, N);

		// 두번째 경로
		dijkstra(1, node2);
		dijkstra(node2, node1);
		dijkstra(node1, N);

	}

	private static void dijkstra(int start, int end) {

		distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[start] = 0;

		// vertex 크기만큼 반복
		for (int i = 1; i <= N; i++) {

			int min = Integer.MAX_VALUE;
			int cur = -1;
			for (int j = 1; j <= N; j++) {
				if (min > distance[j]) {
					min = distance[j];
					cur = j;
				}
			}

			if (cur == -1)
				break;

			for (int j = 1; j <= N; j++) {
				
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int from;
	int to;
	int weight;

	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

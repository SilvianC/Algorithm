package D0331.P19238;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, fuel, map[][], start[][], dest[][];
	static boolean visited[][], notReach;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = -1;
				}
			}
		}
		st = new StringTokenizer(br.readLine());

		// 택시 출발지
		int[] taxi = new int[2];
		taxi[0] = Integer.parseInt(st.nextToken());
		taxi[1] = Integer.parseInt(st.nextToken());

		start = new int[M + 1][2];
		dest = new int[M + 1][2];

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());

			// 사람 시작점
			start[m][0] = Integer.parseInt(st.nextToken());
			start[m][1] = Integer.parseInt(st.nextToken());
			map[start[m][0]][start[m][1]] = m;

			// 사람 도착점
			dest[m][0] = Integer.parseInt(st.nextToken());
			dest[m][1] = Integer.parseInt(st.nextToken());
		}

		while (M-- > 0) {
			int pass_num = getPassenger(taxi[0], taxi[1]);

			// 도달 불가능한 상태
			if (notReach || pass_num == 0) {
				System.out.println(-1);
				return;
			}
			
			// 도착점 출발
			reachArrival(pass_num);

			if (notReach) {
				System.out.println(-1);
				return;
			}

			// 택시 위치 재정비
			taxi[0] = dest[pass_num][0];
			taxi[1] = dest[pass_num][1];

		}

		System.out.println(fuel);
	}

	static int getPassenger(int taxi_x, int taxi_y) {
		visited = new boolean[N + 1][N + 1];

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(taxi_x, taxi_y, 0));
		visited[taxi_x][taxi_y] = true;

		int nx, ny;
		while (!pq.isEmpty()) {
			Node node = pq.poll();

			// 승객인 경우
			if (map[node.x][node.y] > 0) {
				fuel -= node.dis;
				// 연료 부족
				if (fuel < 0) {
					notReach = true;
				}

				int pass_num = map[node.x][node.y];
				map[node.x][node.y] = 0;
				return pass_num;
			}

			for (int i = 0; i < 4; i++) {
				nx = node.x + dx[i];
				ny = node.y + dy[i];

				if (nx < 1 || ny < 1 || nx > N || ny > N || visited[nx][ny])
					continue;
				if (map[nx][ny] == -1)
					continue;

				visited[nx][ny] = true;
				pq.add(new Node(nx, ny, node.dis + 1));
			}
		}

		return 0;
	}

	static void reachArrival(int pass) {
		visited = new boolean[N + 1][N + 1];

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start[pass][0], start[pass][1], 0));
		visited[start[pass][0]][start[pass][1]] = true;

		int nx, ny;
		while (!pq.isEmpty()) {
			Node node = pq.poll();

			// 목적지 도착한 경우
			if (node.x == dest[pass][0] && node.y == dest[pass][1]) {
				fuel -= node.dis;
				// 연료 부족
				if (fuel < 0) {
					notReach = true;
				}

				// 연료 2배 더해줌
				fuel += node.dis * 2;
				return;
			}

			for (int i = 0; i < 4; i++) {
				nx = node.x + dx[i];
				ny = node.y + dy[i];

				if (nx < 1 || ny < 1 || nx > N || ny > N || visited[nx][ny])
					continue;
				if (map[nx][ny] == -1)
					continue;

				visited[nx][ny] = true;
				pq.add(new Node(nx, ny, node.dis + 1));
			}
		}

		// 도달 불가능
		notReach = true;
	}
}

class Node implements Comparable<Node> {
	int x, y, dis;

	@Override
	public int compareTo(Node o) {
		// 거리가 같을 경우
		if (this.dis == o.dis) {
			// 행도 동일한 경우
			if (this.x == o.x)
				return this.y - o.y;
			else
				return this.x - o.x;
		} else
			return this.dis - o.dis;
	}

	Node(int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}
package D0407.P16953;

import java.util.*;

public class Main {
	static int a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();

		long ans = bfs();
		System.out.println(ans);
	}

	private static long bfs() {

		Queue<Number> q = new ArrayDeque<>();
		q.add(new Number(a, 0));
		while (!q.isEmpty()) {
			Number x = q.poll();

			if (x.num == b) {
				return x.cnt + 1;
			}

			long num = x.num * 10 + 1;
			if (num <= b) {
				q.add(new Number(num, x.cnt + 1));
			}

			num = x.num * 2;
			if (num <= b) {
				q.add(new Number(num, x.cnt + 1));
			}
		}
		return -1;
	}
}

class Number {
	long num;
	int cnt;

	Number(long num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}

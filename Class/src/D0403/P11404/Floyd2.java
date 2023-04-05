package D0403.P11404;

import java.util.Scanner;

/**
 * @author taeheekim
 */
// ���� ����ġ ����
public class Floyd2 {

	static final int INF = 9999999;
	static int N, distance[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		distance = new int[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				distance[i][j] = sc.nextInt();
				if (i != j && distance[i][j] == 0) {// �ڱ��ڽ������� ���� ������ �ƴϰ� ���������� �ʴٸ� INF�� ä���
					distance[i][j] = INF;
				}
			}
		}
		System.out.println("===========�Է�==========");
		print();
		// �����-->������-->�������� 3�� ���� ������ ����
		// ������-->�����-->�������� 3�� ���� ������ ����
		for (int k = 0; k < N; ++k) {
			for (int i = 0; i < N; ++i) {
				if (i == k)
					continue; // ������� �������� ���ٸ� ���� �����
				for (int j = 0; j < N; ++j) {
					if (i == j || k == j)
						continue; // �������� �������� ���ų� ������� �� ��������� �н�
					if (distance[i][k] != INF && distance[k][j] != INF
							&& distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
			print();
		}
	}

	private static void print() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				System.out.print(distance[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("=====================================");

	}

}

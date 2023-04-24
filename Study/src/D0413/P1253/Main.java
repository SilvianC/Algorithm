package D0413.P1253;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		// 정렬
		Arrays.sort(arr);

		boolean[] indexs = new boolean[N];

		for (int i = 0; i < N; i++) {
			int a = arr[i];
			for (int j = N - 1; j >= 0; j--) {
				if (i == j) {
					continue;
				}

				int b = arr[j];

				int idx = Arrays.binarySearch(arr, b - a);
				if (idx >= 0) {
					if (idx != i && idx != j) {
						indexs[j] = true;
					}
					// 하나 중에 같은 경우
					else {
						for (int k = 0; k < N; k++) {
							if(k == i || k == j)
								continue;
							if(arr[k] == 0 && arr[idx] == 0)
								indexs[idx] = true;
						}
					}
				}
			}
		}
		int ans = 0;
		for (int j = 0; j < N; j++) {
			if (indexs[j])
				ans++;
		}
		System.out.println(ans);
	}

}

package D0404.P1786;

import java.io.*;

public class Main_1786_찾기_조태규 {
	static StringBuilder sb;
	static int pi[], cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		sb = new StringBuilder();

		getNum(P);
		getEqual(T, P);
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

	private static void getEqual(char[] t, char[] p) {
		int N = t.length;
		
		int j = 0;
		for (int i = 0; i < N; i++) {

			// 0이 되거나 일치할때까지 반복
			while (j != 0 && t[i] != p[j]) {
				if (j != 0)
					j = pi[j - 1];
			}
			if (t[i] == p[j]) {
				j++;
			}

			// T와 P가 부분 일치 하는 경우
			if (j == p.length) {
				j = pi[j - 1];
				cnt++;
				sb.append(i - p.length + 2).append(" ");
			}
		}
	}

	private static void getNum(char[] s) {
		int N = s.length;
		// 접두, 접미 동일한 수의 배열
		pi = new int[N];
		pi[0] = 0;

		int j = 0;
		for (int i = 1; i < N; i++) {

			// 0이 되거나 일치할때까지 반복
			while (j != 0 && s[i] != s[j]) {
				if (j != 0)
					j = pi[j - 1];
			}
			if (s[i] == s[j]) {
				j++;
			}
			pi[i] = j;
		}
	}

}

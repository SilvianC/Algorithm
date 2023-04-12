package D0410.P16919;

import java.io.*;
import java.util.*;

public class Main {
	static int R, C, N;
	static char map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		if(N % 2 == 0) {
			for (int r = 0; r < R; r++) {
				for(int c = 0;c<C;c++) {
					System.out.print('O');
				}
				System.out.println();
			}
			return;
		}

		map = new char[R][C];
		
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}

		
	}

}

package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SE1954 {
	static int T;
	static int N;
	static int snail[][];
	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };
	static int number = 1;
	static int direction;
	static int cnt;
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			k = N;
			snail = new int[N][N];
			int ny = 0;
			int nx = 0;
			number = 1;
			direction = 0;

			while (true) {
				snail[ny][nx] = number++;

				if (number == (N * N + 1))
					break;

				cnt++;
				if (cnt == k) {
					direction = (direction + 1) % 4;
					cnt = 0;

					if (direction == 1 || direction == 3)
						k--;
				}
				ny = ny + dy[direction];
				nx = nx + dx[direction];
			}
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}

		}
	}
}

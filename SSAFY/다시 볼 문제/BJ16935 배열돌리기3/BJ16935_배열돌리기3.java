package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16935_배열돌리기3 {
	static int N, M, R;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int op = Integer.parseInt(st.nextToken());
			switch (op) {
			case 1:
				case1();
				break;
			case 2:
				case2();
				break;
			case 3:
				case3();
				break;
			case 4:
				case4();
				break;
			case 5:
				case5();
				break;
			case 6:
				case6();
				break;
			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void case1() {
		int[][] tmp = new int[N][M];
		int ry = 0, rx = 0;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				tmp[ry][rx] = map[i][j];
				rx++;
			}
			ry++;
			rx = 0;
		}
		map = tmp;

	}

	static void case2() {
		int[][] tmp = new int[N][M];
		int ry = 0, rx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = M - 1; j >= 0; j--) {
				tmp[ry][rx] = map[i][j];
				rx++;
			}
			ry++;
			rx = 0;
		}
		map = tmp;
	}

	static void case3() {
		int[][] tmp = new int[M][N];
		int ry = 0, rx = 0;

		for (int i = 0; i < M; i++) {
			for (int j = N - 1; j >= 0; j--) {
				tmp[ry][rx] = map[j][i];
				rx++;
			}
			ry++;
			rx = 0;

		}
		map = tmp;

	}

	static void case4() {
		int[][] tmp = new int[M][N];
		int ry = 0, rx = 0;

		for (int i = M - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				tmp[ry][rx] = map[j][i];
				rx++;
			}
			ry++;
			rx = 0;
		}
		map = tmp;
	}

	static void case5() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmp[i][M / 2 + j] = map[i][j];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				tmp[N / 2 + i][j] = map[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			int col = 0;
			for (int j = M / 2; j < M; j++) {
				tmp[i][col] = map[i][j];
				col++;
			}
		}
		int row = 0;
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmp[row][j] = map[i][j];
			}
			row++;
		}
		map = tmp;
	}

	static void case6() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmp[N / 2 + i][j] = map[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmp[i][M / 2 + j] = map[i][j];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			int col = 0;
			for (int j = M / 2; j < M; j++) {
				tmp[i][col] = map[i][j];
				col++;
			}
		}
		int row = 0;
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				tmp[row][j] = map[i][j];
			}
			row++;
		}
		map = tmp;
	}
}

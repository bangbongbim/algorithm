package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕 {
	static int R, C, T;
	static int[][] map;
	static int allDustAmount;

	// 먼지
	static int[] dustY = { -1, 1, 0, 0 };
	static int[] dustX = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// R,C,T입력
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		visited = new boolean[R][C];

		// 방의 정보 입력
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dustSpread();
		for (int i = 0; i < R; i++)
			System.out.println(Arrays.toString(map[i]));

	}

	static void startAirCleaner() {
		boolean cheackUpDowm = false;

		for (int i = 0; i < R; i++) {
			if (map[i][0] == -1 && !cheackUpDowm) {
				windUp(i, 0);
				cheackUpDowm = true;
			} else
				windDown(i, 0);
		}
	}

	static void windUp(int y, int x) {
		int[][] copyMap = new int[R][C];

		for (int i = 1; i < C; i++) {
			if (i == C - 1) {
				copyMap[y - 1][i] = map[y][i];
			}
		}

	}

	static void windDown(int y, int x) {

	}

	static void dustSpread() {
		int[][] dustMap;
		int spread_cnt = 0;
		dustMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0 || map[i][j] == -1)
					continue;

				for (int d = 0; d < 4; d++) {
					int ny = i + dustY[d];
					int nx = j + dustX[d];

					if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == -1)
						continue;

					dustMap[ny][nx] += map[i][j] / 5;
					spread_cnt++;
				}

				map[i][j] = map[i][j] - (map[i][j] / 5 * spread_cnt);
				spread_cnt = 0;

			}

		}

		// 원본과 먼지 배열 합침

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1)
					continue;

				map[i][j] += dustMap[i][j];
			}
		}

	}

	static void getAlldustAmount() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0 && map[i][j] != -1)
					allDustAmount += map[i][j];
			}
		}
	}

}

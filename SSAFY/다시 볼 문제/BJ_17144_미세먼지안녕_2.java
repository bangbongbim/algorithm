package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕_2 {
	static int R, C, T, ans;
	static int[][] map, tempMap;
	static int[][] cPos = new int[2][2]; // cPos[1][0]: 아래쪽 y

	// 상하좌우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		tempMap = new int[R][C];

		int cIdx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				tempMap[i][j] = map[i][j];

				if (map[i][j] == -1) {
					cPos[cIdx][0] = i;
					cPos[cIdx++][1] = j;
				}
			}
		}

		// 시뮬레이션
		for (int i = 0; i < T; i++) {
			spread();
			clear();
		}

		// 출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] <= 0)
					continue;
				ans += map[i][j];
			}
		}

		System.out.println(ans);

	} // end main

	private static void spread() {
		// tempMap 초기화
		for (int i = 0; i < R; i++)
			Arrays.fill(tempMap[i], 0);

		// 확산 map -> tempMap
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tempMap[i][j] += map[i][j];

				if (map[i][j] < 5)
					continue;

				int spreadCnt = map[i][j] / 5;

				// 4방향 확산
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];

					if (ny < 0 || ny >= R || nx < 0 || nx >= C)
						continue;
					if (map[ny][nx] == -1)
						continue;

					tempMap[i][j] -= spreadCnt;
					tempMap[ny][nx] += spreadCnt;
				}
			}
		}

		// tempMap -> map 복사
		for (int i = 0; i < R; i++)
			map[i] = tempMap[i].clone();

	} // end spread

	private static void clear() {
		// tempMap 초기화
		for (int i = 0; i < R; i++)
			Arrays.fill(tempMap[i], 0);

		// 2개의 공기청정기로 정화
		for (int idx = 0; idx < 2; idx++) {
			int ny = cPos[idx][0];
			int nx = cPos[idx][1] + 1;

			// 공기청정기 ==> 오른쪽 끝으로 이동
			while (nx < C - 1) {
				tempMap[ny][nx + 1] = map[ny][nx];
				nx++;
			}

			// 오른쪽 끝 ==> 위, 아래
			if (idx == 0) {
				while (ny > 0) {
					tempMap[ny - 1][nx] = map[ny][nx];
					ny--;
				}
			} else {
				while (ny < R - 1) {
					tempMap[ny + 1][nx] = map[ny][nx];
					ny++;
				}
			}

			// 오른쪽 끝 ==> 왼쪽 끝
			while (nx > 0) {
				tempMap[ny][nx - 1] = map[ny][nx];
				nx--;
			}

			// 왼쪽 끝 ==> 공기청정기 쪽으로
			if (idx == 0) {
				while (ny < cPos[idx][0] - 1) {
					tempMap[ny + 1][nx] = map[ny][nx];
					ny++;
				}
			} else {
				while (ny > cPos[idx][0] + 1) {
					tempMap[ny - 1][nx] = map[ny][nx];
					ny--;
				}
			}

		}

		// tempMap -> map 복사
		// 전부다 덮어쓰면 안된다.
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (i == 0 || i == R - 1 || j == 0 || j == C - 1 || i == cPos[0][0] || i == cPos[1][0])
					map[i][j] = tempMap[i][j];
			}
		}

	} // end clear

}

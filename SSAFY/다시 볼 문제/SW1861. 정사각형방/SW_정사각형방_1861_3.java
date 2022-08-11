package algorithm_basic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BFS
//BFS
public class SW_정사각형방_1861_3 {

	static int T, N, NO, COUNT = 1;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			NO = 0;
			COUNT = 1; // 출발하는 방 번호도 COUNT에 추가

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// dfs
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, map[i][j], 1);
				}
			}

			System.out.println("#" + t + " " + NO + " " + COUNT);
		} // end tc

	} // end main

	// delta
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	private static void dfs(int y, int x, int no, int cnt) {
		// 문제의 답 체크
		if (cnt > COUNT) {
			COUNT = cnt; // 최대 방문수 갱신
			NO = no;
		} else if (cnt == COUNT)
			NO = no < NO ? no : NO;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] != map[y][x] + 1)
				continue;

			dfs(ny, nx, no, cnt + 1);
			break; // 조건에 맞는 다음 번호는 한 개 이므로, 더이상 델타를 따져볼필요가 없다.
		}
	}

}
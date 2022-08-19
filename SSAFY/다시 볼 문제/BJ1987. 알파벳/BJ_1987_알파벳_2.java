package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987_알파벳_2 {

	static int R, C, max;
	static char[][] map;
	static boolean[] visit = new boolean[26]; // 알파벳 길이

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		max = Integer.MIN_VALUE;

		dfs(0, 0, 1);
		System.out.println(max);
	}

	static void dfs(int y, int x, int cnt) {
		max = Math.max(max, cnt);
		visit[map[y][x] - 'A'] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= R || nx >= C || visit[map[ny][nx] - 'A']) {
				continue;
			}

			dfs(ny, nx, cnt + 1);
		}

		visit[map[y][x] - 'A'] = false;
	}
}

package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987_알파벳_3 {

	static int R, C, max;
	static int[][] map;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j] - 'A';
			}
		}

		max = Integer.MIN_VALUE;

		// map[0][0] --> integer 값이 있을 건데 그 값을 1을 << 연산을 수행
		dfs(0, 0, 1, 1 << map[0][0]);
		System.out.println(max);
	}

	static void dfs(int y, int x, int cnt, int visit) {
		max = Math.max(max, cnt);

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= R || nx >= C || (visit & 1 << map[ny][nx]) != 0) {
				continue;
			}

			dfs(ny, nx, cnt + 1, visit | 1 << map[ny][nx]);
		}

	}
}

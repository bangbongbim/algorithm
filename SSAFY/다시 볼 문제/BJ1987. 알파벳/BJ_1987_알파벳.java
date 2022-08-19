package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1987_알파벳 {
	static int R, C;
	static char[][] map;
	static int answer = 1;
	static int[] visit;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static Queue<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		visit = new int[27];

		map = new char[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			String str = br.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}

		visit[map[1][1] - 64] = 1;
		dfs(1, 1, 1);
		System.out.println(answer);
	}

	static void dfs(int y, int x, int cnt) {

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 1 || nx < 1 || ny > R || nx > C) {
				answer = Math.max(answer, cnt);
				continue;
			}
			char alpha = map[ny][nx];
			if (visit[alpha - 64] != 0) {
				answer = Math.max(answer, cnt);
				continue;
			}

			visit[alpha - 64] = cnt;
			dfs(ny, nx, cnt + 1);

		}

	}

}

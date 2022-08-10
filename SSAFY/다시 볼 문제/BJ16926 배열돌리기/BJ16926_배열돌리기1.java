package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16926_배열돌리기1 {
	static int N, M, R;
	static int arr[][];
	static int rotate[][];
	static boolean[][] visited;

	// 방향 : 하 우 상 좌 대각선 밑으로
	static int dy[] = { 1, 0, -1, 0 };
	static int dx[] = { 0, 1, 0, -1 };
	static int sy = 0, sx = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < 1; r++) {
			visited = new boolean[N + 1][M + 1];
			rotate = new int[N + 1][M + 1];

			dfs(1, 1, 0);

		}
	}

	static void dfs(int y, int x, int direction) {
		if (sy == 0 && sx == 0) {
			sy = y;
			sx = x;
		} else {
			if (sy == y && sx == x)
				return;
		}

		for (int d = direction; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 1 || nx < 1 || ny > N || nx > M || visited[ny][nx]) {
				continue;
			}

			rotate[ny][nx] = arr[y][x];
			visited[ny][nx] = true;
			dfs(ny, nx, d);
		}

	}

}

package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576_토마토 {
	static int M, N;
	static int map[][];

	static boolean visited[][];
	static int sY, sX;
	static Queue<int[]> q = new ArrayDeque<>();
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int state = Integer.parseInt(st.nextToken());
				if (state == 1) { /* 출발지 지정 */
					q.offer(new int[] { i, j });
				}
				map[i][j] = state;
			}
		}

		if (check())
			System.out.println(0);
		else {
			bfs();

			if (check())
				System.out.println(answer - 1);
			else
				System.out.println(-1);
		}

	}

	/**
	 * 저장될 때부터 토마토가 모두 익어있다면 0 토마토가 익지 못했다면 -1
	 * 
	 */

	static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	static void bfs() {
		while (!q.isEmpty()) {
			int q_size = q.size();
			for (int i = 0; i < q_size; i++) {
				int[] top = new int[2];
				top = q.poll();
				visited[top[0]][top[1]] = true;
				for (int d = 0; d < 4; d++) {
					int ny = top[0] + dy[d];
					int nx = top[1] + dx[d];

					if (nx < 0 || ny < 0 || ny >= N || nx >= M || map[ny][nx] == -1 || visited[ny][nx]
							|| map[ny][nx] == 1)
						continue;

					q.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
					map[ny][nx] = map[top[0]][top[1]] + 1;
					answer = Math.max(answer, map[ny][nx]);

				}
			}

		}

	}

}

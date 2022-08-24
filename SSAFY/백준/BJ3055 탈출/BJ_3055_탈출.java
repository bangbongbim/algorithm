package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3055_탈출 {
	static int R, C;
	static char[][] map;
	static int answer = 0;
	static int cnt;
	static boolean[][] visited;
	static boolean flag;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int[] start;
	static Queue<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R + 1][C + 1];
		start = new int[2];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}

		}

		setInitWater();
		setInitDochi();

		bfs();
		if (flag)

			System.out.println(answer + 1);
		else
			System.out.println("KAKTUS");
	}

	static void bfs() {

		while (!q.isEmpty()) {
			int q_size = q.size();
			for (int size = 0; size < q_size; size++) {
				int[] top = q.poll();

				for (int d = 0; d < 4; d++) {
					int ny = top[0] + dy[d];
					int nx = top[1] + dx[d];

					if (ny < 0 || nx < 0 || ny >= R || nx >= C || visited[ny][nx]) {
						continue;
					}

					if (top[2] == 0) { // 물
						if (map[ny][nx] == 'X' || map[ny][nx] == 'D')
							continue;
						q.offer(new int[] { ny, nx, 0 });
						visited[ny][nx] = true;
						map[ny][nx] = '*';
					} else if (top[2] == 1) { // 고슴도치
						if (map[ny][nx] == 'X' || map[ny][nx] == '*')
							continue;
						if (map[ny][nx] == 'D') {
							flag = true;
							return;
						}

						q.offer(new int[] { ny, nx, 1 });
						visited[ny][nx] = true;
						map[top[0]][top[1]] = '.';
						map[ny][nx] = 'S';
					}

				}

			}
			answer++;

		}

	}

	static void setInitWater() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*')
					q.offer(new int[] { i, j, 0 });
			}
		}

	}

	static void setInitDochi() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S')
					q.offer(new int[] { i, j, 1 });
			}
		}

	}
}

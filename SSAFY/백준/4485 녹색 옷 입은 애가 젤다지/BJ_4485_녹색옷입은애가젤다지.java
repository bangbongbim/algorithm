package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_4485_녹색옷입은애가젤다지 {
	int T;
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dist;
	static int answer;
	static int cnt = 1;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			dist = new int[N][N];
			visited = new boolean[N][N];
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					dist[i][j] = INF;
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dijkstra(0, 0);
			System.out.println("Problem " + cnt++ + ": " + dist[N - 1][N - 1]);

		}

	}

	static void dijkstra(int y, int x) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

		pq.offer(new int[] { y, x, map[y][x] });
		dist[y][x] = map[y][x];
		visited[y][x] = true;
		while (!pq.isEmpty()) {
			int q_size = pq.size();

			for (int i = 0; i < q_size; i++) {
				int top[] = pq.poll();

				if (top[0] == N - 1 && top[1] == N - 1)
					break;
				for (int d = 0; d < 4; d++) {
					int ny = top[0] + dy[d];
					int nx = top[1] + dx[d];

					if (ny < 0 || nx < 0 || ny >= N || nx >= N)
						continue;

					if (!visited[ny][nx] && dist[ny][nx] > top[2] + map[ny][nx]) {
						dist[ny][nx] = top[2] + map[ny][nx];
						pq.offer(new int[] { ny, nx, dist[ny][nx] });

					}
				}

			}

		}

	}

}

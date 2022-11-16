import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4193_수영대회결승전 {
	static int T;
	static int N;
	static int[][] map;
	static int[][] copyMap;
	static boolean[][] visited;
	static int timer;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int start_y, start_x, end_y, end_x;
	static boolean check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			copyMap = new int[N][N];
			visited = new boolean[N][N];
			timer = 0;
			check = false;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					// 소용돌이 처리를 편하게 하기위해 장애물을 -1로 표시
					if (map[i][j] == 1)
						map[i][j] = -1;
				}
			}

			StringTokenizer st = new StringTokenizer(br.readLine());
			start_y = Integer.parseInt(st.nextToken());
			start_x = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			end_y = Integer.parseInt(st.nextToken());
			end_x = Integer.parseInt(st.nextToken());
			setCopyMap();

			bfs(start_y, start_x);
			if (check)
				System.out.println("#" + t + " " + timer);
			else
				System.out.println("#" + t + " " + "-1");
		}
	}

	static void bfs(int y, int x) {
		Queue<Node> q = new ArrayDeque<>();

		q.offer(new Node(y, x));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int size = q.size();

			// 복구
			if (timer % 3 == 0) {
				setCopyMap();
			}

			for (int s = 0; s < size; s++) {
				Node cur = q.poll();

				if (cur.y == end_y && cur.x == end_x) {
					check = true;
					return;
				}

				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];

					if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx])
						continue;

					// 다음 위치가 소용돌이라면 대기
					if (copyMap[ny][nx] >= 1)
						q.offer(cur);

					else if (copyMap[ny][nx] == 0) {
						q.offer(new Node(ny, nx));
						visited[ny][nx] = true;
					}
				}
			}
			timer++;

			// 1초가 지날때마다 소용돌이 -1
			deleteSwirl();
		}

	}

	static void deleteSwirl() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copyMap[i][j] > 0)
					copyMap[i][j]--;
			}
		}
	}

	static void setCopyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	static class Node {
		int y;
		int x;

		public Node() {

		}

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}

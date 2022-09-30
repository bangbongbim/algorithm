import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SWEA_1249_보급로 {
	static int T;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			bfs(0, 0, map[0][0]);
			System.out.println("#"+t+" "+map[N-1][N-1]);
		}
	}

	static void bfs(int y, int x, int cost) {

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(y, x, cost));
		visited[y][x] = true;

		while (!pq.isEmpty()) {
			int size = pq.size();

			for (int s = 0; s < size; s++) {
				Node top = pq.poll();

				if (top.y == N - 1 && top.x == N - 1) {
					return;
				}

				for (int d = 0; d < 4; d++) {
					int ny = top.y + dy[d];
					int nx = top.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx])
						continue;

					map[ny][nx] += map[top.y][top.x];
					pq.offer(new Node(ny, nx, map[ny][nx]));
					visited[ny][nx] = true;
				}
			}

		}

	}

	static class Node implements Comparable<Node> {
		int y;
		int x;
		int cost;

		public Node(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}
}
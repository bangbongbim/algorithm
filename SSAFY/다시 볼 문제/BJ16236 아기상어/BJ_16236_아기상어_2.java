package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236_아기상어_2 {
	static int N, sy, sx, sSize, ans, sEatCnt;
	static int[][] map;
	static boolean[][] visit;

	static Queue<Node> queue = new ArrayDeque<>();

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 9) {
					sy = i;
					sx = j;
				}

				map[i][j] = n;
			}
		}

		// 초기화
		sSize = 2; //

		while (true) {
			// 먹이 사냥이 가능한 동안 // 먹이사냥 <= bfs(), bfs()는 사냥하는 동안 걸린 시간(초) return

			// bfs()가 0을 return 하면 더이상 먹을 고기가 없다.
			// bfs() 가 0이 아닌 값은 return하면, 먹이 사냥에 걸린 시간이므로 ans에 누적합으로 더해준다.
			int cnt = bfs();
			if (cnt == 0)
				break;
			ans += cnt; // 누적 거리

		}
		System.out.println(ans);

	}

	static int bfs() {
		// 가장 작은 Y,X DIS
		int minY = Integer.MAX_VALUE;
		int minX = Integer.MAX_VALUE;
		int minDis = Integer.MAX_VALUE;

		// visit 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[i], false);
		}

		// 시작위치부터 queue에 담고 bfs 시작
		visit[sy][sx] = true; // 항상 상어 시작위치에서 출발
		queue.offer(new Node(sy, sx, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			// 먹이에 대한 계산

			if (map[node.y][node.x] != 0 && map[node.y][node.x] < sSize) {
				if (node.d < minDis) {
					minDis = node.d;
					minY = node.y;
					minX = node.x;
				} else if (node.d == minDis) {
					if (node.y < minY) {
						minDis = node.d;
						minY = node.y;
						minX = node.x;
					} else if (node.y == minY) {
						if (node.x < minX) {
							minDis = node.d;
							minY = node.y;
							minX = node.x;
						}
					}
				}
			}

			// 가지치기
			if (node.d + 1 >= minDis)
				continue;

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] > sSize) {
					continue;
				}
				visit[ny][nx] = true;
				queue.offer(new Node(ny, nx, node.d + 1));
			}

		}

		// 먹이를 먹었던가 못 먹었던가
		if (minDis == Integer.MAX_VALUE)
			return 0; // 먹을 물고기를 찾지 못했다.
		else {
			sEatCnt++; // 먹은 물고기 수 증가
			if (sEatCnt == sSize) {
				sSize++;
				sEatCnt = 0;
			}

			map[minY][minX] = 0;
			map[sy][sx] = 0;

			// 새로운 상어의 자리 - 먹은 물고기의 자리
			sy = minY;
			sx = minX;

			return minDis; // 먹은 물고기로 이동하는 최소 거리

		}

	}

	static class Node {
		int y, x, d;

		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}

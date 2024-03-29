package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 물이 먼저 퍼지고 그 다음에 고슴도치가 이동
// bfs로 물이 퍼저 나갈 때, while(큐가 비우지 않는 동안) {... 물이 퍼지는 반복 <- 고슴도치의 이동이 포함}
// 고슴도치, 물 따라 Queue를 생성하고, 고슴도치의 Queue를 중심으로 처리
// => Queue에 대한 작업을 현재 담긴 모든 대상을 전부 다 처리를 한다고 고슴도치가 처리 다하고..... 
public class BJ_3055_탈출_2 {
	static int R, C, min;
	static char[][] map;

	static Queue<Node> wQueue = new ArrayDeque<>();
	static Queue<Node> gQueue = new ArrayDeque<>();

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
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					gQueue.offer(new Node(i, j, 0));
				} else if (map[i][j] == '*') {
					wQueue.offer(new Node(i, j, 0));
				}
			}
		}

		min = Integer.MAX_VALUE;
		check();
		System.out.println(min == Integer.MAX_VALUE ? "KAKTUS" : min);

	}

	static void check() {
		while (!gQueue.isEmpty()) {
			// 물 확산
			// 현재 물 Queue에 있는 물만을 모두 꺼내서 처리
			int size = wQueue.size();
			for (int i = 0; i < size; i++) { // 현재 물인 것만 모두 꺼내서
				Node node = wQueue.poll();

				for (int d = 0; d < 4; d++) {
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= R || nx >= C)
						continue;
					if (map[ny][nx] == '.') {
						// 물이 퍼진 상태를 map에 표시
						map[ny][nx] = '*';
						wQueue.offer(new Node(ny, nx, 0));
					}
				}

			}
			// 고슴도치 이동
			// 물 확산을 미리 처리했으므로 고슴도치는 이동시에 빈칸으로 이동( 'D' 이면 종료 )
			size = gQueue.size();
			for (int i = 0; i < size; i++) {
				Node node = gQueue.poll();

				for (int d = 0; d < 4; d++) {
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= R || nx >= C)
						continue;

					if (map[ny][nx] == 'D') {
						min = Math.min(min, node.d + 1);
					} else if (map[ny][nx] == '.') {
						// 물이 퍼진 상태를 map에 표시
						map[ny][nx] = 'S';
						gQueue.offer(new Node(ny, nx, node.d + 1));// 다음번 퍼질 물
					}
				}
			}
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

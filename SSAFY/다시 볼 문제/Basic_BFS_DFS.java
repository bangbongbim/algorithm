package algorithm_basic;

import java.util.ArrayDeque;
import java.util.Queue;

public class Basic_BFS_DFS {

	static int[][] map = { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 11, 12, 13, 14, 15, 16 }, { 0, 21, 22, 23, 24, 25, 26 },
			{ 0, 31, 32, 33, 34, 35, 36 }, { 0, 41, 42, 43, 44, 45, 46 }, { 0, 51, 52, 53, 54, 55, 56 },
			{ 0, 61, 62, 63, 64, 65, 66 }, };

	//

	// delta : 상 - 하 - 좌 - 우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	// visit 재방문 체크
	static boolean[][] visit;
	static int COUNT;

	public static void main(String[] args) {
		// dfs 초기화
		visit = new boolean[7][7];
		COUNT = 0;
		dfs(3, 3);
		System.out.println("COUNT :" + COUNT);
	}

	static void bfs(int y, int x) {
		// 초기화 - bfs() 호출 전에도 가능
		visit = new boolean[7][7];
		COUNT = 0;
		// 자료 구조 - bfs() 무관하게 별도로 미리 구성해도 좋다.
		// 자료 구조에 담을 데이터를 고민 => y,x좌표
		Queue<Node> queue = new ArrayDeque<>();
		// 방문
		// 시작점을 queue에 담고 방문 시작
		queue.offer(new Node(y, x));
		visit[y][x] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			// 테스트 출력
			System.out.println(node);
			COUNT++;

			// 4방 방문 시도
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				// range,visit check
				// 기타 문제에서 제시된 조건 체크
				if (ny < 1 || nx < 1 || ny >= 7 || nx >= 7 || visit[ny][nx])
					continue;

				// 방문 가능=> queue에 담는다.
				queue.offer(new Node(ny, nx));
				visit[ny][nx] = true;

			}

		}
		System.out.println("COUNT : " + COUNT);
	}

	static void dfs(int y, int x) {
		visit[y][x] = true;
		System.out.println(map[y][x]);
		COUNT++;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			// range,visit check
			// 기타 문제에서 제시된 조건 체크
			if (ny < 1 || nx < 1 || ny >= 7 || nx >= 7 || visit[ny][nx])
				continue;

			// 방문 가능=> queue에 담는다.
			dfs(ny, nx);

		}

	}

	static class Node { // for bfs
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}

	}

}

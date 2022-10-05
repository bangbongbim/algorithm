package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502_연구소 {
	static int N, M;
	static int[][] map;
	static int[][] copyMap;
	static List<Node> zero = new ArrayList<>();
	static Queue<Node> q = new ArrayDeque<>();
	static Node[] tgt = new Node[3];
	static int answer = Integer.MIN_VALUE;
	static int safeArea;

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					// 벽이 생길수 있는 빈 공간 저장
					zero.add(new Node(i, j));
			}
		}

		combi(0, 0);
		System.out.println(answer);

	}

	static void mapCopy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
				if (copyMap[i][j] == 2) {
					q.offer(new Node(i, j));
				}
			}
		}
	}

	static int getSafeArea() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Node cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
						continue;

					if (copyMap[ny][nx] == 0) {
						copyMap[ny][nx] = 2;
						q.offer(new Node(ny, nx));
					}

				}
			}

		}
	}

	static void combi(int start, int cnt) {
		if (cnt == 3) {
			// 맵을 복사하면서 바이러스 위치 queue에 넣어줌
			mapCopy();
			for (int i = 0; i < 3; i++) {
				Node p = tgt[i];
				copyMap[p.y][p.x] = 1;
			}
			bfs();
			safeArea = getSafeArea();
			answer = Math.max(answer, safeArea);
			return;

		}
		if (start == zero.size())
			return;

		tgt[cnt] = zero.get(start);
		combi(start + 1, cnt + 1);
		combi(start + 1, cnt);

	}

	static class Node {
		int y;
		int x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}

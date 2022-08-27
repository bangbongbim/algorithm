
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236_아기상어 {
	static int N;
	static int[][] map;
	static int shark_size = 2, beit_cnt;
	static List<Node> fish = new ArrayList<>();
	static Node sharkPosition;
	static int answer;
	static int distance;
	static Node fishPosition;
	static boolean flag;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sharkPosition = getStartPosition();

		while (true) {
			fishPosition = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
			fishPosition.distance = Integer.MAX_VALUE;
			// 상어의 시작 위치
//			sharkPosition = getStartPosition();
			// 현재 상어 위치와 상어의 크기를 기준으로 먹을 수 있는 물고기의 리스트
			setFishList();

			// 현재 먹을 수 있는 물고기가 없다면 종료
			if (fish.isEmpty()) {
				System.out.println(answer);
				break;
			}
			// 먹을 수 있는 물고기가 두마리 이상일 때
			else {
				while (!fish.isEmpty()) {
					bfs(sharkPosition.y, sharkPosition.x, fish.get(0).y, fish.get(0).x);
					fish.remove(0);
				}
				if (!flag) {
					System.out.println(answer);
					break;
				}

				// 먹은 물고기 카운트 ++
				beit_cnt++;
				// 시간 카운트 ++
				answer += fishPosition.distance;
				// 상어의 위치 업데이트
				map[fishPosition.y][fishPosition.x] = 0;
				map[sharkPosition.y][sharkPosition.x] = 0;
				sharkPosition = new Node(fishPosition.y,fishPosition.x);
			}

			if (beit_cnt == shark_size) {
				shark_size++;
				beit_cnt = 0;
			}
			fish.clear();
			flag=false;

		}

	}

	static void bfs(int sharkY, int sharkX, int fishY, int fishX) {
		int cnt = 0;
		boolean[][] visited = new boolean[N + 1][N + 1];
		Queue<int[]> q = new ArrayDeque<>();

		q.offer(new int[] { sharkY, sharkX });
		visited[sharkY][sharkX] = true;

		while (!q.isEmpty()) {
			int q_size = q.size();

			for (int i = 0; i < q_size; i++) {
				int[] top = q.poll();

				if (top[0] == fishY && top[1] == fishX) {
					if (fishPosition.distance > cnt) {
						fishPosition.x = top[1];
						fishPosition.y = top[0];
						fishPosition.distance = cnt;
						
					} else if (fishPosition.distance == cnt) {
						
						if (fishPosition.y > top[0]) {
							fishPosition.x = top[1];
							fishPosition.y = top[0];
							fishPosition.distance = cnt;
							
						} else if (fishPosition.y == top[0]) {
							
							if (fishPosition.x > top[1]) {
								fishPosition.x = top[1];
								fishPosition.y = top[0];
								fishPosition.distance = cnt;
							}
						}
					}
					flag = true;
					return;
				}

				for (int d = 0; d < 4; d++) {
					int ny = top[0] + dy[d];
					int nx = top[1] + dx[d];

					if (ny < 1 || nx < 1 || ny > N || nx > N)
						continue;

					if (visited[ny][nx] || (map[ny][nx] > shark_size))
						continue;

					q.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
				}
			}
			cnt++;

		}

	}


	static void setFishList() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] < shark_size && map[i][j] != 0) {
					fish.add(new Node(i, j));
				}
			}
		}
	}

	static Node getStartPosition() {

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 9) {
					return new Node(i, j);
				}
			}
		}
		return new Node(0, 0);
	}

	static class Node {
		int y;
		int x;
		int distance;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_17135_캐슬디펜스 {
	static int N, M, D;
	static int[][] map;
	static int[][] copyMap;
	static int archor[];
	static boolean[] visited;
	static int answer = Integer.MIN_VALUE;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		copyMap = new int[N + 1][M + 1];
		archor = new int[3];
		visited = new boolean[M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combi(1, 0);

		System.out.println(answer);
	}

	static void combi(int start, int tgtIdx) {
		if (tgtIdx == 3) {
//			System.out.println(Arrays.toString(archor));
			cnt = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					copyMap[i][j] = map[i][j];

				}
			}
			while (!checkEndGame()) {

				// 궁수 공격
				attack();

				// 적 이동
				moveEnemy();
			}
			answer = Math.max(answer, cnt);
			return;

		}
		for (int i = start; i <= M; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			archor[tgtIdx] = i;
			combi(start + 1, tgtIdx + 1);
			archor[tgtIdx] = 0;
			visited[i] = false;
		}

	}

	static void attack() {
		int dist = 0; // 궁수와 적과의 거리
		ArrayList<Enemy> distance_list = new ArrayList<>();
		ArrayList<Enemy> target = new ArrayList<>();
		for (int archor_idx = 0; archor_idx < 3; archor_idx++) { // 궁수 위치 [N+1][archor[archor_idx]]
			distance_list.clear();
			for (int y = 1; y <= N; y++) { // 적 위치 map[i][j] == 1
				for (int x = 1; x <= M; x++) {
					if (copyMap[y][x] == 1) {
						dist = Math.abs((N + 1) - y) + Math.abs(archor[archor_idx] - x); // 거리 계산
						if (dist <= D) {
							distance_list.add(new Enemy(y, x, dist));
						}
					}
				}
			}
			Collections.sort(distance_list, (o1, o2) -> o1.dist == o2.dist ? o1.x - o2.x : o1.dist - o2.dist);
			if (!distance_list.isEmpty()) {
				target.add(distance_list.get(0));
			}
		}

		for (int i = 0; i < target.size(); i++) {
			if (copyMap[target.get(i).y][target.get(i).x] == 1) {
				copyMap[target.get(i).y][target.get(i).x] = 0;
				cnt++;
			}
		}

	}

	static void moveEnemy() {
		for (int i = N; i >= 1; i--) {
			for (int j = 1; j <= M; j++) {
				copyMap[i][j] = copyMap[i - 1][j];
			}
		}

		for (int i = 1; i <= M; i++)
			copyMap[0][i] = 0;
	}

	static boolean checkEndGame() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (copyMap[i][j] == 1)
					return false;
			}
		}
		return true;
	}

	static class Enemy {
		int y;
		int x;
		int dist;

		public Enemy(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}

}

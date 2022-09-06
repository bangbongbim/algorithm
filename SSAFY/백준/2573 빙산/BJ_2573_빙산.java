import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2573_빙산 {
	static int N, M;
	static int[][] map;
	static int[][] copyMap;

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int cnt;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copyMap = new int[N][M];

		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 모든 빙하가 녹지 않았을 때
		while (!allMeltGlacier()) {
			cnt = 0;
			// 빙하 녹임
			initCopyMap();
			meltGlacier();
			setMap();
			// 빙하가 분리되었는지 확인
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copyMap[i][j] != 0) {
						resetVisited();

						copyMap[i][j] = 0;
						visited[i][j] = true;
						checkDivide(i, j);
						cnt++;
					}
				}
			}
			answer++;

			if (cnt > 1) {
				System.out.println(answer);
				return;
			}

		}
		System.out.println(0);

	}

	static void initCopyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	static void setMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
	}

	static boolean allMeltGlacier() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0)
					return false;
			}
		}
		return true;
	}

	static void resetVisited() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = false;
			}
		}

	}

	static void checkDivide(int y, int x) {

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || copyMap[ny][nx] == 0)
				continue;

			copyMap[ny][nx] = 0;
			visited[ny][nx] = true;
			checkDivide(ny, nx);
		}

	}

	static void meltGlacier() {
		// 빙산 주변에 바다가 있다면 빙산의 높이 조절
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					int seaCnt = 0;

					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];

						if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] != 0)
							continue;
						seaCnt++;
					}

					if (map[i][j] - seaCnt <= 0)
						copyMap[i][j] = 0;
					else
						copyMap[i][j] -= seaCnt;
				}
			}
		}
	}

}

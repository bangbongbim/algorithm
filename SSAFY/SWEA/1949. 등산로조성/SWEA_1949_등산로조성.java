import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1949_등산로조성 {
	static int T;
	static int N, K;
	static int[][] map;
	static int[][] copyMap;
	static int max;
	static int answer;

	static List<Node> list = new ArrayList<>();
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			answer = Integer.MIN_VALUE;

			map = new int[N][N];
			copyMap = new int[N][N];
			visited = new boolean[N][N];
			list.clear();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max)
						max = map[i][j];
				}
			}

			// 제일 높은 값을 가진 봉우리들을 list에 넣음
			setList();

			for (int i = 0; i < list.size(); i++) {
				reset();
				dfs(list.get(i).y, list.get(i).x, false, 1);
			}

			System.out.println("#" + t + " " + answer);
		}
	}

	static void dfs(int y, int x, boolean flag, int cnt) {
		visited[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = dy[d] + y;
			int nx = dx[d] + x;

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) {
				continue;
			}

			// 다음 봉우리가 현재 봉우리보다 크거나 같을때
			if (copyMap[y][x] <= copyMap[ny][nx]) {
				// 봉우리를 깎지 않은 상태일때
				if (!flag) {
					// 1~K까지 깎을수 있음
					for (int p = 1; p <= K; p++) {
						if (copyMap[ny][nx] - p < copyMap[y][x]) {
							copyMap[ny][nx] -= p;
							flag = true;

							dfs(ny, nx, flag, cnt + 1);
							// 되돌리기
							copyMap[ny][nx] += p;
							visited[ny][nx] = false;
							flag = false;
						}
					}
				}
			} else {
				dfs(ny, nx, flag, cnt + 1);
				// 되돌리기
				visited[ny][nx] = false;
			}

		}

		// 사방 탐색에서 걸리는 부분이 없을 때
		answer = Math.max(answer, cnt);
		return;

	}

	static void reset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
				copyMap[i][j] = map[i][j];
			}
		}
	}

	static void setList() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == max)
					list.add(new Node(i, j));
			}
		}
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}

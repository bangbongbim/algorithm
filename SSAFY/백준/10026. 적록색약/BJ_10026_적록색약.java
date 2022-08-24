import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_10026_적록색약 {
	static char[][] map;
	static char[][] copyMap;
	static boolean[][] visited;
	static int N;
	static int a, b;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		copyMap = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		setCopyMap();
		case1();
		setCopyMap();
		case2();
		System.out.println(a + " " + b);

	}

	static void setCopyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	static void case1() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copyMap[i][j] == 'X')
					continue;
				else if (copyMap[i][j] == 'R') {
					dfs(i, j, 'R', 'R');
					a++;
				} else if (copyMap[i][j] == 'G') {
					dfs(i, j, 'G', 'G');
					a++;
				} else if (copyMap[i][j] == 'B') {
					dfs(i, j, 'B', 'B');
					a++;
				}

			}
		}

	}

	static void case2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copyMap[i][j] == 'X')
					continue;
				else if (copyMap[i][j] == 'R' || copyMap[i][j] == 'G') {
					dfs(i, j, 'R', 'G');
					b++;
				} else if (copyMap[i][j] == 'B') {
					dfs(i, j, 'B', 'B');
					b++;
				}

			}
		}

	}

	static void dfs(int y, int x, char color1, char color2) {
		copyMap[y][x] = 'X';

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || copyMap[ny][nx] == 'X') {
				continue;
			}

			if (copyMap[ny][nx] == color1 || copyMap[ny][nx] == color2) {
				dfs(ny, nx, color1, color2);
			}

		}

	}
}
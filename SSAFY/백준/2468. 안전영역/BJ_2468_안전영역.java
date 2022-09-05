import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2468_안전영역 {
	static int N;
	static int[][] map;
	static int[][] copyMap;
	static int maxLevel = Integer.MIN_VALUE;
	static int answer = Integer.MIN_VALUE;
	static int cnt;

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		copyMap = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int l = Integer.parseInt(st.nextToken());
				map[i][j] = l;
				maxLevel = Math.max(maxLevel, map[i][j]);
			}
		}
		
		// map의 최대값 만큼 수위를 조절해서 최대의 안전 영역을 구함.
		for (int i = 0; i <= maxLevel; i++) {
			// map에 잠겼다는 표현을 하기 위해 copyMap 사용
			setCopyMap();
			submerge(i);
			cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (copyMap[j][k] != 9999) {
						dfs(j, k);
						cnt++;
					}

				}
			}
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
	}

	static void dfs(int y, int x) {

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || copyMap[ny][nx] == 9999)
				continue;

			copyMap[ny][nx] = 9999;
			dfs(ny, nx);

		}

	}

	static void setCopyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	static void submerge(int level) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copyMap[i][j] <= level) {
					copyMap[i][j] = 9999;
				}
			}
		}
	}
}

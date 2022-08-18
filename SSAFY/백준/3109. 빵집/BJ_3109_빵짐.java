import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3109_빵짐 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int answer;
	static boolean flag;

	static int dy[] = { -1, 0, 1 };
	static int dx[] = { 1, 1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int start = 0; start < R; start++) {
			visited[start][0] = true;
			flag=false;
			dfs(start, 0);
		}

		System.out.println(answer);

	}

	static void dfs(int y, int x) {

		if (x == C - 1) {
			answer++;
			flag = true;
			return;
		}

		for (int d = 0; d < 3; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny >= R || nx >= C || ny < 0 || nx < 0)
				continue;
			if (map[ny][nx] == 'x' || visited[ny][nx])
				continue;
			visited[ny][nx] = true;
			dfs(ny, nx);
			if (flag)
				return;

		}

	}

}

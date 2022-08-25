import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10971_외판원순회2 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;

	static void dfs(int start, int now, int num) {
		if (check() && map[now][start] > 0) {
			answer = Math.min(answer, num + map[now][1]);
			num = 0;
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && map[now][i] != 0) {
				visited[i] = true;
				dfs(start, i, num + map[now][i]);
				visited[i] = false;
			}

		}

	}

	static boolean check() {
		for (int i = 1; i <= N; i++)
			if (!visited[i])
				return false;

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[1] = true;
		dfs(1, 1, 0);

		System.out.println(answer);

	}

}

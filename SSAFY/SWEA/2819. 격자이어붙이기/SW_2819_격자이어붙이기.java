import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SW_2819_격자이어붙이기 {
	static int T;
	static int N = 4;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static TreeSet<String> ts;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			map = new int[N][N];
			ts = new TreeSet();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 0, new int[] { map[i][j], 0, 0, 0, 0, 0, 0 });
				}
			}
			System.out.println("#" + t + " " + ts.size());
		}
	}

	static void dfs(int i, int j, int cnt, int[] nums) {
		if (cnt == 6) {
			ts.add(Arrays.toString(nums));
			return;
		}

		for (int d = 0; d < 4; d++) {
			int ny = i + dy[d];
			int nx = j + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N)
				continue;

			nums[cnt +1] = map[ny][nx];
			dfs(ny, nx, cnt + 1, nums);

		}

	}
}

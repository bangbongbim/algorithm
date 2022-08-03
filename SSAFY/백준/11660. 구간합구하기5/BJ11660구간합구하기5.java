import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11660구간합구하기 {
	static int N, M;
	static int arr[][];
	static int x1, y1, x2, y2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
				// 구간합 더하고 중복되는 부분 빼줌
			}
		}
		// ex) (3,4) => (1,1) ~ (3,4)까지의 합

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			sb.append(arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1-1][y1 - 1]).append("\n");
			// ex) (2,2) (3,4) 일 경우   (1,1)~(3,4)까지의 합  - (1,1) ~(1,4)까지의 합  - (1,1) ~ (1,4)까지의 합 + 중복된 부분
		}
		System.out.println(sb.toString());

	}

}

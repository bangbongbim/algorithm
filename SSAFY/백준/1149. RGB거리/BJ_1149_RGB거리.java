package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리 {
	static int N;
	static int[][] rgb;
	static int[][] dp;
	static int R, G, B;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		rgb = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			rgb[i][0] = Integer.parseInt(st.nextToken());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 0) {
					dp[i][j] = rgb[i][j];
				} else {
					if (j == 0) {
						dp[i][j] = Math.min(dp[i - 1][1] + rgb[i][j], dp[i - 1][2] + rgb[i][j]);
					} else if (j == 1) {
						dp[i][j] = Math.min(dp[i - 1][0] + rgb[i][j], dp[i - 1][2] + rgb[i][j]);
					} else if (j == 2) {
						dp[i][j] = Math.min(dp[i - 1][0] + rgb[i][j], dp[i - 1][1] + rgb[i][2]);
					}
				}
			}
		}

		Arrays.sort(dp[N - 1]);
		System.out.println(dp[N-1][0]);

	}

}

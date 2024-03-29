
package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11660구간합구하기5_3 {
	static int N, M;
	static int[][] accu; // 행별로 각각 누적 계산

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		accu = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			// 행과 열을 모두 합한 누적 계산, 현재 좌표 기준으로 원점(시작점)과의 사작형내의 모든합

			for (int j = 1; j <= N; j++) {
				accu[i][j] = accu[i - 1][j] + accu[i][j - 1] - accu[i - 1][j - 1] + Integer.parseInt(st.nextToken());
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// x 가 행

			sb.append(accu[x2][y2] - accu[x1 - 1][y2] - accu[x2][y1 - 1] + accu[x1 - 1][y1 - 1]).append("\n");
		}

		System.out.println(sb.toString());

	}

}

package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_Z_2 {
	static int N, r, c, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		// N은 2의 제곱수이므로 N은실제 좌,우 에 해당하는 길이로 보정

		N = (int) Math.pow(2, N);

		int y = 0;
		int x = 0;

		// 분할 정복

		while (N > 1) {
			// 가로 , 세로를 반으로 나누어서 4공간으로 분할
			N /= 2;

			// r,c가 4공간 중 어느 곳에 해당하는지 판단 , 각 공간에서 r,c 값에 따라 ans값을 갱신, 원점 보정
			if (r < y + N && c < x + N) { // top - left
				;
			} else if (r < y + N && c >= x + N) { // top - right
				ans += N * N * 1;
				x += N;
			} else if (r >= y + N && c < x + N) { // bottom - left
				ans += N * N * 2;
				y += N;
			} else if (r >= y + N && c >= x + N) { // bottom - right
				ans += N * N * 3;
				y += N;
				x += N;
			}

		}

		System.out.println(ans);

	}

}

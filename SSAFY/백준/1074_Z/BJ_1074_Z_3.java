package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_Z_3 {
	static int N, r, c, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		// N은 2의 제곱수이므로 N은실제 좌,우 에 해당하는 길이로 보정

		N = (int) Math.pow(2, N);
		z(0, 0);
		System.out.println(ans);

	}

	static void z(int y, int x) {
		if (N == 1)
			return;

		N /= 2;

		// r,c가 4공간 중 어느 곳에 해당하는지 판단 , 각 공간에서 r,c 값에 따라 ans값을 갱신, 원점 보정
		if (r < y + N && c < x + N) { // top - left
			z(y, x);
		} else if (r < y + N && c >= x + N) { // top - right
			ans += N * N * 1;
			z(y, x + N);
		} else if (r >= y + N && c < x + N) { // bottom - left
			ans += N * N * 2;
			z(y + N, x);
		} else if (r >= y + N && c >= x + N) { // bottom - right
			ans += N * N * 3;
			z(y + N, x + N);
		}

	}

}

package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_Z {
	static int N, r, c;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sol(0, 0, (int) Math.pow(2, N));

	}

	static void sol(int y, int x, int s) {

		if (y == r && x == c) {
			System.out.println(answer);
			return;
		}

		if (r < y + s && r >= y && c >= x && c < x + s) {

			sol(y, x, s / 2);
			sol(y, x + s / 2, s / 2);
			sol(y + s / 2, x, s / 2);
			sol(y + s / 2, x + s / 2, s / 2);
		}

		else {
			answer += s * s;
		}
	}
}

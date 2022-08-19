package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_3324_준환이의양팔저울_3 {

	static int T, N, ans;
//	static int[] choo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[] choo = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());

			}

			ans = 0;

			perm(0, 0, 0, 0, choo);

			System.out.println("#" + t + " " + ans);
		}
	}

	static void perm(int tgtIdx, int leftSum, int rightSum, int select, int[] choo) {
		// 기저 조건
		if (tgtIdx == N) {
			// complete code
			ans++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((select & 1 << i) != 0)
				continue;
			// 2가지의 재귀호출
			// #1 왼쪽에 추를 올리는 방법
			perm(tgtIdx + 1, leftSum + choo[i], rightSum, select | 1 << i, choo);
			// #2 오른쪽에 추를 올리는 방법 (문제의 조건 + 가지치기)
			if (leftSum >= rightSum + choo[i])
				perm(tgtIdx + 1, leftSum, rightSum + choo[i], select | 1 << i, choo);

		}
	}

}

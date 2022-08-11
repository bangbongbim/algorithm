package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW9229_한빈이와spotmarket_3 {
	static int T, N, M, ans;
	static int[] src, tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			// 초기화

			src = new int[N];
			tgt = new int[2];

			ans = -1;

			// 입력 처리
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				src[i] = Integer.parseInt(st.nextToken());
			}

			// 조합
			comb(0, 0);

			System.out.println("#" + t + " " + ans);
		}
	}

	static void comb(int srcIdx, int tgtIdx) {
		// 기저 조건
		if (tgtIdx == 2) {
			// complete code
			int sum = tgt[0] + tgt[1];
			if (sum > M)
				return;
			ans = Math.max(ans, sum);
			return;
		}
		// 기저 조건 - src

		for (int i = srcIdx; i < src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb(i + 1, tgtIdx + 1);
		}

	}
}

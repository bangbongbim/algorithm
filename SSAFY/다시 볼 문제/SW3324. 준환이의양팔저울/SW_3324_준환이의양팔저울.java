package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 
3
3
1 2 4
3
1 2 3
9
1 2 3 5 6 4 7 8 9

 * */
public class SW_3324_준환이의양팔저울 {
	static int T, N;
	static int[] list;
	static int[] tgt1, tgt2;
	static boolean[] visit;
	static int answer;
	static int l_sum, r_sum;
	static int sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			list = new int[N];
			visit = new boolean[N];
			tgt1 = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
				sum += list[i];
			}

			for (int r = 1; r <= N; r++) {
				perm(0, r, 0, 0);
			}

			System.out.println(answer);
		}

	}

	static void perm(int tgtIdx, int r, int l_sum, int r_sum) {
		if (tgtIdx == r) {
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;

			if (l_sum < r_sum)
				continue;
			visit[i] = true;
			tgt1[tgtIdx] = list[i];
			perm(tgtIdx + 1, r, l_sum + tgt1[tgtIdx], r_sum);
			visit[i] = false;
		}

	}

}

package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1247_최적경로_2 {
	static int T, N, comY, comX, homeY, homeX, min;
	static int[][] cust; // src
	static int[] tgt;
	static boolean[] select;
	static int[] index;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;

			N = Integer.parseInt(br.readLine());
			cust = new int[N][2];
			tgt = new int[N];
			index = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			comY = Integer.parseInt(st.nextToken());
			comX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}

//			perm(0);

			// 가장 작은수로 정렬
			// 정렬된 현재 시작 배열도 경우의 수 중 하나
			//

			for (int i = 0; i < N; i++) {
				index[i] = i;
			}
			while (true) {
				check();
				if (!np())
					break;
			}

			System.out.println("#" + t + " " + min);
		} // end tc

	} // end main

	static void check() {
		int sum = distance(comY, comX, cust[index[0]][0], cust[index[0]][1]);
		for (int i = 0; i < N - 1; i++) {
			sum += distance(cust[index[i]][0], cust[index[i]][1], cust[index[i + 1]][0], cust[index[i + 1]][1]);
		}
		sum += distance(homeY, homeX, cust[index[N - 1]][0], cust[index[N - 1]][1]);

		min = Math.min(min, sum);
		return;

	}

	static boolean np() {
		int i = index.length - 1;
		while (i > 0 && index[i - 1] >= index[i])
			i--;

		if (i == 0)
			return false;

		int j = index.length - 1;

		while (index[i - 1] >= index[j])
			j--;

		swap(index, i - 1, j);

		int k = index.length - 1;
		while (i < k)
			swap(index, i++, k--);

		return true;
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	static void perm(int tgtIdx) {
		// 기저 조건
		if (tgtIdx == N) {
			// complete code
			// 현재 고객의 순서를 순열에 의해서 경우의 수가 만들어졌다.
			// 그 순서는 tgt 배열에 저장되어 있음.
			// 총 거기를 계산해서 min 갱신

			// 회사 -> 첫번째 고객
			int sum = distance(comY, comX, cust[tgt[0]][0], cust[tgt[0]][1]);
			for (int i = 0; i < N - 1; i++) {
				sum += distance(cust[tgt[i]][0], cust[tgt[i]][1], cust[tgt[i + 1]][0], cust[tgt[i + 1]][1]);
			}
			sum += distance(homeY, homeX, cust[tgt[N - 1]][0], cust[tgt[N - 1]][1]);

			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (select[i])
				continue;

			select[i] = true;
			tgt[tgtIdx] = i;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	} // end perm

	static int distance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1 - y2) + Math.abs(x1 - x2);
	} // end distance

} // end class
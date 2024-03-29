package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// MEMOI
// 순열의 경우의 수를 게산
// 1,2,3,4,5,6 추가 있다고 가정
// 왼쪽 1,2,3이 올라가면 오른쪽 : 456,465,546,564,645,654 = 3*2*1
// 왼쪽 1,3,2 = 6

// 시간초과
public class SW_3324_준환이의양팔저울_6 {
	static int T, N, ans;
	static int[] choo;
	static boolean[] select;
	static int[][] memoi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			choo = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0; // 추의 무게의 합
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
				sum += choo[i];
			}

			// memoi 구성
			memoi = new int[sum + 1][1 << N]; // 2^N 1(o/x) -2(o/x) -3(o/x) . . . . .

			ans = 0;

			ans = perm(0, 0, 0, 0);

			System.out.println("#" + t + " " + ans);
		}
	}

	static int perm(int tgtIdx, int leftSum, int rightSum, int mask) {
		// 기저 조건
		if (tgtIdx == N) {
			return 1;
		}

		if (memoi[leftSum][mask] != 0)
			return memoi[leftSum][mask];

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			// 이미 사용한 추 제외
			if ((mask & 1 << i) != 0)
				continue;
			// 2가지의 재귀호출
			// #1 왼쪽에 추를 올리는 방법
			cnt += perm(tgtIdx + 1, leftSum + choo[i], rightSum, mask | 1 << i);
			// #2 오른쪽에 추를 올리는 방법 (문제의 조건 + 가지치기)
			if (leftSum >= rightSum + choo[i])
				cnt += perm(tgtIdx + 1, leftSum, rightSum + choo[i], mask | 1 << i);

		}
		memoi[leftSum][mask] = cnt;
		return cnt;
	}

}

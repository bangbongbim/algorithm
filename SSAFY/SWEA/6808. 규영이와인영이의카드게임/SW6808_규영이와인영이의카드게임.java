package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW6808_규영이와인영이의카드게임 {
	static int T, win, lose, N = 9;
	static int[] input = new int[19];
	static int[] guCard = new int[9]; // 테케에서 고정
	static int[] inCard = new int[9]; // guCard에 없는 번호를 입력 <= 순열을 만들기 위해 선택할 수 있는 src
	static int[] tgt = new int[9];

	static boolean[] select = new boolean[9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			// 초기화
			win = 0;
			lose = 0;
			Arrays.fill(input, 0);

			StringTokenizer st = new StringTokenizer(br.readLine());

			// 규영이 카드
			int num = 0;
			for (int i = 0; i < N; i++) {
				num = Integer.parseInt(st.nextToken());
				guCard[i] = num;
				input[num] = 1; // 인영이카드 설정
			}
			// 인영이 카드 - 순열의 src
			num = 0;
			for (int i = 1; i <= 18; i++) {
				if (input[i] == 0) {
					inCard[num++] = i;
				}
			}
			perm(0);
			System.out.println("#" + t + " " + win + " " + lose);
		}
	}

	static void perm(int idx) {
		if (idx == N) {
			check();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (select[i])
				continue;

			tgt[idx] = inCard[i];
			select[i] = true;
			perm(idx + 1);
			select[i] = false;

		}

	}

	static void check() {
		int g_sum = 0, i_sum = 0;

		for (int i = 0; i < N; i++) {
			if (guCard[i] < tgt[i]) {
				i_sum += guCard[i] + tgt[i];
			} else if (guCard[i] > tgt[i]) {
				g_sum += guCard[i] + tgt[i];
			}
		}

		if (g_sum > i_sum)
			win++;
		else if (g_sum < i_sum)
			lose++;

	}

}

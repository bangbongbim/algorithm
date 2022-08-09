package ps;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW6808_규영이와인영이의카드게임_3 {
	static int T, win, lose, N = 9;
	static int[] input = new int[19];
	static int[] guCard = new int[9]; // 테케에서 고정
	static int[] inCard = new int[9];
//	    static int[] tgt = new int[9];

	static boolean[] select = new boolean[N];

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("SWEA6808.txt"));	

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
			num = 0; // 맨 앞, 계속 증가
			for (int i = 1; i <= 18; i++) {
				if (input[i] == 0)
					inCard[num++] = i;
			}

			perm(0, 0, 0);

			System.out.println("#" + t + " " + win + " " + lose);

		}

	}

	static void perm(int guIdx, int guSum, int inSum) {
		// 기저 조건
		// 규영이의 카드로 부터 임의의 카드를 순열로 완성한 경우
		if (guIdx == N) {
			// complete code

			if (guSum > inSum)
				win++;
			else if (guSum < inSum)
				lose++;
			return;
		}

		for (int inIdx = 0; inIdx < N; inIdx++) { // 인영이의 카드 index
			// 이미 선택된 i 제외
			if (select[inIdx])
				continue;

			select[inIdx] = true;
			// 파라미터 tgtIdx <- 규영이의 카드 index
			if (guCard[guIdx] > inCard[inIdx]) // 규영 승리
			{
				perm(guIdx + 1, guSum + guCard[guIdx] + inCard[inIdx], inSum);
			} else { // 인영 승리
				perm(guIdx + 1, guSum, inSum + guCard[guIdx] + inCard[inIdx]);
			}

			select[inIdx] = false;
		}

	}
}

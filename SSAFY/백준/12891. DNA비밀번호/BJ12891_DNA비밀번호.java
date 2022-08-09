package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12891_DNA비밀번호 {

	static int S, P;
	static String str;
	static int A_cnt, C_cnt, G_cnt, T_cnt;
	static boolean check = false;
	static int answer;
	static int[] visit = new int[4];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		str = br.readLine();

		st = new StringTokenizer(br.readLine());

		A_cnt = Integer.parseInt(st.nextToken());
		C_cnt = Integer.parseInt(st.nextToken());
		G_cnt = Integer.parseInt(st.nextToken());
		T_cnt = Integer.parseInt(st.nextToken());

		int p1 = 0;
		int p2 = P;
		for (int i = 0; i <= P; i++) {
			if (str.charAt(i) == 'A') {
				visit[0]++;
			} else if (str.charAt(i) == 'C') {
				visit[1]++;
			} else if (str.charAt(i) == 'G') {
				visit[2]++;
			} else if (str.charAt(i) == 'T') {
				visit[3]++;
			}
		}
		if (visit[0] >= A_cnt && visit[1] >= C_cnt && visit[2] >= G_cnt && visit[3] >= T_cnt) {
			answer++;
		}
		while (p2 < S) {
			if (str.charAt(p1) == 'A') {
				visit[0]--;
			} else if (str.charAt(p1) == 'C') {
				visit[1]--;
			} else if (str.charAt(p1) == 'G') {
				visit[2]--;
			} else if (str.charAt(p1) == 'T') {
				visit[3]--;
			}

			p1++;
			p2++;

			if (p2 >= S)
				break;

			if (str.charAt(p2) == 'A') {
				visit[0]++;
			} else if (str.charAt(p2) == 'C') {
				visit[1]++;
			} else if (str.charAt(p2) == 'G') {
				visit[2]++;
			} else if (str.charAt(p2) == 'T') {
				visit[3]++;
			}

			if (visit[0] >= A_cnt && visit[1] >= C_cnt && visit[2] >= G_cnt && visit[3] >= T_cnt) {
				answer++;
			}

		}
		System.out.println(answer);
	}

}

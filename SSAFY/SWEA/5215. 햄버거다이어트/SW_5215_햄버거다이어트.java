import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_5215_햄버거다이어트 {
	static int T;
	static int N, L;
	static int[] grade;
	static int[] cal;
	static boolean[] isSelected;
	static int c_sum, g_sum;
	static int answer;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			grade = new int[N];
			cal = new int[N];
			isSelected = new boolean[N];
			answer = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				grade[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}

			subset(0);
			System.out.println("#" + t + " " + answer);
		}

	}

	static void subset(int cnt) {
		if (cnt == N) {
			print();
			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);

	}

	static void print() {
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				g_sum += grade[i];
				c_sum += cal[i];
			}
			if (c_sum <= L && g_sum >= answer) {
				answer = g_sum;
			}
		}
		c_sum = 0;
		g_sum = 0;
	}
}

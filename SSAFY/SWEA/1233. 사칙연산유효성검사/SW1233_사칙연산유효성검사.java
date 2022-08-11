package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW1233_사칙연산유효성검사 {

	static char arr[];
	static int N;
	static int answer = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			answer = 1;
			arr = new char[N + 1];
			for (int i = 1; i <= N; i++) {
				arr[i] = br.readLine().split(" ")[1].charAt(0);
			}

			dfs(1);
			System.out.println("#" + t + " " + answer);

		}
	}

	static void dfs(int x) {
		if (x > N) // 기저 조건
			answer = 0;
		if (Character.isDigit(arr[x])) { // arr[x]가 숫자일때
			if (x * 2 > N)
				return;
			answer = 0;
		} else { // arr[x]가 연산자일때
			if (x * 2 > N) {
				answer = 0;
				return;
			}
			dfs(x * 2);
			dfs(x * 2 + 1);

		}
	}
}

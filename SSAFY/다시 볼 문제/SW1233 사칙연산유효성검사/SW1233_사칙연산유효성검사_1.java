package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1233_사칙연산유효성검사_1 {
	static int N, ans;
	static char[] node;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			node = new char[N + 1]; // 0 dummy

			// 두분째만 처리
			for (int i = 1; i <= N; i++) {
				node[i] = br.readLine().split(" ")[1].charAt(0);
			}

			int idx = N;
			ans = 1;

			while (idx != 1) {
				// 현재 idx Node의 유효성 검사
				// idx, idx-1( 맨 끝 ,맨 끝(왼쪽)=> 둘 다 숫자)
				// 위 두 Node의 부모는 연산자이여야 함.

				if (!Character.isDigit(node[idx]) || !Character.isDigit(node[idx - 1])
						|| Character.isDigit(node[idx / 2])) {
					ans = 0;
					break;
				}
				node[idx/ 2] = '1'; // 실제 수직을 처리x => 단순하세 유효성 검사

				idx -= 2;

			}
			System.out.println("#"+t+" "+ans);
		}

	}

}

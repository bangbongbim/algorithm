package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659구간합구하기4_2 {
	static int N, M;
	static int[] accu;

	// 0 1 2 3 4 5
	// 0 1 3 6 10 15
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		accu = new int[N + 1]; // 0 dummy
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			accu[i] = Integer.parseInt(st.nextToken()) + accu[i - 1];
		}

		// M개의 구간합
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			sb.append(accu[to] - accu[from - 1]).append("\n");
			System.out.print(sb.toString());

			// M개많큼 출력을 해야하기 때문에 최대 100,000만번을 해야함.
			// StringBuilder로 속도 높일 수 있음

//			System.out.println(accu[to] - accu[from - 1]);
		}

	}

}

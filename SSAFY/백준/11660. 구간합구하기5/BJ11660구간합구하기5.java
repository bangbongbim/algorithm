package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11660구간합구하기5 {
	static int N, M;
	static int arr[][];
	static int s1, s2, e1, e2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			s1 = Integer.parseInt(st.nextToken());
			s2 = Integer.parseInt(st.nextToken());
			e1 = Integer.parseInt(st.nextToken());
			e2 = Integer.parseInt(st.nextToken());

			System.out.println(arr[e1][e2] - arr[s1][s2]);
		}

	}

}

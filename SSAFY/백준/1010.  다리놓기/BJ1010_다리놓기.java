package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1010_다리놓기 {
	static int arr[][] = new int[30][30];
	static int T, N, M;

	public static void main(String[] args) throws Exception {
		set();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			System.out.println(arr[M][N]);

		}
	}

	static void set() {
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				if (i < j)
					break;
				if (j == 0 || i == j)
					arr[i][j] = 1;
				else
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}
	}

}

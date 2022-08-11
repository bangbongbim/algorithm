package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2563_색종이 {
	static int N;
	static int arr[][] = new int[101][101];
	static int py, px;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			py = Integer.parseInt(st.nextToken());
			px = Integer.parseInt(st.nextToken());

			for (int y = py; y < py + 10; y++) {
				for (int x = px; x < px + 10; x++) {
					arr[y][x] = 1;
				}
			}

		}
		for (int y = 0; y < 101; y++) {
			for (int x = 0; x < 101; x++) {
				if (arr[y][x] == 1)
					answer++;
			}
		}
		System.out.println(answer);

	}

}

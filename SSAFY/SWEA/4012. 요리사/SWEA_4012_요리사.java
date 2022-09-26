import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static int T;
	static int N;
	static int[][] map;
	static int[] src;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());

			map = new int[N + 1][N + 1];
			src = new int[N];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			System.out.println("==== map ====");
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			combi(1, 0);
			System.out.println("#" + t + " " + answer);
		}

	}

	static void check() {
		int A = 0;
		int B = 0;
		int taste = 0;
		List<Integer> part = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			boolean check = false;
			for (int j = 0; j < N / 2; j++) {
				if (src[j] == i) {
					check = true;
				}
			}
			if (!check)
				part.add(i);
		}

//		for (int i = 0; i < part.size(); i++) {
//			System.out.print(part.get(i) + " ");
//		}
//		System.out.println();

		for (int i = 0; i < N / 2; i++) {
			for (int j = i + 1; j < N; j++) {
				A += map[src[i]][src[j]] + map[src[j]][src[i]];

			}

		}
//		System.out.println("A : " + A);
		for (int i = 0; i < part.size(); i++) {
			for (int j = i + 1; j < part.size(); j++) {

				B += map[part.get(i)][part.get(j)] + map[part.get(j)][part.get(i)];

			}
		}

//		System.out.println("B : " + B);
//
//		System.out.println("==== taste ====");
		taste = Math.abs(A - B);
		answer = Math.min(answer, taste);

	}

	static void combi(int start, int cnt) {
		if (cnt == N / 2) {
//			System.out.println("==== combi ====");
//			for (int i = 0; i < N / 2; i++)
//				System.out.print(src[i] + " ");
//			System.out.println();
			check();
			return;
		}

		for (int i = start; i <= N; i++) {
			src[cnt] = i;
			combi(i + 1, cnt + 1);
			src[cnt] = 0;
		}
	}

}

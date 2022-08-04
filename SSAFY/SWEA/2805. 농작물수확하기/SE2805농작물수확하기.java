import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SE2805농작물수확하기 {
	static int T;
	static int N;
	static int arr[][];
	static int answer;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}

			int l = N / 2;
			int r = N / 2;

			for (int i = 0; i < N; i++) {

				for (int j = l; j <= r; j++) {
					answer += arr[i][j];
				}

				if (l == 0 && r == N - 1) {
					flag = true;
				}

				if (flag) {
					l++;
					r--;
				} else {
					l--;
					r++;
				}
			}
			System.out.println("#" + t + " " + answer);
			answer = 0;
			flag =false;

		}
	}

}

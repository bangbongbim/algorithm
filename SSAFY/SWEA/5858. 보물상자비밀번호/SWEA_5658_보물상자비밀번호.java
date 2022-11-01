import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_5658_보물상자비밀번호 {
	static int T;
	static int N, K;
	static char[] input;
	static TreeSet<Integer> list = new TreeSet<>(Collections.reverseOrder());

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			input = new char[N];
			input = br.readLine().toCharArray();
			list.clear();

			// 돌리는 횟수
			for (int i = 0; i < N / 4; i++) {
				rotate();
				setList();
			}
			Integer[] answer = list.toArray(new Integer[0]);

			System.out.println("#" + t + " " + answer[K - 1]);

		}

	}

	// 개수세어서 set에 넣음
	static void setList() {
		String str = "";
		for (int i = 0; i < N; i += N / 4) {
			for (int j = i; j < i + (N / 4); j++) {
				str += input[j];
			}
			list.add(Integer.parseInt(str, 16));
			str = "";
		}

	}

	// 시계방향 회전
	static void rotate() {
		char last = input[N - 1];
		for (int i = N - 1; i > 0; i--) {
			input[i] = input[i - 1];
		}
		input[0] = last;
	}

}

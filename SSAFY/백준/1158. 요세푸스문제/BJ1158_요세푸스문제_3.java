import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1158_요세푸스문제_3 {
	static int N, K;
	static int[] input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		input = new int[N + 1];
		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}

		int count = 0; // 죽은 사람이 결정되면 하나씩 증가 => 모두 죽으면 count == N
		int idx = 1; // 순회하는 index, 죽은 사람이 결정되면 그사람 input[idx] = 0
		int step = 1; // 1부터 증가, 살아있는 사람만 계산하기 위함

		sb.append("<");
		while (true) {
			// 기저 조건
			if (count == N)
				break;

			int newIdx = idx % N;
			if (input[newIdx] != 0) {// 살아있는
				if (step % K == 0) {
					sb.append(input[newIdx] + ", ");
					input[newIdx] = 0;
					count++;
				}
				step++;

			}
			idx++;
//			if (idx > N)
//				idx = 1;
		}

		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb.toString());

	}

}

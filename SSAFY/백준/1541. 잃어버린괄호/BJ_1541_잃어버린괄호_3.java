package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1541_잃어버린괄호_3 {
	// 2-34-56-79-9-10+11
	// 10+20-30+40
	// 55-50+40

	static int ans;
	static int sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), "-");

		int st_size = st.countTokens();
		for (int i = 0; i < st_size; i++) {
			String token = st.nextToken();

			StringTokenizer plusSt = new StringTokenizer(token, "+");

			int plus_size = plusSt.countTokens();
			for (int j = 0; j < plus_size; j++) {
				sum += Integer.parseInt(plusSt.nextToken());
			}

			if (i == 0)
				ans = sum;
			else
				ans -= sum;

			sum = 0;

		}

		System.out.println(ans);

	}

}

package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1541_잃어버린괄호_2 {
	// 2-34-56-79-9-10+11
	// 10+20-30+40

	static int sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stMinus = new StringTokenizer(br.readLine(), "-");

		int sizeMinus = stMinus.countTokens(); // 현재 시점에 남아있는 토큰 수

		for (int i = 0; i < sizeMinus; i++) {
			String token = stMinus.nextToken();

			int num = 0;
			StringTokenizer stPlus = new StringTokenizer(token, "+");

			int sizePlus = stPlus.countTokens();

			for (int j = 0; j < sizePlus; j++) {
				num += Integer.parseInt(stPlus.nextToken());
			}

			if (i == 0)
				sum = num; // 맨 앞 숫자

			else
				sum -= num;
		}

		System.out.println(sum);
	}

}

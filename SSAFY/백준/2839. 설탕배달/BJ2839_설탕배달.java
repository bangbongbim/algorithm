import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2839_설탕배달 {
	// 3 ,5
	static int N;
	static int answer;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		min = 5000;

		comb(0, 0);

		min = min == 5000 ? -1 : min;

		System.out.println(min);
	}

	static void comb(int five, int three) {
		int sum = five * 5 + three * 3;

		if (sum == N) { // 2 종류의 봉투로 Nkg을 만들었다.
			min = Math.min(min, five + three);
			return;
		}

		if (sum > N) {
			return;
		}

		comb(five + 1, three);
		comb(five, three + 1);
	}
}

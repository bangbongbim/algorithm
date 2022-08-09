package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12891_DNA비밀번호_2 {

	static int S, P, ans;
	static char[] dna;
	static int minA, minC, minG, minT, cntA, cntC, cntG, cntT;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dna = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());

		minA = Integer.parseInt(st.nextToken());
		minC = Integer.parseInt(st.nextToken());
		minG = Integer.parseInt(st.nextToken());
		minT = Integer.parseInt(st.nextToken());

		solve();
		System.out.println(ans);

	}

	static void solve() {
		// 처음 시작 P 개의 부분 문자열부터 확인

		for (int i = 0; i < P; i++) {
			switch (dna[i]) {
			case 'A':
				cntA++;
				break;
			case 'C':
				cntC++;
				break;
			case 'G':
				cntG++;
				break;
			case 'T':
				cntT++;
				break;
			}
		}

		// 시작 P에 대해서 확인
		check();
		for (int i = P; i < S; i++) {
			// 하나는 버리고 새로 하나를 취한다.
			// 버리는건 맨압
			// 취하는 건 맨 뒤
			// dna[i-P];

			switch (dna[i - P]) { // 부분문자열의 맨 앞 (버릴 것)
			case 'A':
				cntA--;
				break;
			case 'C':
				cntC--;
				break;
			case 'G':
				cntG--;
				break;
			case 'T':
				cntT--;
				break;
			}

			switch (dna[i]) { // 새 것
			case 'A':
				cntA++;
				break;
			case 'C':
				cntC++;
				break;
			case 'G':
				cntG++;
				break;
			case 'T':
				cntT++;
				break;
			}
		}
	}

	// 부분 문자열이 조건에 맞는지 확인
	static void check() {

		if (cntA >= minA && cntC >= minC && cntG >= minG && cntT >= minT) {
			ans++;
		}
	}
}

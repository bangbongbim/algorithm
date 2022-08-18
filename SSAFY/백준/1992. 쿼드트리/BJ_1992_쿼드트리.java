import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1992_쿼드트리 {

	static int N;
	static int[][] map;
	static String answer = "";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';

			}
		}

		quad(0, 0, N);

		System.out.println(answer);

	}

	static void quad(int y, int x, int size) {
		if (!check(y, x, size)) { // 같은 숫자로만 구성이 되어 있는지 체크
			answer += "(";
			quad(y, x, size / 2);
			quad(y, x + size / 2, size / 2);
			quad(y + size / 2, x, size / 2);
			quad(y + size / 2, x + size / 2, size / 2);
			answer+=")";
		} else {
			if (map[y][x] == 1) // 같은 숫자로만 구성될 경우 어느곳을 택해도 같움띠
				answer += 1;
			else
				answer += 0;
			
			return;
		}

	}

	static boolean check(int y, int x, int size) {
		int num = map[y][x];
		for (int i = y; i < y + size; i++) {
			for (int j = x; j <= x + size - 1; j++) {
				if (map[i][j] != num) {

					return false;
				}

			}
		}
		return true;
	}

}

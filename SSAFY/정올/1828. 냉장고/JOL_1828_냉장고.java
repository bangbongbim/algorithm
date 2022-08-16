
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class JOL_1828_냉장고 {
	static int N;

	static List<Temp> list = new ArrayList<>();
	static Temp t;
	static int answer = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			list.add(new Temp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list);
		t = new Temp(list.get(0).x, list.get(0).y);

		for (int i = 1; i < list.size(); i++) {
			if (t.y < list.get(i).x) {
				t.y = list.get(i).y;
				answer++;
			}
		}

		System.out.println(answer);
	}

	static class Temp implements Comparable<Temp> {
		int x;
		int y;

		public Temp(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Temp o) {
			return this.y - o.y;
		}
	}

}
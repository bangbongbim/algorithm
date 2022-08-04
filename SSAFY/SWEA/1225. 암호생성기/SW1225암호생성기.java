import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW1225암호생성기 {

	static int T;
	static Queue<Integer> q = new LinkedList<>();
	static int m = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine());

			String str[] = br.readLine().split(" ");
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(str[i]));
			}

			// 빼기
			m = 1;
			while (true) {
				int front = q.poll(); // 앞에 꺼 뽑음

				front -= m;  // 앞에꺼 -
				if (front <= 0) { // 뻰 값이 0 보다 작으면 뒤에 0추가하고 break;
					q.offer(0);
					break;
				} else {
					q.offer(front); // 0 보다 크면 뒤에 추가하고 m++
					m++;
				}

				if (m > 5) // m이 5보다 크면 1로 바꿈
					m = 1;

			}

			System.out.print("#" + t + " ");

			while (!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();

		}

	}

}

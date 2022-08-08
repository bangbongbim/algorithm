import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ1158요세푸스문제 {
	static int N, K;
	static Queue<Integer> q = new ArrayDeque<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		String str[] = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);

		for (int i = 1; i <= N; i++)
			q.offer(i);

		int cnt = 1;
		sb.append("<");
		while (!(q.size()==1)) {

			if (cnt != K) {
				q.offer(q.poll());
		
			} else {
				sb.append(q.poll() + ", ");
				cnt  = 1;
				continue;
			}
			cnt++;
		}
		sb.append(q.poll()+">");
		
		System.out.println(sb.toString());
	}

}

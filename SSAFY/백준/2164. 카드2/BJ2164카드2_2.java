package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ2164카드2_2 {
	static int N;
	static Deque<Integer> deque = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			deque.add(i);// addLast();
		}

		while (deque.size() > 1) {
			deque.remove(); // removeFirst();
			deque.add(deque.remove());
		}
		
		System.out.println(deque.getLast());
	}

}

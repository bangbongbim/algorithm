package basic;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BJ2164카드2 {

	static Queue<Integer> q = new ArrayDeque<Integer>();
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}

		while (q.size() != 1) {
			int a = q.poll();
			int b = q.poll();

			q.offer(b);
		}
		
		System.out.println(q.poll());

	}

}

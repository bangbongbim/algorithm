package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1247_최적경로 {
	static int T, N;
	static Node home, office = new Node();
	static List<Node> client = new ArrayList<>();
	static List<Node> p = new ArrayList<>();
	static boolean[] selected;
	static int y, x;
	static int answer = Integer.MAX_VALUE;
	static int dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			selected = new boolean[N + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			office = new Node(y, x);

			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			home = new Node(y, x);
			for (int i = 0; i < N; i++) {
				y = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());

				client.add(new Node(y, x));
			}
			perm(0);
		}
	}

	static void perm(int cnt) {
		if (cnt == N) {
			Node temp = new Node(Math.abs(office.y - p.get(0).y), Math.abs(office.x - p.get(0).x));
			for (int i = 1; i < N; i++) {
				temp.x = Math.abs(temp.x - p.get(i).x);
				temp.y = Math.abs(temp.y - p.get(i).y);
			}

			dist = Math.abs(temp.x - home.x) + Math.abs(temp.y - home.y);
			System.out.println(dist);
			answer = Math.min(answer, dist);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (selected[i])
				continue;
			selected[i] = true;
			p.add(new Node(client.get(i).y, client.get(i).x));
			perm(cnt + 1);
			p.remove(p.size() - 1);
			selected[i] = false;
		}

	}

	static class Node {
		int y;
		int x;

		Node() {
		};

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}

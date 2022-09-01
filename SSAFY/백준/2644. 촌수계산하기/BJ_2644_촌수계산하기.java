package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2644_촌수계산하기 {
	static int N;
	static boolean[] visited;
	static int parent, child;
	static int m;
	static List<Integer>[] family;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];

		family = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			family[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		parent = Integer.parseInt(st.nextToken());
		child = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			family[p].add(c);
			family[c].add(p);

		}
		visited[parent] = true;
		dfs(parent, 1);
		if (answer != 0)
			System.out.println(answer);
		else
			System.out.println(-1);
	}

	static void dfs(int start, int cnt) {

		for (int i = 0; i < family[start].size(); i++) {
			if (family[start].get(i) == child) {
				answer = cnt;
				return;
			}

		}
		for (int i = 0; i < family[start].size(); i++) {
			int next = family[start].get(i);

			if (!visited[next]) {
				visited[next] = true;
				dfs(next, cnt + 1);

			}
		}

	}

}

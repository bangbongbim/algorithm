package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_13023_ABCDE {
	static int N, M;
	static ArrayList<Integer>[] graph;
	static boolean visited[];
	static int depth;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];

		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = (new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from].add(to);
		}

		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i);
		}

		check();

		System.out.println(answer);

	}

	static void dfs(int x) {
		if (depth == M + 1) {
			return;
		}

		for (int i = 0; i < N; i++) {
			int next = graph[x].get(i);
			if (!visited[next]) {
				depth++;
				visited[next] = true;
				dfs(next);
			}
		}

	}

	static int check() {
		for (int i = 0; i < N; i++) {
			if (!visited[i])
				return 0;
		}
		return 1;
	}

}

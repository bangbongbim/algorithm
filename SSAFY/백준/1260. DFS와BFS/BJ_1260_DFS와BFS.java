import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {

	static int N, M, V;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from].add(to);
			graph[to].add(from);

		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		sb.append(V+" ");
		dfs(V);
		sb.append("\n");
		Arrays.fill(visited, false);
		sb.append(V+" ");
		bfs(V);
		
		System.out.println(sb.toString());
	}

	static void dfs(int v) {
		visited[v] = true;

		for (int i = 0; i < graph[v].size(); i++) {
			int next = graph[v].get(i);
			if (visited[next]) {
				continue;
			}
			sb.append(next+" ");
			dfs(next);
		}

	}

	static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		visited[v]=true;

		q.offer(v);

		while (!q.isEmpty()) {
			int top = q.poll();

			for (int i = 0; i < graph[top].size(); i++) {
				int next = graph[top].get(i);
				if (visited[next]) {
					continue;
				}
				sb.append(next+" ");
				visited[next] =true;
				q.offer(next);
			}
		}

	}

}

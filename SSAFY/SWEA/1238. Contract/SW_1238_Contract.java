import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1238_Contract {
	static int T = 10;
	static int N, start;
	static String input;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int answer;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			graph = new ArrayList[101];
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			visited = new boolean[101];

			for (int i = 1; i <= 100; i++) {
				graph[i] = (new ArrayList<Integer>());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 4; i++) {
				for (int j = 0; j < 2; j++) {
					int from = Integer.parseInt(st.nextToken());
					int to = Integer.parseInt(st.nextToken());

					graph[from].add(to);
				}

			}

			bfs(start);
			System.out.println("#"+t+" "+answer);
		}
	}

	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();

		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int q_size = q.size();
			list.clear();
			for (int size = 0; size < q_size; size++) {
				int top = q.poll();

				for (int i = 0; i < graph[top].size(); i++) {
					int next = graph[top].get(i);
					if (!visited[next]) {
						list.add(next);
						visited[next] = true;
						q.offer(next);
					}
				}
			}
			if(!list.isEmpty()) {
				Collections.sort(list);
				answer = Collections.max(list);
			}
		
		}
	}

}

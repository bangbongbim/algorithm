package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_3124_최소스패닝트리_3 {
	static int T, V, E;
	static long sum;
	static ArrayList<ArrayList<Edge>> vertex; // 인접 리스트
	static boolean[] visit; // 정점 방문 체크

	// 현재 고려 대상인 정점(간선) 중 비용이 가장 작은 것을 리턴
	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
	// visit 없음.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			vertex = new ArrayList<ArrayList<Edge>>();

			for (int i = 0; i <= V; i++) {
				vertex.add(new ArrayList<Edge>());
			}

			visit = new boolean[V + 1];
			// 초기화
			sum = 0;

			pqueue.clear();

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				vertex.get(v1).add(new Edge(v2, c));
				vertex.get(v2).add(new Edge(v1, c));

			}

			// 프림시작
			prim();

			System.out.println("#" + t + " " + sum);
		}
	}

	static void prim() {
		// 시작 정점
		// 1번 정점부터
		int cnt = 1;
		visit[1] = true;

		pqueue.addAll(vertex.get(1)); // 시장 정점 (1번 ) 에서 갈 수 있는 모든 정점을 pq애 담는다

		while (!pqueue.isEmpty()) {
			Edge edge = pqueue.poll();
			if (visit[edge.v])
				continue; // 새로 최소비용으로 연결혀는 정정이 이미 방문한 정점이면 버림

			// 새로운 정점을 연결(방문)

			visit[edge.v] = true;
			sum += edge.c;// 새로 방문하는 정점으로 가능 비용 누적
			cnt++;

			if (cnt == V)
				break; // 필요한 모든 정점을 다 연결(방문)

			pqueue.addAll(vertex.get(edge.v));
		}
	}

	static class Edge {
		int v, c;

		public Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

}
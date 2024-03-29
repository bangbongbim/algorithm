package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 부분 집합
// 인접 행렬
// 연결 여부 => DFS
public class BJ_17471_게리맨더링2 {
	static int N, min;
	static int[][] matrix;
	static boolean[] select; // subset
	static boolean[] visit; // bfs - 연결확인
	static Queue<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		matrix = new int[N + 1][N + 1]; // 0 dummy <= 인구수 저장해서 활용
		select = new boolean[N + 1];
		visit = new boolean[N + 1];

		min = Integer.MAX_VALUE;

		// 구역별 인구수
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken()); // 인구수
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // i 구역에 인접한 구역의 수
			for (int j = 1; j <= n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		subset(1);

		if (min == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(min);

	}

	static void check() {
		// 2개의 선거구에 포함된 구역들이 모드 연결
		// 적어도 1개의 구역을 포함하는지

		// 초기화
		Arrays.fill(visit, false);
		queue.clear();

		// A
		for (int i = 1; i <= N; i++) {
			if (select[i]) {
				visit[i] = true;
				queue.offer(i);
				break;
			}
		}

		if (queue.size() == 0)
			return;

		// 방문할 수 있는 곳을 방분하고 visit 체크
		while (!queue.isEmpty()) {
			int v = queue.poll();

			for (int i = 1; i <= N; i++) {
				int adj = matrix[v][i];
				// 연결되어있고, 아직 방문하지 않았고, A그룹에 속하는
				if (adj != 0 && !visit[adj] && select[adj]) {
					visit[adj] = true; // 연결된 정점이 true 로 표시된다.
					queue.offer(adj);
				}
			}

		}
		// B
		for (int i = 1; i <= N; i++) {
			if (select[i]) {
				visit[i] = true;
				queue.offer(i);
				break;
			}
		}
		// 방문할 수 있는 곳을 방분하고 visit 체크
		while (!queue.isEmpty()) {
			int v = queue.poll();

			for (int i = 1; i <= N; i++) {
				int adj = matrix[v][i];
				// 연결되어있고, 아직 방문하지 않았고, A그룹에 속하는
				if (adj != 0 && !visit[adj] && !select[adj]) {
					visit[adj] = true; // 연결된 정점이 true 로 표시된다.
					queue.offer(adj);
				}
			}

		}

		// 모두 방문할 수 있는 지 확인
		boolean visitAll = true;
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				visitAll = false;
				break;
			}
		}

		// 모두 방문할 수 있다
		// A, B 각각의 인구수 계산하고 차이를 min에 반영
		// 각 구역의 인구수는 matrix[v][0]
		if (visitAll) {
			int sumA = 0;
			int sumB = 0;

			for (int i = 1; i <= N; i++) {
				if (select[i])
					sumA += matrix[i][0];
				else
					sumB += sumB += matrix[i][0];
			}

			min = Math.abs(sumA - sumB);
		}

	}

	// select[]에 표시를함
	static void subset(int srcIdx) {
		if (srcIdx == N + 1) {
			// 기저 조건
			// 두개의 선거구로 나눴다.
			check();
			return;
		}

		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);

	}

}

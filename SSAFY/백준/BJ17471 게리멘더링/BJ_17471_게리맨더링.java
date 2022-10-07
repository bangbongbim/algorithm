package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_17471_게리맨더링 {
	static int N;
	static int[] people;
	static List<Integer>[] src;
	static boolean[] visited;
	static boolean[] select;
	static int a_sum, b_sum;
	static int min;
	static int answer = Integer.MAX_VALUE;

	static int areaCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		people = new int[N + 1];
		src = new ArrayList[N + 1];
		select = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			src[i] = new ArrayList<Integer>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			areaCnt = Integer.parseInt(st.nextToken());

			for (int j = 1; j <= areaCnt; j++) {
				int n = Integer.parseInt(st.nextToken());
				// 양방향
				src[i].add(n);
			}
		}

		subset(1);
		if (answer == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(answer);

	}

	static boolean checkAllSelect() {
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (select[i])
				cnt++;
		}

		if (cnt == N)
			return true;
		else
			return false;
	}

	static void dfs(int start, boolean flag) {
		for (int i = 0; i < src[start].size(); i++) {
			int next = src[start].get(i);
			if (visited[next] || select[next] == flag || next == 0)
				continue;
			visited[next] = true;
			dfs(next, flag);
		}

	}

	static void calcAreaSum(char ch) {
		for (int i = 1; i <= N; i++) {
			if (visited[i] ) {
				if (ch == 'A' && select[i])
					a_sum += people[i];
				else if (ch == 'B' && !select[i])
					b_sum += people[i];
			}
		}
	}

	// 적어도 하나의 지역은 뽑혀야함
	// 모두연결되어있어야함

	static boolean cheekcAllConnected() {
		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

	static void subset(int srcIdx) {
		if (srcIdx == N + 1) {
			// 한곳에 몰빵된 경우
			if (checkAllSelect())
				return;
			// A
			a_sum = 0;
			b_sum = 0;
			visited = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				if (select[i] && !visited[i]) {
					visited[i] = true;
					dfs(i, false);
					calcAreaSum('A');
					break;
				}
			}

			// B
			for (int i = 1; i <= N; i++) {
				if (!select[i] && !visited[i]) {
					visited[i] = true;
					dfs(i, true);
					calcAreaSum('B');
					break;
				}
			}

			// 모든 정점을 방문 했을때에만 계산을 함
			if (cheekcAllConnected()) {
				// 한곳이라도 방문한 것에만 더하기
				min = Math.abs(a_sum - b_sum);
				answer = Math.min(answer, min);
			}

			return;

		}

		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);

	}

}

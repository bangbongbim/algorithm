package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1 {
	static int N;
	static int[][] map;
	static int answer;

	static Queue<PipeInfo> q = new ArrayDeque<>();

	// 가로 세로 대각선
	// 1 2 3

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q.offer(new PipeInfo(1, 2, 1));

		while (!q.isEmpty()) {
			PipeInfo pipe = q.poll();

			if (pipe.y == N && pipe.x == N) {
				answer++;
				continue;
			}
		
			if (map[pipe.y][pipe.x] == 1)
				continue;

			if (pipe.position == 1) {
				if (pipe.x + 1 <= N) {
					q.offer(new PipeInfo(pipe.y, pipe.x + 1, 1));
				}
				if (pipe.y + 1 <= N && pipe.x + 1 <= N) {
					q.offer(new PipeInfo(pipe.y + 1, pipe.x + 1, 3));
				}

			} else if (pipe.position == 2) {
				if (pipe.y + 1 <= N) {
					q.offer(new PipeInfo(pipe.y + 1, pipe.x, 2));
				}
				if (pipe.y + 1 <= N && pipe.x + 1 <= N) {
					q.offer(new PipeInfo(pipe.y + 1, pipe.x + 1, 3));
				}

			} else if (pipe.position == 3) {
				if (pipe.x + 1 <= N) {
					q.offer(new PipeInfo(pipe.y, pipe.x + 1, 1));
				}
				if (pipe.y + 1 <= N) {
					q.offer(new PipeInfo(pipe.y + 1, pipe.x, 2));
				}
				if (pipe.y + 1 <= N && pipe.x + 1 <= N) {
					q.offer(new PipeInfo(pipe.y + 1, pipe.x + 1, 3));
				}

			}
		}

		System.out.println(answer);

	}

	static class PipeInfo {
		int y;
		int x;
		int position;

		public PipeInfo(int y, int x, int poistion) {
			this.y = y;
			this.x = x;
			this.position = poistion;
		}
	}

}

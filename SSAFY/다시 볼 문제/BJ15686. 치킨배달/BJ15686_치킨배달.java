//package algorithm_basic;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BJ15686_치킨배달 {
//	static int N, M;
//	static int map[][];
//	static List<Position> c_p = new ArrayList<>();
//	static boolean[] visited;
//	static Position[] p;
//	static int answer = Integer.MAX_VALUE;
//	static int sum;
//
//	static int[] dy = { -1, 1, 0, 0 };
//	static int[] dx = { 0, 0, -1, 1 };
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//
//		map = new int[N + 1][N + 1];
//		for (int i = 1; i <= N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 1; j <= N; j++) {
//				int p = Integer.parseInt(st.nextToken());
//
//				if (p == 2) {
//					c_p.add(new Position(i, j));
//					map[i][j] = 0;
//				} else
//					map[i][j] = p;
//
//			}
//
//		}
//		p = new Position[M];
//		visited = new boolean[c_p.size()];
//
//		ncr(0, 0);
//
//	}
//
//	static class Position {
//		int y;
//		int x;
//
//		Position(int y, int x) {
//			this.y = y;
//			this.x = x;
//		}
//
//		@Override
//		public String toString() {
//			return "Position [y=" + y + ", x=" + x + "]";
//		}
//
//	}
//
//	static void ncr(int start, int cnt) {
//		if (cnt == M) {
//			int y = 0;
//			int x = 0;
//			for (int i = 0; i < M; i++) {
//				y = p[i].y;
//				x = p[i].x;
//				map[y][x] = 2;
//			}
//			
////			for(int y = 1; y<=N;y++) {
////				for(int x =1)
//			}
//
//			bfs(1, 1);
//			return;
//		}
//
//		for (int i = start; i < c_p.size(); i++) {
//			visited[i] = true;
//			p[cnt] = c_p.get(i);
//			ncr(i + 1, cnt + 1);
//			p[cnt] = c_p.get(i);
//			visited[i] = false;
//
//		}
//
//	}
//
//	static void bfs(int y, int x) {
//		Queue<Position> q = new ArrayDeque<>();
//
//		q.offer(new Position(y, x));
//
//		while (!q.isEmpty()) {
//			Position p = q.poll();
//
//			System.out.println(p);
//
//			for (int d = 0; d < 4; d++) {
//				int ny = p.y + dy[d];
//				int nx = p.x + dx[d];
//
//				if (ny < 1 || nx < 1 || ny >= 7 || nx >= 7)
//					continue;
//
//				if (map[ny][nx] == 2) {
//					sum += Math.abs(p.y - ny) + Math.abs(p.x - nx);
//				}
//			}
//
//		}
//
//	}
//
//}

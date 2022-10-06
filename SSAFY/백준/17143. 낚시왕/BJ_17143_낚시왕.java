import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_17143_낚시왕 {

	static int R, C, M;
	static Shark[][] map;
	static int r, c, s, d, z;
	static FisherMan fisherMan;
	static List<Shark> sharkList = new ArrayList<>();
	static List<Shark> afterSharkList = new ArrayList<>();
	static int answer;
	// 1: 위 , 2: 아래 ,3: 오른쪽, 4: 왼쪽
	static int dy[] = { 0, -1, 1, 0, 0 };
	static int dx[] = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new Shark[R + 1][C + 1];
		fisherMan = new FisherMan(1, 0, 0);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());

			map[r][c] = new Shark(r, c, s, d, z);
		}
//		System.out.println("==== 처음 fiserMan ==== ");
//		System.out.println("r : " + fisherMan.r + " , c : " + fisherMan.c);
//		System.out.println("==== map ====");
//		for (int i = 1; i <= R; i++) {
//			for (int j = 1; j <= C; j++) {
//				if (map[i][j] == null)
//					System.out.print("0 ");
//				else
//					System.out.print("1 ");
//			}
//			System.out.println();
//
//		}
		// 낚시왕이 오른쪽으로 한칸씩 이동
		while (true) {
			fisherMan.c++;
			if (fisherMan.c > C)
				break;
//			System.out.println("==== fiserMan 이동 ==== ");
//			System.out.println("r : " + fisherMan.r + " , c : " + fisherMan.c);

			// 열에서 가장 가까운 상어 잡음
			huntShark();
//			System.out.println("==== answer ====");
//			System.out.println(answer);
			// 상어 이동
			moveShark();
			// 상어 이동 후 재배치 하기위해 map 초기화
			resetMap();
//			System.out.println("====" + fisherMan.c + "초 후" + "====");
//			for (int i = 0; i < afterSharkList.size(); i++)
//				System.out.println(afterSharkList.get(i));
			// 이동하고 난 후의 상어의 위치를 기반으로 map재배치
			arrangeShark();
			sharkList.clear();
			afterSharkList.clear();
		}
		System.out.println(answer);

	}

	static void resetMap() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = null;
			}
		}
	}

	static void arrangeShark() {
		for (Shark temp : afterSharkList) {
			if (map[temp.r][temp.c] == null) {
				map[temp.r][temp.c] = temp;
			} else {
				if (map[temp.r][temp.c].z < temp.z) {
					map[temp.r][temp.c] = temp;
				}
			}
		}

	}

	static void dfs(int r, int c, int s, int d, int z) {
		int new_s = 0;
		int ny = r;
		int nx = c;
		if (d == 2 || d == 1) {
			// s=2 R=4 d=2
			new_s = s % (R * 2 - 2);

			for (int i = 0; i < new_s; i++) {
				if (ny == 1)
					d = 2;
				else if (ny == R)
					d = 1;

				ny += dy[d];

			}

		} else if (d == 4 || d == 3) {
			new_s = s % (C * 2 - 2);

			for (int i = 0; i < new_s; i++) {

				if (nx == 1)
					d = 3;
				else if (nx == C)
					d = 4;
				nx += dx[d];

			}
		}
		afterSharkList.add(new Shark(ny, nx, s, d, z));

	}

	static void setSharkList() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] != null) {
					Shark s = map[i][j];
					sharkList.add(new Shark(s.r, s.c, s.s, s.d, s.z));
				}
			}
		}
	}

	static void moveShark() {
		setSharkList();
		for (int i = 0; i < sharkList.size(); i++) {
//			System.out.println("==== before shark ====");
//			System.out.println(sharkList.get(i).toString());

			Shark shark = sharkList.get(i);

			// 상어 한마리씩 이동
			dfs(shark.r, shark.c, shark.s, shark.d, shark.z);
		}

	}

	static void huntShark() {
		int c = fisherMan.c;
		for (int i = 1; i <= R; i++) {
			if (map[i][c] != null) {
				// 열에서 가장 가까운 상어 사냥
				answer += map[i][c].z;
				// 상어를 없앰
				map[i][c] = null;
				return;
			}
		}

	}

	static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}

	static class FisherMan {
		int r;
		int c;
		int sum;

		public FisherMan(int r, int c, int sum) {
			this.r = r;
			this.c = c;
			this.sum = sum;
		}
	}

}

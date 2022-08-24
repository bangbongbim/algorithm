package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_16236_아기상어 {
	static int N;
	static int[][] map;
	static int shark_size = 2, beit_cnt;
	static Node start;
	static List<Node> fish = new ArrayList<>();
	static int distance;
	static int answer;

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

		while (true) {

			// 상어의 위치 구함
			start = getStartShark();

			// 먹을 수 있는 물고기 리스트 구함
			setFishList();

			if (fish.isEmpty())
				System.out.println(0);
			// 먹을 수 있는 물고기가 한마리면 바로 이동
			else if (fish.size() == 1) {
				Node end = fish.get(0);
				distance = Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
				// 먹은 물고기 카운트 ++
				beit_cnt++;
				// 시간 카운트 ++
				answer++;
				// 상어의 위치 업데이트
				map[end.y][end.x] = 9;
				map[start.y][start.x] = 9;
			} else if (fish.size() > 1) {
				setFishDistance();
			}

			if (beit_cnt == shark_size) {
				shark_size++;
				beit_cnt = 0;
			}

		}

	}

	static void setFishDistance() {
		for (Node node : fish) {
			node.distance = Math.abs(start.x - node.x) + Math.abs(start.y - node.y);
		}
		// 거리가 가까운 물고기가 많다면 -> 가장 위의 물고기
		Collections.sort(fish, (o1, o2) -> {
			return o1.distance == o2.distance ? o1.y - o2.y : o1.distance - o2.distance;
		});

	}

	static void setFishList() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] < shark_size && map[i][j] != 0) {
					fish.add(new Node(i, j));
				}
			}
		}
	}

	static Node getStartShark() {

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 9) {
					return new Node(i, j);
				}
			}
		}
		return new Node(0, 0);
	}

	static class Node {
		int y;
		int x;
		int distance;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}

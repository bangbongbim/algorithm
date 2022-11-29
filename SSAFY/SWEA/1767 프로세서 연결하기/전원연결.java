package A형찐막찐막;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author dkdpd
 *
 *         가생이에 있는것 제외 cell의 개수 depth prunning 연결 안될때 depth+1,
 * 
 */
public class 전원연결2 {
	static int T;
	static int N;
	static int map[][];
	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 };
	static int maxCore; // 최대한 많은 코어에 전원연결
	static int minLen; // 최소 전선의 길이 합
	// 바운더리 프로세서 셀정보 클래스 행,렬

	static class Cell {
		int r;
		int c;

		public Cell(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int AllCellButBoundary;
	// 바운더리 프로세서 정보저장
	static ArrayList<Cell> cells;

	public static void main(String[] args) {

		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = scann.nextInt();
			map = new int[N][N]; // N x N
			cells = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = scann.nextInt();
					// 바운더리 위치의 프로세서를 제외하고 저장
					if (!(i == 0 || j == 0 || i == N - 1 || j == N - 1) && map[i][j] == 1) {
						cells.add(new Cell(i, j));
					}
				}
			}
			// 읽기끝 로직시작
			// 변수 초기화
			maxCore = Integer.MIN_VALUE / 1000; // 프로세서 관여수
			minLen = Integer.MAX_VALUE / 1000; // 전선길이
			AllCellButBoundary = cells.size();
			// 최악의 경우는 (4방)^12(프로세서수 AllCellButBoundary)
			// 프로세서개수-바운더리 프로세서수 만큼의 깊이만큼 반복 -> dfs 깊이
			dfs(0, 0, 0); // dfs(깊이, 프로세서 관여수 ,전선길이)
			System.out.println("#" + tc + " " + minLen);
		}
	}

	private static void dfs(int depth, int coreSum, int lineSum) {
		// base condition
		if (depth == cells.size()) {
			if (maxCore < coreSum) {
				maxCore = coreSum;
				minLen = lineSum;
			} else if (maxCore == coreSum) {
				if (minLen > lineSum)
					minLen = lineSum;
			}
			return;
		}

		Cell cell = cells.get(depth);

		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			int oR = cell.r;
			int oC = cell.c;
			int nr = cell.r;
			int nc = cell.c;

			int count = 0;

			while (true) {
				// 한방향으로 계속 팜
				nr += dr[d];
				nc += dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					break;

				// 못가는 길이 나옴
				if (map[nr][nc] == 1) {
					count = 0;
					// 못가는 길이면 다음 인덱스 확인
					break;
				} else {
					// 갈 수 있는 길이라면 전선길이 늘려줌
					count++;
				}
			}

			// count 만큼 전선 칠함
			for (int i = 0; i < count; i++) {
				oR += dr[d];
				oC += dc[d];
				map[oR][oC] = 1;
			}

			// 전원을 연결할 수 없는 경우
			if (count == 0) {
				dfs(depth + 1, coreSum, lineSum);
			}
			// 전원을 연결할 수 있는 경우
			else {
				// 현재의 전선을 칠한 것으로 다음 프로세스 진행
				dfs(depth + 1, coreSum + 1, lineSum + count);

				// 이 경우를 봤으면 다시 돌려줌
				oR = cell.r;
				oC = cell.c;
				for (int i = 0; i < count; i++) {
					oR += dr[d];
					oC += dc[d];
					map[oR][oC] = 0;
				}

			}

		}

	}
}

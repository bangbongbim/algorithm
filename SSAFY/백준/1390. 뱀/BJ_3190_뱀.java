
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 뱀은 맨위 맨좌측 시작, 길이는 1 시작, 방향은 오른쪽 방향 바라 뱀은 벽 또는 자기 자신의 몸과 부딪히면 게임이 끝남. 뱀의 몸통
 * Queue로 관리 ? direction L => 왼쪽으로 회전 direction D => 오른쪽
 */

public class BJ_3190_뱀 {
	// 필수 입력
	static int N;
	static int[][] map;
	static int apple_cnt;
	static int appleY, appleX;
	static int direction_cnt;
	static int maxTime;
	static char direction;
	static int answer;

	// 추가 정보
	static Deque<Position> snake = new ArrayDeque<>();
	static int d = 1;// 처음에는 오른쪽을 바라보고 있음
	static boolean[][] visited;
	static int snakeY, snakeX;
	static List<TimeInfo> timeList = new ArrayList<>();
	// 상 우 하 좌
	static int dy[] = { -1, 0, 1, 0 };
	static int dx[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		apple_cnt = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];

		// 처음 뱀의 머리 위치 저장
		snake.addFirst(new Position(1, 1));

		// 사과의 위치 저장
		for (int i = 0; i < apple_cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			appleY = Integer.parseInt(st.nextToken());
			appleX = Integer.parseInt(st.nextToken());

			map[appleY][appleX] = 1;
		}

		// 시간 정보
		direction_cnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < direction_cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			timeList.add(new TimeInfo(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
		}

		// 뱀 이동
		while (true) {
			// 시간 증가

			for (TimeInfo t : timeList) {
				if (t.time == answer) {
					d = changeDirection(t.direction);
					break;
				}
			}
			// 현재 방향으로 머리를 다음칸에 위치시킴
			Position head = snake.getLast();
			int ny = head.y + dy[d];
			int nx = head.x + dx[d];

			// 벽에 충돌하거나 자기 자신의 목과 부딪히면 게임이 끝남
			if (ny < 1 || nx < 1 || ny > N || nx > N || collideSnake(ny, nx)) {
				answer++;
				break;
			}

			snake.addLast(new Position(ny, nx));
			// 사과가 있다면
			if (map[ny][nx] == 1) {
				// 사과를 없애고 꼬리는 그대로
				map[ny][nx] = 0;
			} else {
				// 꼬리를 없애줌
				snake.pollFirst();

			}
			answer++;
		}

		System.out.println(answer);

	}

	static int changeDirection(char direction) {
		int temp = d;
		if (direction == 'L') {
			if (temp == 0)
				temp = 3;
			else
				temp--;

		} else if (direction == 'D') {
			if (temp == 3)
				temp = 0;
			else
				temp++;
		}

		return temp;
	}

	static boolean collideSnake(int ny, int nx) {
		for (Position p : snake) {
			if (p.y == ny && p.x == nx)
				return true;
		}
		return false;
	}

	static class Position {
		int y;
		int x;

		Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static class TimeInfo {
		int time;
		char direction;

		public TimeInfo(int time, char direction) {
			this.time = time;
			this.direction = direction;

		}

	}

}

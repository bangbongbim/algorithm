package basic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//.	평지(전차가 들어갈 수 있다.)
//*	벽돌로 만들어진 벽
//#	강철로 만들어진 벽
//-	물(전차는 들어갈 수 없다.)
//^	위쪽을 바라보는 전차(아래는 평지이다.)
//v	아래쪽을 바라보는 전차(아래는 평지이다.)
//<	왼쪽을 바라보는 전차(아래는 평지이다.)
//>	오른쪽을 바라보는 전차(아래는 평지이다.)

public class SE1873상호의배틀필드 {
	static int T, H, W;
	static char[][] map;
	char ch;
	static int N;
	static String operation;

	static int U[] = { -1, 0 };
	static int D[] = { 1, 0 };
	static int L[] = { 0, -1 };
	static int R[] = { 0, 1 };
	static int dy, dx;
	static int sy, sx; // 처음 전차 위치
	static int bullet_dy, bullet_dx; // 총알 날아가는 방향

	static void setTankPosition() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				char d = map[i][j];
				if (d == '^' || d == 'v' || d == '<' || d == '>') {
					sy = i;
					sx = j;
				}
			}
		}
	}

	static void setShootDirection() {
		switch (map[sy][sx]) {
		case '^':
			bullet_dy = U[0];
			bullet_dx = U[1];
			break;
		case 'v':
			bullet_dy = D[0];
			bullet_dx = D[1];
			break;
		case '<':
			bullet_dy = L[0];
			bullet_dx = L[1];
			break;
		case '>':
			bullet_dy = R[0];
			bullet_dx = R[1];
			break;
		default:
			break;
		}
	}

	static void shoot() {
		int ny = sy;
		int nx = sx;
		while (true) {
			ny += bullet_dy;
			nx += bullet_dx;

			if (ny < 0 || nx < 0 || ny >= H || nx >= W)
				break;

			if (map[ny][nx] == '*') {
				map[ny][nx] = '.';
				break;
			} else if (map[ny][nx] == '#')
				break;

		}
	}

	static void move(char direction) {
		int ny;
		int nx;
		switch (direction) {
		case 'U':
			dy = U[0];
			dx = U[1];
			ny = sy + dy;
			nx = sx + dx;

			if (ny >= 0 && ny < H && nx >= 0 && nx < W) {
				if (map[ny][nx] == '.') {
					map[sy][sx] = '.'; // 전차 아래 평지로 바꿈
					map[ny][nx] = '^'; // 현재 전차 위치 표시
					sy = ny; // 전차 위치 변경
					sx = nx; // 전차 위치 변경
				} else
					map[sy][sx] = '^'; // 현재 전차 위치 표시
			}
			else
				map[sy][sx] = '^'; // 현재 전차 위치 표시
			break;
		case 'D':
			dy = D[0];
			dx = D[1];
			ny = sy + dy;
			nx = sx + dx;

			if (ny >= 0 && ny < H && nx >= 0 && nx < W) {
				if (map[ny][nx] == '.') {
					map[sy][sx] = '.'; // 전차 아래 평지로 바꿈
					map[ny][nx] = 'v'; // 현재 전차 위치 표시
					sy = ny; // 전차 위치 변경
					sx = nx; // 전차 위치 변경
				} else
					map[sy][sx] = 'v'; // 현재 전차 위치 표시
			}
			else
				map[sy][sx] = 'v'; // 현재 전차 위치 표시
			break;
		case 'L':
			dy = L[0];
			dx = L[1];
			ny = sy + dy;
			nx = sx + dx;

			if (ny >= 0 && ny < H && nx >= 0 && nx < W) {
				if (map[ny][nx] == '.') {
					map[sy][sx] = '.'; // 전차 아래 평지로 바꿈
					map[ny][nx] = '<';
					sy = ny; // 전차 위치 변경
					sx = nx; // 전차 위치 변경
				} else
					map[sy][sx] = '<'; // 현재 전차 위치 표시
			}
			else
				map[sy][sx] = '<'; // 현재 전차 위치 표시
			break;
		case 'R':
			dy = R[0];
			dx = R[1];
			ny = sy + dy;
			nx = sx + dx;

			if (ny >= 0 && ny < H && nx >= 0 && nx < W) {
				if (map[ny][nx] == '.') {
					map[sy][sx] = '.'; // 전차 아래 평지로 바꿈
					map[ny][nx] = '>';
					sy = ny; // 전차 위치 변경
					sx = nx; // 전차 위치 변경
				} else
					map[sy][sx] = '>'; // 현재 전차 위치 표시
			}
			else
				map[sy][sx] = '>'; // 현재 전차 위치 표시
			break;

		default:
			break;
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn((new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);

				}
			}

			N = Integer.parseInt(br.readLine());
			operation = br.readLine();
			setTankPosition(); // 전차의 위치 설정 , sy sx

			for (int i = 0; i < operation.length(); i++) {
				if (operation.charAt(i) == 'S') {
					setShootDirection();
					shoot();
				} else {
					move(operation.charAt(i));
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}

	}
}

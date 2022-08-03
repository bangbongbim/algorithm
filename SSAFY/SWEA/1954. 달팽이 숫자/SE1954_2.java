package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 시계방향으로 이동  delta
public class SE1954_2 {
	static int T, N;
	static int[][] snail;
	// 시계 방향으로 이동 = delta : 순서가 있는
	// 우 - 하 - 좌 - 상
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    T = Integer.parseInt(br.readLine());

	    for (int t = 1; t <= T; t++) {
	        N = Integer.parseInt(br.readLine());
	        snail = new int[N][N];

	        // 시작 좌표, 방향
	        int y = 0;
	        int x = 0;
	        int d = 0; // 시작 방향 : 우 index

	        int num = 1; // 시작 숫자( 계속 1씩 증가)

	        // NxN만큼 반복하면서 숫자를 저장
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                snail[y][x] = num++; // 숫자를 저장
	                // 이동

	                // 현재 방향으로 이동하다가 더이상 못가면 다음 방향으로 전환
	                if (d == 0) {
	                    if (x + dx[d] >= N || snail[y][x + dx[d]] != 0)
	                        d = 1; // 하
	                } else if (d == 1) {
	                    if (y + dy[d] >= N || snail[y + dy[d]][x] != 0)
	                        d = 2; // 좌
	                } else if (d == 2) {
	                    if (x + dx[d] < 0 || snail[y][x + dx[d]] != 0)
	                        d = 3; // 상
	                } else if (d == 3) {
	                    if (y + dy[d] < 0 || snail[y + dy[d]][x] != 0)
	                        d = 0; // 우
	                }

	                // 위 조건에 해당 하지 않으면 d는 이전 d
	                // 해당하면 d 변경되었다.
	                x = x + dx[d];
	                y = y + dy[d];
	            }
	        }

	        System.out.println("#" + t);
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                System.out.print(snail[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
	}
	}

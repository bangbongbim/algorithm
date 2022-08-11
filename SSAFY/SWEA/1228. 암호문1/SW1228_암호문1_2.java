package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SW1228_암호문2 {
	static int N, M;
	static List<String> list = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			// 초기화
			list.clear();
			N = Integer.parseInt(br.readLine()); // 첫째 줄

			StringTokenizer st = new StringTokenizer(br.readLine()); // 둘째 줄
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}

			M = Integer.parseInt(br.readLine()); // 셋째 줄
			st = new StringTokenizer(br.readLine());// 넷째줄

			for (int i = 0; i < M; i++) {
				st.nextToken(); // I
				int x = Integer.parseInt(st.nextToken()); // x : index

				int y = Integer.parseInt(st.nextToken()); // y : 삽입할 문자열의 수

				// x의 위치에 y개만큼 넣어야함

				int count = x + y;
				for (int j = x; j < count; j++) {
					list.add(j, st.nextToken());
				}

			}

			// 출력 처음 10개만 출력
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
			System.out.println(sb);

		}


	}

}

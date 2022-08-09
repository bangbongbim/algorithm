package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW1228_암호문1 {
	static int N;
	static LinkedList<Integer> list = new LinkedList<>();
	static int oper_num;
	static int arr[];
	static String str;
	static int x, y;
	static int point;
	static LinkedList<Integer> input = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());

			// 원본 암호문 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			// 명령어의 개수
			oper_num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int op = 0; op < oper_num; op++) {
				str = st.nextToken();
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				for (int i = 0; i < y; i++) {
					input.add(Integer.parseInt(st.nextToken()));
				}

				for (int i = 0; i < input.size(); i++) {
					list.add(x+i, input.get(i));
				}
				input.clear();
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.println(list.get(i)+" ");
			}
			System.out.println();
			point = 0;
			list.clear();
			input.clear();

		}

	}

}

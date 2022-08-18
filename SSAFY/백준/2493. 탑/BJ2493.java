package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493 {
	static StringBuilder sb = new StringBuilder();
	static Stack<Top> stack = new Stack<>();
	static int N;
	static int rz;
	static int bigger;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			Top input = new Top(Integer.parseInt(st.nextToken()), i);

			if (stack.empty()) {
				sb.append("0 ");
			} else {
				while (!stack.empty()) {
					Top top = stack.peek();
					if (top.razer >= input.razer) {
						sb.append(top.num + " ");
						break;
					}
					stack.pop();
					
					if(stack.empty())
						sb.append("0 ");

				}
			}
			stack.push(input);

		}
		System.out.println(sb.toString());

	}

	static class Top {
		int razer;
		int num;

		public Top() {

		}

		public Top(int razer, int num) {
			this.razer = razer;
			this.num = num;
		}

		public int getRazer() {
			return razer;
		}

		public void setRazer(int razer) {
			this.razer = razer;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

	}

}

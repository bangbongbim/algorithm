import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

 class Main {

	static int t;
	static int cnt;
	static int sex, number;
	static ArrayList<Integer> arr = new ArrayList<>();

	static int switching(int s) {
		if (s == 0)
			return 1;
		else
			return 0;

	}

	static void sol(int sex, int number) {

		if (sex == 1) {
			for (int i = number - 1; i < arr.size(); i++) {
				if ((i + 1) % number == 0) {
					arr.set(i, switching(arr.get(i)));
				}
			}
		} else if (sex == 2) {
			int min = number - 1, max = number - 1;
			arr.set(number - 1, switching(arr.get(number - 1))); // 입력 받은 부분만 바꿈

			while (true) {
				min--;
				max++;
				if (min < 0 || max >= arr.size())
					break;

				if (arr.get(min) != arr.get(max))
					break;

				arr.set(min, switching(arr.get(min)));
				arr.set(max, switching(arr.get(max)));
			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		t = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < t; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}

		cnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			sex = Integer.parseInt(st.nextToken());
			number = Integer.parseInt(st.nextToken());

			sol(sex, number);
		}

		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
			if ((i + 1) % 20 == 0)
				System.out.println();
		}

	}

}
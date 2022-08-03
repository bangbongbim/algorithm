package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SE1208_Flattern {
	static int arr[];
	static int dumpCnt;
	static int height;
	static int minIdx = Integer.MAX_VALUE;
	static int maxIdx = Integer.MIN_VALUE;
	static boolean dumpCheck = false;

	static int getMinIdx() {
		int t_min = Integer.MAX_VALUE;
		int idx = 0;
		for (int i = 0; i < 100; i++) {
			if (t_min > arr[i]) {
				t_min = arr[i];
				idx = i;
			}
		}

		return idx;

	}

	static int getMaxIdx() {
		int t_max = Integer.MIN_VALUE;
		int idx = 0;
		for (int i = 0; i < 100; i++) {
			if (t_max < arr[i]) {
				t_max = arr[i];
				idx = i;
			}
		}

		return idx;

	}

	static void dump() {
		for (int i = 0; i < dumpCnt; i++) {
			maxIdx = getMaxIdx();
			minIdx = getMinIdx();

			arr[maxIdx]--;
			arr[minIdx]++;

			maxIdx = getMaxIdx();
			minIdx = getMinIdx();

			if ((arr[maxIdx] - arr[minIdx]) <= 1) {
				dumpCheck = true;
				return;
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			arr = new int[100];
			st = new StringTokenizer(br.readLine());
			dumpCnt = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dump();
			System.out.println("#" + tc + " " + (arr[maxIdx] - arr[minIdx]));

		}

	}

}

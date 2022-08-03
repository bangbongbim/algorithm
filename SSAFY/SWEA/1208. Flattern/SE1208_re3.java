
package basic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// ArrayList 사용 <= 

public class SE1208_re3 {

	static ArrayList<Integer> floor;
	static int dump, minIdx, maxIdx;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long start = System.nanoTime();

		for (int t = 1; t <= 10; t++) {
			dump = Integer.parseInt(br.readLine());
			floor = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				floor.add(Integer.parseInt(st.nextToken()));
			}

			minIdx = 0;
			maxIdx = 0;
			for (int i = 0; i < dump; i++) {
				// 최소, 최대의 index
				reset();

				// 최대, 최소 차이 비교
				int gap = floor.get(maxIdx) - floor.get(minIdx);
				if (gap == 0 || gap == 1)
					break;

				// 평탄화 작업
				floor.set(maxIdx, floor.get(maxIdx) - 1);
				floor.set(minIdx, floor.get(minIdx) + 1);
			}

			reset();
			int result = floor.get(maxIdx) - floor.get(minIdx);
			long end = System.nanoTime();
			System.out.println("duration : " + (end - start));
			System.out.println("#" + t + " " + result);

		}
	}

	static void reset() {
		for (int i = 0; i < 100; i++) {
			if (floor.get(i) < floor.get(minIdx))
				minIdx = i;
			if (floor.get(i) > floor.get(maxIdx))
				maxIdx = i;
		}
	}

}

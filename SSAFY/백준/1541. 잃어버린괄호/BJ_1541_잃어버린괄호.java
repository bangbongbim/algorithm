package algorithm_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1541_잃어버린괄호 {
	static char[] chArray;
	static int[] numArray = new int[5];

	static int chIdx, numIdx, sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		chArray = br.readLine().toCharArray();

		sum = getNum(); // 첫 번째는 숫자

		boolean isMinus = false;
		int minusSum = 0; // 앞에 부호가 - 이면 뒤에 오는 + 숫자를 임시로 더해준다. -(3+5+2)

		while (true) {
			char oper = getOper();
			int num = getNum();

			if (isMinus) {
				if (oper == '+') {
					minusSum += num;
				} else {
					sum -= minusSum;
					minusSum = num;
				}
			} else {
				if (oper == '+') {
					sum += num;
				} else {
					isMinus = true;
					minusSum = num;
				}
			}
			if (chIdx == chArray.length)
				break;
		}

		if (minusSum > 0)
			sum -= minusSum;

		System.out.println(sum);

	}

	// chIdx를 이용해서 현재 숫자 문자를
	static int getNum() {
		while (chIdx < chArray.length) {
			if (chArray[chIdx] == '+' || chArray[chIdx] == '-')
				break;
			numArray[numIdx++] = chArray[chIdx++] - '0';
		}
		return calcNum();

	}

	static char getOper() {
		if (chIdx < chArray.length) {
			return chArray[chIdx++];
		}
		return 'x';
	}

	static int calcNum() {
		int num = 0;
		int cnt = numIdx - 1;
		for (int i = 0; i < numIdx; i++) {
			// 10을 곱하는 연산
			for (int j = 0; j < cnt; j++) {
				numArray[i] *= 10;
			}
			num += numArray[i];
			cnt--;
		}

		// 초기화
		for (int i = 0; i < numIdx; i++) {
			numArray[i] = 0;
		}
		numIdx = 0;

		return num;
	}

}

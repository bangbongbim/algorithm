package ps;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2309 {

	static int arr[] = new int[9];
	static int sum = 0;

	static void sol() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i == j)
					continue;

				if (arr[i] + arr[j] == sum) {
					arr[i] = 9999;
					arr[j] = 9999;
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sc.nextLine();
		}

		sum = Arrays.stream(arr).sum();
		sum -= 100;

		sol();
		
		Arrays.sort(arr);

		for (int i = 0; i < 7; i++)
			System.out.println(arr[i]);
	}

}

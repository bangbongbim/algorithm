import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_부울경_3반_김진호 {
	static int T, N, X, K;
	static int[] arr;
	static int l, r; // swap을 위한 변수
	static int a; // 간식이 들어있는 칸을 찾기 위한 변수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine()); // 테스트케이스 입력

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			
			N = Integer.parseInt(st.nextToken()); // 종이컵 의 수
			X = Integer.parseInt(st.nextToken()); // 간식이 몇번째 종이컵
			K = Integer.parseInt(st.nextToken()); // 컵의 위치를 맞바꾸는 횟수

			arr = new int[N + 1]; // 계산을 편리하게 하기 위해 N+1로 사이즈를 만듬

			for (int i = 1; i <= N; i++) { // 종이컵 인덱스 저장
				arr[i] = i;
			}
			a = arr[X]; // 초기 간식의 위치 기억

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				l = Integer.parseInt(st.nextToken()); // 컵의 위치를 바꾸는 왼쪽 부분
				r = Integer.parseInt(st.nextToken()); // 컵의 위치를 바꾸는 오른쪽 부분

				swap(l, r); // 컵의 위치를 바꾸는 함수
			}

			for (int i = 1; i <= N; i++) {
				if (arr[i] == a) // 초기 기억하고 있는 간식의 위치가 있는 인덱스가 정답
					System.out.println("#" + t + " " + i);
			}
		}

	}

	static void swap(int l, int r) { // 컵의 위치를 바꾸는 함수 구현 부분
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

}

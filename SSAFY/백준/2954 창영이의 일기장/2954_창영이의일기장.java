import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Algo2_부울경_3반_김진호 {
	static String input;
	static String answer = "";
	static boolean flag = false; // 현재 위치에서 모음을 발견했다면 true, 발견하지 못했다면 false
	static char ch[] = { 'a', 'e', 'i', 'o', 'u' }; // 전체 모음을 저장하는 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		input = br.readLine(); // 입력

		for (int i = 0; i < input.length(); i++) {
			flag = false;// false 로 초기화
			for (int j = 0; j < 5; j++) {
				if (input.charAt(i) == ch[j]) { // 모을 을 발견 했다면 어떤 모음인지 기억
					flag = true;
					break;
				}
			}
			if (flag) {
				answer += input.charAt(i); // 모음이 발견이 되었다면 "모음"+p+"모음"이기 때문에 i를 +2해줌
				i = i + 2;
			} else {
				answer += input.charAt(i);
			}

		}

		System.out.println(answer);

	}

}

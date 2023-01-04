import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1806_부분합 {
    static int N, S;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;

        while (end <= N && start <= N) {
            if (sum >= S) {
                answer = Integer.min(answer, end - start);
                sum -= arr[start];
                start++;
            } else if (end == N)
                break;
            else {
                sum += arr[end++];
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }

}

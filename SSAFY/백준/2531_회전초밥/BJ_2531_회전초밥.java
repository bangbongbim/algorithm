import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2531_회전초밥 {
    static int N, d, k, c;
    static int[] sushi;
    static boolean[] visited;
    static int count;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        visited = new boolean[d + 1];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }


        for (int i = 0; i < N; i++) {
            Arrays.fill(visited,false);
            count = 0;
            for (int j = i; j < i + k; j++) {
                int idx = j >= N ? j % N : j;
                int number = sushi[idx];

                if (!visited[number]) {
                    visited[number] = true;
                    count++;
                }
            }
            if (!visited[c])
                count++;

            answer=Math.max(answer,count);
        }


        System.out.println(answer);

    }
}

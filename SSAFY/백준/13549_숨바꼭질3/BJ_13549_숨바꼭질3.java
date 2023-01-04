import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13549_숨바꼭질3 {
    static int K, X;
    static boolean[] visited = new boolean[100001];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        bfs(K);
        System.out.println(answer);
    }

    static void bfs(int K) {
        Queue<int[]> q = new ArrayDeque<>();

        visited[K] = true;
        q.offer(new int[]{K, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int time = cur[1];

            visited[pos] =true;

            if (pos == X) {
                answer =Math.min(answer,time);
                return;
            }


            if (pos * 2 <= 100000 && !visited[pos * 2]) {
                q.offer(new int[]{pos * 2, time});
            }

            if (pos - 1 >= 0 && !visited[pos - 1]) {
                q.offer(new int[]{pos - 1, time + 1});

            }

            if (pos + 1 <= 100000 && !visited[pos + 1]) {
                q.offer(new int[]{pos + 1, time + 1});

            }



        }

    }
}

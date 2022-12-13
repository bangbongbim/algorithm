import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1261_알고스팟 {
    static int N, M;
    static int[][] map;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }


        bfs(0, 0);
    }

    static void bfs(int y, int x) {
        ArrayDeque<Node> q = new ArrayDeque<>();

        q.offer(new Node(y, x, 0));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Node cur = q.poll();
                if(cur.y==N-1 && cur.x==M-1)
                {
                    System.out.println(cur.cost);
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int ny = cur.y + dy[d];
                    int nx = cur.x + dx[d];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx])
                        continue;

                    if(map[ny][nx]==0){
                        q.addFirst(new Node(ny,nx,cur.cost));
                    }
                    else{
                        q.offer(new Node(ny,nx,cur.cost+1));
                    }
                    visited[ny][nx] = true;


                }
            }
        }


    }

    static class Node {
        int y;
        int x;
        int cost;

        public Node(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}

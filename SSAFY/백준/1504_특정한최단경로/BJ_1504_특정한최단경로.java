import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class BJ_1504_특정한최단경로 {
    static int N, E;
    static List<List<Node>> adj;
    static int v1, v2;
    static int answer;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<Node>());
        }
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());


            adj.get(from).add(new Node(to, cost));
            adj.get(to).add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);


        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        answer = (res1 >= Integer.MAX_VALUE/1000 && res2 >= Integer.MAX_VALUE/1000) ? -1 : Math.min(res1, res2);
        System.out.println(answer);
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE/1000);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.to])continue;
            visited[cur.to] = true;
            for (Node n : adj.get(cur.to)) {

                if ( dist[n.to] > dist[cur.to] + n.cost) {
                    dist[n.to] = dist[cur.to] + n.cost;
                    pq.add(new Node(n.to, dist[n.to]));
                }
            }
        }

        return dist[end];

    }
    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}

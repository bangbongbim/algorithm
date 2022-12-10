import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1606_바이러스_floyd {
    static int N;
    static int M;
    static int adj[][];
    static int d[][];
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        d = new int[N+1][N+1];
        adj = new int[N+1][N+1];

        for(int i= 0 ; i <M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

           adj[from][to] = 1;
           adj[to][from] =1;
        }



        floyd();
        for(int i=2;i<=N;i++){
            if(adj[1][i]==1){
                answer++;
            }
        }
        System.out.println(answer);





    }


    private static void floyd() {
        for(int k=1;k<=N;k++){
            for(int i =1;i<=N;i++){
                for(int j =1;j<=N;j++){
                    if(adj[i][k] == 1 && adj[k][j]==1){
                        adj[i][j] = 1;
                    }
                }
            }
        }
    }

    static class Edge {
        int from;
        int to;
        public Edge(int from,int to){
            this.from = from;
            this.to=to;
        }

    }




}
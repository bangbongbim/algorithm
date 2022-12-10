import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11403_경로찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int[][] adj;


        N = Integer.parseInt(br.readLine());

        adj = new int[N + 1][N + 1];


        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1; k<=N;k++){
            for(int i =1;i<=N;i++){
                for(int j = 1;j<=N;j++){
                    if(adj[i][k]==1 && adj[k][j]==1){
                        adj[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 1;i<=N;i++){
            for(int j =1;j<=N;j++){
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
    }
}

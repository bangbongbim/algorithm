import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9095더하기 {
    static int T;
    static int num;
    static int answer;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){
            num = Integer.parseInt(br.readLine());
            dfs(num,0);
            System.out.println(answer);
            answer = 0;
        }

    }

    static void dfs(int target,int sum){
        if(target < sum)
            return;
        else if(target ==sum){
            answer++;
            return;
        }
        else{
            dfs(target,sum+1);
            dfs(target,sum+2);
            dfs(target,sum+3);
        }

    }
}

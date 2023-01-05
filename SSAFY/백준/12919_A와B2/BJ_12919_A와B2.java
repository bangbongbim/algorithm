import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * S에 문자를 더해서 가면 시간초과
 * T에서 뺴나가는 식으로 풀이해야 통과함
 */
public class BJ_12919_A와B2 {
    static String S, T;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        S = br.readLine();
        T = br.readLine();


        dfs(T);
        System.out.println(answer);
    }

   static void  dfs(String T){
        if(T.length() == S.length()){
            if(T.equals(S)){
                answer=1;
                return;
            }
            return;
        }

         if (T.charAt(0) == 'B') {
            String str= T.substring(1);
            str = reverse(str);
            dfs(str);
        }

        if (T.charAt(T.length()-1) == 'A'){
            String str= T.substring(0,T.length()-1);
            dfs(str);
        }




    }


    static String reverse(String S) {
        StringBuilder sb = new StringBuilder(S);
        return sb.reverse().toString();
    }
}

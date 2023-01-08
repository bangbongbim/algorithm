import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_22233_가희와키워드 {
    static int N, M;
    static HashSet<String> set = new HashSet<>();
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = N;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            set.add(word);
        }



        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split(",");

            for (String s : str) {
                if(set.contains(s)){
                    answer--;
                    set.remove(s);
                }
            }
            System.out.println(answer);
        }


    }
}

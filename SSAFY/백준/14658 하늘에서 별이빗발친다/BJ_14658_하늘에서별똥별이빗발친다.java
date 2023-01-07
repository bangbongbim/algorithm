import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14658_하늘에서별똥별이빗발친다 {
    static int N, M, L, K;

    static List<int[]> stars = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x, y});
        }

        for (int[] s1 : stars) {
            for (int[] s2 : stars) {
                answer = Math.max(answer, boundStar(s1[0], s2[1]));
            }
        }
        System.out.println(K-answer);

    }

    static int boundStar(int i, int j) {
        int res = 0;

        for (int[] star : stars) {
            if (i <= star[0] && star[0] <= i + L
                    && j <= star[1] && star[1] <= j + L) {
                res++;
            }
        }
        return res;
    }


}

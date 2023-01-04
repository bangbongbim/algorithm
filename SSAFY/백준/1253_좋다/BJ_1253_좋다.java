import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1253_좋다 {
    static int N;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            int target = arr[i];

            while (start < end) {
                if (start == i) start++;
                else if (end == i) end--;

                else {
                    int sum = arr[start] + arr[end];
                    if (sum == target) {
                        answer++;
                        break;
                    } else if (sum < target)
                        start++;
                    else
                        end--;
                }
            }


            }


            System.out.println(answer);


        }
    }

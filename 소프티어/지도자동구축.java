import java.util.*;
import java.io.*;


public class Main
{
    static int N;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

		// n = 0 부터 커질수록 중간에 하나씩 끼워서 증가한 거에 제곱이 답임띠 !!!
        int width = 2;
        for(int i = 1 ; i <= N ;i++){
            width = width +(width-1);
        }

        System.out.println(width * width);


        
    }
}
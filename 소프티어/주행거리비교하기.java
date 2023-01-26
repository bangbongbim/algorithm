import java.util.*;
import java.io.*;


public class Main
{
    static int A,B;
    public static void main(String args[])throws Exception
    {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        if(A>B)
        System.out.println("A");
        else if(A<B)
        System.out.println("B");
        else
                System.out.println("same");

        
        
    }
}
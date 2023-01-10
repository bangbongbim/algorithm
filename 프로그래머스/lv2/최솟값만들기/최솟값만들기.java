import java.util.*;
class Solution
{
    /**
     * 한 배열의 가장 큰수와 다른 한 배열의 가장 작은 수가 곱해져야 최소값이 나올 수 있음
     * 배열 A는 큰 수부터 , 배열 B는 작은수부터 나와야 함
     * 
     */
    public int solution(int []A, int []B)
    {
        int answer = 0;
        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqB = new PriorityQueue<>((e1,e2)->{
            return e2-e1;
        });
        
        for(int i = 0 ; i < A.length ; i++){
            pqA.offer(A[i]);
            pqB.offer(B[i]);
        }
        
        while(!pqA.isEmpty() && !pqB.isEmpty()){
            answer+= pqA.poll() * pqB.poll();
        }
 
        return answer;
    }
    
    
    
    
}
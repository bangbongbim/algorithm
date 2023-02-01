import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1,e2)->{return e1 - e2 ;});
        int answer = 0;
        
        for(int i = 0 ; i < scoville.length ; i++){
                pq.offer(scoville[i]);
            
        }
        while(pq.peek() < K){
             if(pq.size() == 1){
                    return -1;
                }
                int first = pq.poll();
                int second = pq.poll();
                int sco = first + (second*2);                
                pq.offer(sco);
                answer++;                
        }
        return answer;
    }

}
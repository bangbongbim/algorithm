import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new ArrayDeque<>();
        
        int sum=0;
        for(int truck : truck_weights){
            
            while(true){
                // 다리에 트럭이 없을때
                if(bridge.isEmpty()){
                    bridge.offer(truck);
                    sum+=truck;
                    answer++;
                    break;
                }
                     // 다리에 트럭이 길이만큼 올라오면 제일 처음 들어온 녀석 통과시킴
                 else if(bridge.size() == bridge_length){
                        sum-=bridge.poll();
                    }
                // 다리에 트럭이 있을때
                else{
                     if(sum+truck <= weight){
                        bridge.offer(truck);
                        answer++;
                        sum+=truck;
                        break;
                    }
                    else if(sum+truck >weight) {
                        bridge.offer(0);
                        answer++;
                    }
                    
                }
            }
        }
        return answer + bridge_length;
    }
}
import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int[] answer = {};
        
        for(int i = 0 ; i < progresses.length ;i++){
            // 얼마나 작업을 해야하는지 계산
            int day = (100 - progresses[i]) / speeds[i];
            
            // 애매하게 하루 더 필요한거 계산
            if(((100 - progresses[i]) % speeds[i]) > 0)
                day++;
        
        // 배포일을 계산해서 큐에 넣어놓음
            q.offer(day);
        }
        /**
         * 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포
         * 앞에 기능 배포일보다 뒤에 배포일이 작으면 한꺼번에 배포
         */
        int top = q.poll();
        int count = 1;
        while(!q.isEmpty()){
            if(top >= q.peek()){
                count++;
                q.poll();
            }
            else{
               list.add(count);
                top = q.poll();
                count=1;
            }
        }
        list.add(count);
        
        // 아니 이거 List 에서 배열로 한번에 변환해주는거 없삼 ?!
        answer = new int[list.size()];
        
        for(int i = 0 ; i < list.size();i++)
            answer[i] = list.get(i);
        
        return answer;
    }
}
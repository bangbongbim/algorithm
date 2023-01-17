import java.util.*;
class Solution {
    // 정렬 후 가장 가벼운 사람과 무거운 사람을 같이 태웠을 경우를 생각함
    // limit을 넘어가면 뚱뚱이만 태우기
    // limit보다 작으면 둘다 태움 -> index를 한칸 옮겨줌
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int index = 0;
        
        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {
                index++;
            }
                answer++;
        }
        
        return answer;
    }
}
import java.util.*;

public class Solution {

    // stack으로 풀면댐띠
    // pop해주믄서 뒤에서 부터 배열에 집어넣음
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i <arr.length ; i++){
            if(stack.isEmpty())
                stack.push(arr[i]);
            else if(stack.peek() != arr[i])
                stack.push(arr[i]);
        }
        
        
        answer = new int[stack.size()];
        int i = stack.size()-1;
        while(!stack.isEmpty()){
            int number = stack.pop();
            answer[i] = number;
            i--;
        }
        
        
        return answer;
    }
}
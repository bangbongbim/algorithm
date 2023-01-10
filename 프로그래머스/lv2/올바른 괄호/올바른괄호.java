import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer =true;
        
        char[] arr = s.toCharArray();
        
        if(arr.length % 2 ==1 || arr[0] == ')')
            return false;
        
        for(int i = 0 ; i < arr.length;i++){
            if(arr[i] == ')'){
                if(stack.empty())
                    return false;
                
                stack.pop();
            }
            else
                stack.push('(');
            
        }
        
        if(stack.isEmpty())
            answer= true;
        else 
            answer =false; 
        
        
        
        
        return answer;
    }
}
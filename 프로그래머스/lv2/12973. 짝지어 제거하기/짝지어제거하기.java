import java.util.*;
class Solution
{
    // 노가다하면 시간초과
    // stack 생각 못하고 있었음... 힌트 살짝봄 
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ; i < s.length();i++){
            if(!stack.isEmpty() && stack.peek()  == s.charAt(i)){
                stack.pop();
            }
            
            else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
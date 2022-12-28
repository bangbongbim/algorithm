import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0 ; i < moves.length;i++){
            int next = moves[i] - 1;
            
            for(int j = 0 ; j < board[next].length;j++){
                // 세로로 체크하면서 처음으로 0이 아닌 녀석을 만났을 때
                if(board[j][next] != 0){
                    int doll = board[j][next];
                    System.out.println(doll);
                    // 스택이 비어있지 않다면
                    if(!stack.isEmpty()){
                        // 맨 위의 값과 같다면 ?
                        if(doll == stack.peek()){
                        answer+=2;
                        stack.pop();
                        }
                        // 같지 않다면 ?
                        else{
                            stack.push(doll);
                        }
                }
                    // 스택이 비어있다면 ?
                    else{
                        stack.push(doll);
                    }
                
                    board[j][next] = 0;
                    break;
                }
            }
            
            
            
        }
        return answer;
    }
}
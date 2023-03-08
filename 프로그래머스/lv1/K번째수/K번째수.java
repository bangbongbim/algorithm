import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        for(int l = 0 ; l <commands.length;l++){
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            
            int[] temp = Arrays.copyOfRange(array,i-1,j);           
            Arrays.sort(temp);
            answer[l] = temp[k-1];
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr =s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(String st : arr){
            int number = Integer.parseInt(st);
            min = Math.min(min,number);
            max =Math.max(max,number);
        }
        answer+=min;
        answer+=" ";
        answer+=max;
        
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0 ; i < n ; i++){
            String str1=String.format("%0"+n+"d", Long.parseLong(Long.toBinaryString(arr1[i])));
            String str2=String.format("%0"+n+"d", Long.parseLong(Long.toBinaryString(arr2[i])));
            String str3="";
            
            for(int j = 0 ; j < n ;j++){
                char a = str1.charAt(j);
                char b = str2.charAt(j);
                
                if(a=='1' || b=='1')
                    str3+="#";
                else
                    str3+=" ";
            }
            
            answer[i] = str3;
            
        }
        return answer;
    }
}
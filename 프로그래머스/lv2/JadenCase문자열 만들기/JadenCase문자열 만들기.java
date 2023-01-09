import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        

        /*
        처음에 이렇게 챡챡 잘라서 마지막 공백 제거해서 했는데 실패함...
        혹시 무엇이 잘못된지 발견하면 알려주삼 !!
        String first = str.substring(0, 1).toUpperCase();
        String others = str.substring(1).toLowerCase();
        answer+=first+others+" ";
        */
        
        
        // 맨 처음 문자는 미리 바꿔놓고
        // 앞에 문자를 기준으로 대문자, 소문자 판별함
        answer+=arr[0].toUpperCase();
        for(int i = 1 ; i < arr.length;i++){
            if(arr[i-1].equals(" "))
                answer+=arr[i].toUpperCase();
            else{
                answer+=arr[i].toLowerCase();
            }
        }
        return answer;
    }
}
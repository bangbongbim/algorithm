import java.util.*;
class Solution {
            // 했던 단어는 중복이 될 수 없음
            // 앞사람이 말한 단어의 마지막 문자
            // 한글자인 단어는 불가능함
            // Set으로 존재하는지 않하는지 체크함
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int[] answer = new int[] {0,0};
        
        int turn = 0;
        int number = 0;
        // words의 첫번째 단어를 미리 넣어놓고 시작함 
        // 첫번째 단어는 한글자인 단어만 체크하면 되기 때문에 그랬삼
        char prev=words[0].charAt(0);
        for(int i = 0 ; i < words.length;i++){
            String word = words[i];
            
            if(!set.contains(word) && (word.charAt(0) == prev) && (word.length()>1)){
                set.add(word);
                prev = word.charAt(word.length()-1);
            }
            else{
                // 나머지 계산할때 0이면 n번째 사람으로 바꿔줘야함!!
                // 이거보다 쉬운 계산 있으면 알려주삼!!!! 내 머리의 한계띠
                number = (i+1)%n == 0? n : (i+1)%n ;
                turn = (i/n)+1;
              answer[0] = number;
              answer[1] = turn;
                return answer;
            }
         
            
        }
        return answer;
    }
}
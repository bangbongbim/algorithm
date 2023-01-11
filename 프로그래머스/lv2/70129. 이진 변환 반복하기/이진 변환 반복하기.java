class Solution {
    public int[] solution(String s) {
        // 1이 되기까지
        // 이진 변환의 횟수
        // 변환 과정에서 제거된 0의 개수
        int[] answer = {};
        int zero = 0;
        int convert = 0;
        
       while(true){
           if(s.equals("1"))
               break;
           
           // 0 의 개수 세야함
           for(int i = 0 ; i < s.length();i++){
               if(s.charAt(i) == '0')
                   zero++;
           }
           
           // 0 제거
           s=s.replaceAll("0","");
           System.out.println(s);
           
           // 0제거 후 길이
           int size = s.length();
           
           // 0이 제거된 길이를 2진수로 변환
           s = Integer.toBinaryString(size);
           convert++;
           
       }
        answer = new int[] {convert,zero};
        return answer;
    }
}
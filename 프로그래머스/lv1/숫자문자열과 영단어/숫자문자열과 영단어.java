class Solution {
    public int solution(String s) {
    String number[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    StringBuffer sb = new StringBuffer();
    sb.append(s);
    System.out.println(number.length);
        for(int i = 0 ; i <number.length;i++){
            String str = number[i];
            if(sb.indexOf(str)!=-1){  
                // 시작부터 길이만큼 문자열을 바꿔줘야함
                int start = sb.indexOf(str);
                int len = str.length();
                sb.replace(start,start+len,String.valueOf(i));
                --i;
            }
        }
        
        int answer = Integer.parseInt(sb.toString());
        return answer;
    }
}
class Solution {
    // Integer.bitCount(num)
    // 이것을 쓰면 숫자를 2진수로 변환한 뒤에 1의 개수를 반환해줌...
    // Integer.toBinaryString()으로 하나하나 체크하면 시간초과가 났음
    // 혹시 안나는분은 방법 알려주삼!
    public int solution(int n) {
        int answer = 0;
        int count = 0;
        
        count = Integer.bitCount(n);
       while(true){
           ++n;
           if(count == Integer.bitCount(n)){
               answer = n;
               break;
           }
       }
             return answer;
        }
   
    }
    

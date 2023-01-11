class Solution {
    // 투 포인타로 슥슥 풀면댐...
    public int solution(int n) {
        int answer = 0;
        
        // 시작 지점 
        int start = 0;
        int end = 0;
        
        while(true){
            int sum = 0;
            // 종료 조건
            if(end >n || start>n)
                break;
            
            // 합을 구함
            for(int i=start ;i<=end;i++){
                sum+=i;
            }
            if(sum == n){
                answer++; 
                end++;
            }
              
            else if(sum > n)
                start++;
            else
                end++;
        }
        return answer;
    }
}
class Solution {
    static int[] memo;
    public int solution(int n) {
        memo = new int[100001];
        int answer = 0;
        answer = rec(n) % 1234567;
        return answer;
    }
    
    public int rec(int n){
        if(n<2){
            return n;
        }
         if(memo[n]!= 0)
            return memo[n] % 1234567;
        
        return memo[n] = (rec(n-1) + rec(n-2))%1234567;
    }
}
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
      answer = getLcm(arr);
        
        return answer;
    }
    
    int getLcm(int[] arr){
        if(arr.length == 1){
            return arr[0];
        }
        
        int gcd = getGcd(arr[0], arr[1]);
        int lcm = (arr[0]*arr[1])/ gcd;
        
        for(int i = 2; i< arr.length ;i++){
            gcd = getGcd(lcm,arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
        return lcm;
    }
    
    int getGcd(int num1 ,int num2){
        if(num1%num2==0){
            return num2;
        }
        
        return getGcd(num2,num1%num2);
    }
}
class Solution
{
    public int solution(int n, int a, int b)
    {
        /*
        만약 1번↔2번 끼리 겨루는 게임에서 2번이 승리했다면 다음 라운드에서 1번을 부여받고, 
        3번↔4번에서 겨루는 게임에서 3번이 승리했다면 다음 라운드에서 2번을 부여받게 됩니다
        */
        int answer = 1;
        
        while(true){
            if(((a+1)/2) == ((b+1)/2))
                break;
            
            answer++;
            
            a= (a+1)/2;
            b= (b+1)/2;
        }

        return answer;
    }
}
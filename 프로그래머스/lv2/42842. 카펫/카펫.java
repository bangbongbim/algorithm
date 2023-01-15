class Solution {
    public int[] solution(int brown, int yellow) {
        int leng = brown + yellow;
        int[] answer = new int[2];
        
        for(int i = 1 ; i<=leng; i++ ){
            for(int j = 0 ; j<=leng;j++){
                
                if(i * j == leng){
                    int first = i;
                    int second = j;
                    
                    
                    if((first>=3 && second>=3) && (first>=second)){
                        int cnt =  (first-2 )* (second -2);
                        
                        if(cnt == yellow){
                            answer[0] = first;
                            answer[1] =second;
                            return answer;
                        }
                        
                    }
                }           
            }
        }
        return answer;
    }

}
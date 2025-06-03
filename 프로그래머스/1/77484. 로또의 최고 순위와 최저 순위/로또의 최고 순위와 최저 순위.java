class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int min = 7;
        
        for(int n : lottos){
            if(n == 0){
                zeroCnt++;
            }
            //숫자일 경우 맞았는지 체크
            else{
                for(int wn : win_nums)
                {
                    if(wn == n){
                        min--;
                        break;
                    }
                } 
            }       
        }
        
        answer[0] = min-zeroCnt == 7 ? 6 : min-zeroCnt;
        answer[1] = min == 7 ? 6 : min;
        
        
        return answer;
    }
}
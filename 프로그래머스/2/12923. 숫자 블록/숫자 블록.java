// 블록에는 자신을 제외한 가장 큰 약수가 적힘
// (단, n==1이면 블록에 0 적힘)

import java.util.*;
class Solution {
    static boolean [] check;
    public int[] solution(long begin, long end) {
        int st = (int) begin;
        int en = (int) end; 
        int [] answer = new int [en - st + 1];
        Arrays.fill(answer, 1);
        for(int i = st; i <= en; i++){ 
            answer[i - st] = calculate(i);
        }
        if(st == 1) answer[0] = 0;
        return answer;
    }    
    public static int calculate(int input){
        int max = 1;
        for(int i = 2; i * i <= input; i++){
            if(input % i == 0){
                max = i;
                if(input / i <= 10000000)
                return input / i;
            }
        }
        return max;
    }
}
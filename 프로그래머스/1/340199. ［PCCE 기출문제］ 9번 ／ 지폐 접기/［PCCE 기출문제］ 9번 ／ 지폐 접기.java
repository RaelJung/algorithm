import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        answer = isInside(wallet, bill);
        
        return answer;
    }
    
    public int isInside(int[] w, int[] b){
        int cnt = 0; //최소 횟수
        //지폐가 들어갈 때까지 반복
        while(true){
            //들어가는 지 확인(정방향, 90도)
            if((w[0]>=b[0] && w[1]>=b[1]) || (w[0]>=b[1] && w[1]>=b[0])){
                return cnt;
            } 
            
            //아니라면 지폐 접기 시작
            if(b[0]>b[1]){
                b[0] /= 2;
            }
            else{
                b[1] /= 2;
            }
            cnt++; //지폐 접은 횟수 증가
        }
    }
}
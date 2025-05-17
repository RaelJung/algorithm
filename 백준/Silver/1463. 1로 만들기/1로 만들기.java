import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //X가 3으로 나누어 떨어지면 3으로 나누기
        //X가 2로 나누어 떨어지면 2로 나누기
        //1을 빼기
        //세 개를 적절히 사용해 1을 만들어야 함
        //연산의 최솟값 구하기

        //위의 규칙이 이전 계산을 포함함 -> dp
        int dp[] = new int[n+1];
        //초기값 설정
        dp[1] = 0;      //이미 1이다
        
        //2부터 시작
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+1;
            if(i%3==0){
                //i-1 인덱스에 1빼기 vs i/3 인덱스에 3나누기 연산 하나 더하기
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
            if(i%2==0){
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
        }

        System.out.println(dp[n]);
    }
}

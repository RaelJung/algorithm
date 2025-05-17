import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 0){
            System.out.println("0");
        }

        //피보나치 수
        //0과 1로 시작
        //n-1 + n = n+1 구조

        else{
            long dp[] = new long[n+1];  //n이 90까지 가므로(아니 이건 걍 외우자)
            //초기 값 세팅
            dp[0] = 0;
            dp[1] = 1;

            for(int i=2; i<=n; i++){
                dp[i] = dp[i-2]+dp[i-1];
            }

            System.out.println(dp[n]);
        }
    }
}

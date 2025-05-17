import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        //정수를 1,2,3의 합으로 나타내기
        //n<11
        //n==1) 1 (1)
        //n==2) 2 (1+1, 2)
        //n==3) 4 (1+1+1, 1+2, 2+1, 3)
        //n==4) 7 (1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1)
        for(int t=0; t<T; t++){
            int n = sc.nextInt();

            int dp[] = new int[n+1];
            //초기값 세팅
            dp[1] = 1;
            if(n>=2) dp[2] = 2;
            if(n>=3) dp[3] = 4;

            for(int i=4; i<=n; i++){
                dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
            }

            System.out.println(dp[n]);
        }
    }
}

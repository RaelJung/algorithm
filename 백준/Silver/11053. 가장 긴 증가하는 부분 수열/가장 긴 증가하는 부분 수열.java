import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] num, dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        dp = new int[N];

        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            dp[i] = 1;  //초기 세팅
        }

        //A[i] -> i를 끝 인덱스로 하는 LIS 길이
        //A[j] < A[i]를 만족하는 것에 대해 길이 증가
        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 자기 자신만 있는 경우
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        Arrays.sort(dp);

        System.out.println(dp[N-1]);
    }
}

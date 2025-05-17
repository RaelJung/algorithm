import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int marks[] = new int[n+1];

        //점수의 최댓값을 구하는 문제
        //이전 계단에서 연속으로 왔는지도 체크해야함(3연속 계단 고르기 불가)
        //1칸 혹은 2칸을 넘을 수 있음
        
        //인덱스 맞추기 위해 1부터 초기화
        for(int i=1; i<=n; i++){
            marks[i] = sc.nextInt();
        }

        //dp[i] -> i번째 계단에 올라갔을 때의 최대 점수 합 저장
        //i번째 계단 올라가는 방법
        // 1) i-2 -> i
        // 2) i-3 -> i-1 -> i
    
        int dp[] = new int[n+1];
        //초기값 세팅
        dp[1] = marks[1];
        if(n>=2)dp[2] = marks[1]+marks[2];
        if(n>=3)dp[3] = Math.max(marks[1]+marks[3], marks[2]+marks[3]);
        
        for(int i=4; i<=n; i++){
            dp[i] = marks[i] + Math.max(dp[i-2], dp[i-3]+marks[i-1]);
        }

        System.out.println(dp[n]);

        sc.close();
    }
}

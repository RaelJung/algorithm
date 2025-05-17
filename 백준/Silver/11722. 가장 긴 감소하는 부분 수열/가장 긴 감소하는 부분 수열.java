import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int nums[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //dp[i] 정의: i번째 원소가 마지막
        //그럼 i이전의 원소들이 본인보다 더 큰 것이 있는지 확인해야...
        int dp[] = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}

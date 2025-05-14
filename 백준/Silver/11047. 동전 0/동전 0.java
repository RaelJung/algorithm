import java.io.*;
import java.util.*;

public class Main {
    static int N, K, sum=0;
    static int num[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new int[N];

        //오름차순으로 주어진다
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        for(int i=N-1; i>=0; i--){
            if(K>=num[i]){
                sum += K / num[i];
                K %= num[i];
            }
        }

        System.out.println(sum);
    }
}

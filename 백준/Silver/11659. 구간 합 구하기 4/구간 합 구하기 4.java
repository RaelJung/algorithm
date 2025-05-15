import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int num[], sum[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new int[N];
        sum = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = num[0];
        //전체 합부터 먼저 ㄱㄱ 차피 다 더할테니깐요 이건 아까 걔처럼 안 정해져있음 개수가
        for(int i=1; i<N; i++){
            sum[i] = sum[i-1]+num[i];
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int total=sum[e-1];
            if((s-1)>0){
                total -= sum[s-2];
            }

            System.out.println(total);
        }


    }
}

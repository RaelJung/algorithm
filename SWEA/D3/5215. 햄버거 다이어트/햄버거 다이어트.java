//0810 SW_5215_햄버거 다이어트

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//bitmask 사용!
public class Solution {
    static int T, N, L, max;
    static Item[] src;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            max = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            
            src = new Item[N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                src[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                
            }

            //부분집합
            subset(0, 0);   //두번째 인자가 mask
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void subset(int idx, int mask) {
        //기저조건
        if(idx == N){
            //complete code
            int cal = 0;
            int point = 0;

            //i번째 재료의 선택 여부 확인 (mask에 기록)
            //선택된 재료에 대한 cal, point 계산 수행
            for(int i=0; i<N; i++){
                if((mask & 1 << i)==0) continue;
                cal += src[i].c;
                point += src[i].p;
            }

            //합에 대한 칼로리 체크, max 처리
            if(cal <= L)  max = Math.max(max, point);
            
            return;
        }
        subset(idx+1, mask | 1 << idx); //선택
        subset(idx+1, mask);    //비선택
	}

    static class Item{
        int p, c;
        Item(int p, int c){
            this.p = p;
            this.c = c;
        }
    }
}
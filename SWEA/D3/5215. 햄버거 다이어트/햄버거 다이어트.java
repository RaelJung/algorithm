//0810 SW_5215_햄버거 다이어트

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//DFS + param!
//Item => 2차원 배열
public class Solution {
    static int T, N, L, max;
    static int[][] src;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            max = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            
            src = new int[N][2];    //0: point, 1: cal
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                src[i][0] = Integer.parseInt(st.nextToken());
                src[i][1] = Integer.parseInt(st.nextToken());
                
            }

            //부분집합
            dfs(0, 0, 0);   //dfs + param
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int idx, int point, int cal) {
        //기저조건
        if(idx == N){
            //complete code
            //L 조건을 따지지 않는다. <- 이전에 가지치기로 이 조건을 따질 것이므로.
            max = Math.max(max, point); 
            return;
        }
        dfs(idx+1, point, cal);     //비선택 <= 전달받은 point, cal을 그대로 다음 재귀호출에 전달
        //가지치기
        //다음 재귀호출의 cal이 이미 L을 초과하면 가지 않는다.
        int nextCal = cal + src[idx][1];
        if(nextCal <= L){
            dfs(idx+1, point+src[idx][0], nextCal);           //선택
        }
        
	}
}
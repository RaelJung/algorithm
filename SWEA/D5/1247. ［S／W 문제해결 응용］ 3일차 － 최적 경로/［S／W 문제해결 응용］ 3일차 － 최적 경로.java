import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//기본적인 순열
public class Solution {
	static int T, N, comY, comX, homeY, homeX, min;
    static int[][] cust;
    static int[] tgt; // cust -> tgt 순열 채우고 처리
    static boolean[] select;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            
            N = Integer.parseInt(br.readLine());
            cust = new int[N][2];
            select = new boolean[N];
            tgt = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            comY = Integer.parseInt(st.nextToken());
            comX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            homeX = Integer.parseInt(st.nextToken());
            
            for (int i = 0; i < N; i++) {
                cust[i][0] = Integer.parseInt(st.nextToken());
                cust[i][1] = Integer.parseInt(st.nextToken());
            }
            
            // 초기화
            min = Integer.MAX_VALUE;
            
            // 풀이
            perm(0, 0);
            
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    static void perm(int tgtIdx, int sum) { // sum 현재까지 누적거리의 합
        // 기저조건
        if( tgtIdx == N ) { // 마지막 고객만 추가로 계산해서 처리
            // complete code
            // 마지막 고객 -> 집
            sum += distance(homeY, homeX, cust[tgt[N-1]][0], cust[tgt[N-1]][1]);
            min = Math.min(min, sum);
            
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if( select[i] ) continue;
            
            tgt[tgtIdx] = i;
            
            select[i] = true;
            
            int dis = 0; // 거리 계산
            if( tgtIdx == 0 ) {
                dis = distance(comY, comX, cust[tgt[0]][0], cust[tgt[0]][1]);
            }else {
                dis = distance( 
                        cust[tgt[tgtIdx-1]][0], cust[tgt[tgtIdx-1]][1],
                        cust[tgt[tgtIdx]][0], cust[tgt[tgtIdx]][1]
                        );
            }
            // 가지치기
            if( sum + dis < min )
                perm(tgtIdx + 1, sum + dis);
            
            select[i] = false;
        }
    }
    
    static int distance(int y1, int x1, int y2, int x2) {
        return Math.abs(y1 - y2) + Math.abs(x1 - x2);
    }
}
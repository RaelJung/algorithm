import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    
    static int T, N;
    static long ans;
    
    static int[] parent; // 서로소
    static int[][] island; // 0: x, 1: y
    
    static long[][] edges; // 0: v1, 1: v2: 2: distance
    static double E;
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            // 입력
            N = Integer.parseInt(br.readLine());
            
            island = new int[N][2];
            // x
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                island[i][0] = Integer.parseInt(st.nextToken());
            }
            // y
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                island[i][1] = Integer.parseInt(st.nextToken());
            }
            
            // E
            E = Double.parseDouble(br.readLine());
            
            // 나머지 자료구조
            parent = new int[N];
            makeSet();
            
            // 간선....
            int size = N*(N-1)/2; // N개의 정점을 연결하는 모든 간선의 수 
            edges = new long[size][3];
            
            int idx = 0;
            for (int v1 = 0; v1 < N - 1; v1++) {
                for (int v2 = v1 + 1; v2 < N; v2++) {
                    edges[idx][0] = v1;
                    edges[idx][1] = v2;
                    edges[idx][2] = distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]);
                    idx++;
                }
            }
            
            // 쿠르스칼 풀이
            // 정렬
            Arrays.sort(edges, (o1, o2) -> Long.compare(o1[2], o2[2]));
            
            ans = 0;
            int cnt = 0;
            
            for (int i = 0; i < size; i++) {
                // union() 호출 대신 직접 코드를 작성 - call stack save!
                int px = findSet((int) edges[i][0]);
                int py = findSet((int) edges[i][1]);

                if( py == px ) continue;
//                parent[py] = px;
                if( px > py ) parent[py] = px;
                else parent[px] = py;
                
                ans += edges[i][2]; // 누적 비용
                cnt++;
                if( cnt == N - 1) break;
            }
            
            sb.append("#").append(t).append(" ").append(Math.round(ans*E)).append("\n");
        }
        System.out.println(sb);
    }

    static long distance(int x1, int x2, int y1, int y2) {
        return (long)(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
    
    static void makeSet() {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }
    
    static int findSet(int x) {
        if( parent[x] == x ) return x;
        else return parent[x] = findSet(parent[x]);
    }
}
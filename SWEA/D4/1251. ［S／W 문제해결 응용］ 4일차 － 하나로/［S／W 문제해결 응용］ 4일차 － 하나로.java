import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    
    static int T, N;
    static long ans;
    
    static int[][] island; // 0: x, 1: y
    static List<List<Edge>> vertex;
    static PriorityQueue<Edge> pqueue = new PriorityQueue<>( (e1, e2) -> Long.compare(e1.c, e2.c));
    static boolean[] visit;
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
            vertex = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                vertex.add(new ArrayList<Edge>());                
            }

            for (int v1 = 0; v1 < N - 1; v1++) {
                for (int v2 = v1 + 1; v2 < N; v2++) {                    
                    Edge edge1 = new Edge(v2, distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]));
                    Edge edge2 = new Edge(v1, distance(island[v1][0], island[v2][0], island[v1][1], island[v2][1]));
                    vertex.get(v1).add(edge1);
                    vertex.get(v2).add(edge2);
                }
            }
            
            // 프림 풀이
            visit = new boolean[N];
            pqueue.clear();
            
            ans = 0;
            int cnt = 1;
            visit[0] = true;
            pqueue.addAll(vertex.get(0));
            while(! pqueue.isEmpty() ) {
                
                Edge edge = pqueue.poll();
                if( visit[edge.v] ) continue;
                
                visit[edge.v] = true;
                ans += edge.c;
                cnt++;
                
                if( cnt == N ) break;
                for (Edge e : vertex.get(edge.v)) {
                    if( visit[e.v] ) continue;
                    pqueue.offer(e);
                }                
            }

            sb.append("#").append(t).append(" ").append(Math.round(ans*E)).append("\n");
        }
        System.out.println(sb);
    }

    static long distance(int x1, int x2, int y1, int y2) {
        return (long)(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
    // 어떤 정점으로부터 선택해서 다른 정점으로 이동할 수 있는 간선 정보, v : 선택하면 가게되년 정점
    static class Edge{
        int v;
        long c;
        
        Edge(int v, long c){
            this.v = v;
            this.c = c;
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static int s1, s2;
    static boolean visit[];
    static LinkedList<LinkedList<Integer>> graph;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        graph = new LinkedList<>();
        //노드 인덱스 맞추기 위해서+1
        for(int i=0; i<N+1; i++){
            graph.add(new LinkedList<>());
        }

        //간선 연결
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            s1 = Integer.parseInt(st.nextToken());
            s2 = Integer.parseInt(st.nextToken());

            graph.get(s1).add(s2);
            graph.get(s2).add(s1);
        }

        //번호가 작은 정점을 먼저 방문(sort 필요)
        for(int i=1; i<N+1; i++){
            Collections.sort(graph.get(i));
        }

        //dfs
        //시작점 visit 처리!!!!!!!!!
        visit[V] = true;
        sb.append(V+" ");
        dfs(V);
        visit = new boolean[N+1];   //초기화
        sb.append("\n");
        //bfs
        bfs(V);

        System.out.println(sb.toString());
    }

    public static void dfs(int s){
        //종료조건
        //갈 곳 없을 때; - 무조건 돌아봐야 아니깐 끝에서 판단
        
        for(int node : graph.get(s)){
            if(visit[node]) continue;

            sb.append(node+" ");
            visit[node] = true;
            dfs(node);
        }
        return;
    };

    public static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        sb.append(s+" ");
        visit[s] = true;

        while(!q.isEmpty()){
            int c = q.poll();

            //c 노드의 요소를 오름차순으로 불러옴
            for(int node : graph.get(c)){
                if(visit[node]) continue;
                visit[node] = true;
                q.add(node);
                sb.append(node+" ");
            }
        }
        sb.append("\n");
        return;
    }
}

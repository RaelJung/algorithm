import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 선택된 정점들로부터 갈 수 있는 최소비용 간선의 정점 <= Priority Queue
// 간선 리스트 => 연결리스트
public class Solution {
    static int T, V, E;
    static long sum;
    static List<List<Edge>> adjList; // 간선리스트
    static boolean[] visit; // 방문(선택)
    static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adjList = new ArrayList<>(); // adjList.get(3) => ArrayList : 3정점에서 갈 수 있는 간선 리스트

            for (int i = 0; i <= V; i++) { // 0 dummy
                adjList.add(new ArrayList<>());
            }
            visit = new boolean[V + 1]; // 0 dummy

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adjList.get(v1).add(new Edge(v2, c));
                adjList.get(v2).add(new Edge(v1, c));
            }

            sum = 0;
            pq.clear();
            prim();

            sb.append("#" + t + " " + sum + "\n");

        }
        System.out.println(sb.toString());
    }

    static void prim() {
        int cnt = 1;// 선택된 정점의 수
        visit[1] = true;// 시작 정점 visit(선택)
        pq.addAll(adjList.get(1)); // 1번정점으로부터 갈 수 있는 모든 간선이 pq에 담긴다.\

        while (!pq.isEmpty()) {
            Edge edge = pq.poll(); // 현재큐에 담긴 간선들 중 비용이 가장 싼 간선이 선택
            if (visit[edge.v])
                continue; // 이미 선택 된 정점이면 무시

            visit[edge.v] = true;
            sum += edge.c;
            cnt++;
            if (cnt == V)
                break;

            // 선택된 정점으로부터 갈 수 있는 간선을 모두 pq에 담는다.
//            pq.addAll(adjList.get(edge.v)); // #1 따지지 않고 넣는다.
            // #2 골라서 넣는다
            for (Edge e : adjList.get(edge.v)) {
                if (!visit[e.v])
                    pq.add(e);
            }
        }
    }

    static class Edge { // 간선 1개 : 속한 정점에서 부터 연결되는 간선 v = 도착 정점, c: 비용
        int v, c;

        Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

// 인접 리스트
public class Main {
	static int N, M, V;
    static int from, to;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] ars) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);

        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        DFS(V);
        visited = new boolean[N + 1];
        System.out.println();
        BFS(V);

    }

    static void DFS(int idx) {
        System.out.print(idx+ " ");
        visited[idx] = true;
        ArrayList<Integer> adjList = graph.get(idx);
        for(int i =0; i<adjList.size(); i++) {
            if(visited[adjList.get(i)]) continue;
            DFS(adjList.get(i));
        }
        
    }
    static void BFS(int idx) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(idx);
        visited[idx] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
            ArrayList<Integer> adjList = graph.get(cur);
            for (int i = 0; i < adjList.size(); i++) {
                if (visited[adjList.get(i)])
                    continue;
                queue.offer(adjList.get(i));
                visited[adjList.get(i)] = true;
            }
        }
    }

}
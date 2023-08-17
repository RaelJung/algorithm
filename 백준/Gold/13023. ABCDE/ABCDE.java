import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//인접 행렬 쓰니깐 시간초과...
public class Main {
	static int N, M;
    static int from, to;

    static List<List<Integer>> graph = new ArrayList<>();

    static boolean[] visited;

    static boolean done = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        // 풀이
        // 모든 친구 각각으로부터 출발
        for(int i = 0; i<N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, 0);
            if(done) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void dfs(int num, int cnt) { // 친구(정점)번호, depth(count)
        // 기저조건
        //if(done) return;
        
        if(cnt == 4) { // 4번 연속으로 친구가 연결
            done = true;
            return;
        }
        
        // 계속 이어지는 친구를 방문
        graph.get(num).forEach((i)->{
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, cnt+1);
                visited[i] = false;
            }
        });
//        for(int i = 0; i<N; i++) {
//            if(!friends[num][i] || visited[i]) continue; // num으로 부터 갈 수 없는 친구, 이미 방문한 친구
//             visited[i] = true;
//             dfs(i, cnt+1);
//             visited[i] = false; // 내가 방문해온 자리만 visit check
//        }
        
        

    }

}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] topo;
    static List<List<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생수
        M = Integer.parseInt(st.nextToken()); // 비교횟수
        topo = new int[N + 1];// 0 dummy
        // 인접리스트
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        // 비교횟수
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a-> b
            graph.get(a).add(b);
            topo[b]++; // 진입차수 증가
        }

        // 풀이
        Queue<Integer> queue = new ArrayDeque<>();

        // 진입차수가 0인 번호를 queue에 넣음
        for (int i = 1; i <= N; i++) {
            if (topo[i] == 0) {
                queue.offer(i);
            }
        }

        // queue를 이용해서 꺼내면서 연결을 끊고 다시 진입차수가 0인 학생을 큐에 담는다
        while (!queue.isEmpty()) {
            int no = queue.poll();
            // 큐에서 꺼낸 번호가 바로 줄세우기 번호
            sb.append(no + " ");

            // no학생으로부터 갈 수 있는 다른 학생을 모두 대상으로
            List<Integer> adjList = graph.get(no);
            int size = adjList.size();
            for (int i = 0; i < size; i++) {
                int tmp = adjList.get(i);
                topo[tmp]--; // no->tmp관계인데,no를 그래프에서 제거하므로 tmp의 진입차수가 1줄어든다.
                if (topo[tmp] == 0) { // 진입차수가 0이면 더이상 누구를 기다릴 필요 없이 새로운 시작점이 된다. queue아 담는다.
                    queue.offer(tmp);
                }
            }
        }
        System.out.println(sb.toString());

    }

}
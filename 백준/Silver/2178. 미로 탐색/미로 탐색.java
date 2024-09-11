import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception{
        // N, M으로 가는 최소 블럭 수 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        bfs(0, 0);
    }

    public static void bfs(int y, int x){
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(y, x, 1));
        visit[y][x] = true;  // 시작점을 큐에 추가할 때 방문 처리

        while(!q.isEmpty()){
            Pos curr = q.poll();

            // 목적지 확인
            if(curr.y == N-1 && curr.x == M-1){
                System.out.println(curr.depth);
                return;
            }

            for(int d = 0; d < 4; d++){
                int ny = curr.y + dy[d];
                int nx = curr.x + dx[d];

                // 범위를 벗어나거나 이미 방문했거나 벽이면 continue
                if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == '0') continue;

                q.add(new Pos(ny, nx, curr.depth + 1));
                visit[ny][nx] = true;  // 큐에 추가할 때 방문 처리
            }
        }
    }

    public static class Pos{
        int x;
        int y;
        int depth;

        public Pos(int y, int x, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
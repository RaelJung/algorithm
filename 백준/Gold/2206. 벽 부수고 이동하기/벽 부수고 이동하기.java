import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer = -1;
    static char[][] map;
    static boolean[][][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M][2];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        bfs();

        System.out.println(answer);
    }

    public static void bfs(){
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 1, false));   // 0,0 시작
        visit[0][0][0] = true; //시작점 방문처리

        while(!q.isEmpty()){
            Pos curr = q.poll();

            // case 0: 목적지에 도착함
            if(curr.x==M-1 && curr.y==N-1){
                answer = curr.depth;
                return;
            }
            
            for(int d=0; d<4; d++){
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                // case 1: 배열 밖을 벗어남
                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;

                // case 2: 벽을 만남(그리고 아직 벽을 뚫지 않음)
                if(!visit[ny][nx][1] && !curr.isBreak && map[ny][nx] == '1'){
                    q.add(new Pos(nx, ny, curr.depth+1, true));   // 벽을 뚫었음을 명시
                    visit[ny][nx][1] = true;        // 벽 뚫었을 경우 방문 체크
                }

                // case 3: 그냥 길
                else if(map[ny][nx] == '0'){
                    // 벽을 부순 적 없는 경우
                    if(!curr.isBreak && !visit[ny][nx][0]){
                        q.add(new Pos(nx, ny, curr.depth+1, curr.isBreak));
                        visit[ny][nx][0] = true;        // 벽 안 뚫었을 경우 방문 체크
                    }
                    else if(curr.isBreak && !visit[ny][nx][1]){
                        q.add(new Pos(nx, ny, curr.depth+1, curr.isBreak));
                        visit[ny][nx][1] = true;        // 벽 뚫었을 경우 방문 체크
                    }
                }
            }

        }
    }

    public static class Pos{
        int x;
        int y;
        int depth;
        boolean isBreak;

        public Pos(int x, int y, int depth, boolean isBreak){
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.isBreak = isBreak;
        }
    }
    
}
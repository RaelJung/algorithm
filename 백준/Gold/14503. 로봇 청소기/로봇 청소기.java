import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cnt=0;
    static int sx, sy;
    static int[][] map;

    //0:북 1:동 2:남 3:서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        //시작점 및 방향 d 입력 받기
        sy = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleanRoom(sy,sx, d);

        System.out.println(cnt);
    }

    public static void cleanRoom(int y, int x, int d){
        //1. 현재 칸 청소
        if(map[y][x] == 0){
            map[y][x] = 2;
            cnt++;
        }
    
        //2. 4방향 탐색
        for(int i=0; i<4; i++){
            int nd = (d + 3 - i) % 4; // 반시계 방향으로 탐색
            int ny = y + dy[nd];
            int nx = x + dx[nd];
    
            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(map[ny][nx] == 0){ // 미청소 구역 발견
                cleanRoom(ny, nx, nd);
                return;
            }
        }
    
        //3. 네 방향 모두 청소 or 벽일 경우 → 뒤로 이동
        int back = (d + 2) % 4;
        int ny = y + dy[back];
        int nx = x + dx[back];
    
        if(nx < 0 || ny < 0 || nx >= M || ny >= N || map[ny][nx] == 1) return; // 벽이면 종료
        cleanRoom(ny, nx, d); // 방향 유지한 채 뒤로 이동
    }
    
}

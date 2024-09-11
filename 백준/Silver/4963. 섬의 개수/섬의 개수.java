import java.io.*;
import java.util.*;

public class Main {
    static int N, M, num=0;
    static int[][] map;
    //상,하,좌,우,좌상,우상,좌하,우하
    static int[] dy = {-1,1,0,0,-1,-1,1,1};
    static int[] dx = {0,0,-1,1,-1,1,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            num = 0;

            if(N==0 && M==0) break;

            map = new int[N][M];
            
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    int n = Integer.parseInt(st.nextToken());
                    //입력 받을 때, 1을 -1로 변환
                    if(n == 1) map[i][j] = -1;
                    else map[i][j] = n;
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    //bfs 들어갈 때 마다 num 추가
                    if(map[i][j] == -1){
                        num++;
                        bfs(new Pos(i, j));
                    }
                }
            }

            System.out.println(num);
        }
    }

    public static void bfs(Pos start){
        Queue<Pos> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            Pos curr = q.poll();
            int x = curr.x;
            int y = curr.y;

            for(int d=0; d<8; d++){
                int ny = y+dy[d];
                int nx = x+dx[d];

                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
                if(map[ny][nx] == -1){
                    q.add(new Pos(ny, nx));
                    map[ny][nx] = num;
                }
            }
        }
    }

    public static class Pos{
        int y;
        int x;

        public Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
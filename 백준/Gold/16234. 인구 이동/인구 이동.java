import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R, result;
    static int[][] map;
    static boolean[][] visit;

    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    //인구 이동 리스트
    static ArrayList<Pos> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //인구 이동 반복
        move();

        System.out.println(result);
    }

    static void move(){
        result = 0;

        //인구 이동 가능할 때까지 반복
        while(true) {
            boolean isMove = false;
            visit = new boolean[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    // 방문하지 않은 곳이라면 bfs!
                    if(!visit[i][j]) {
                        //열릴 수 있는 국경선 확인 하며 인구 이동할 총 인구수 반환
                        int sum = bfs(i, j); 
                        if(list.size() > 1) {
                            calculate(sum);     //인구 수 변경
                            isMove = true;
                        }    
                    }
                }
            }
            if(!isMove) return;
            result++;
        }
    }

    static class Pos{
        int x;
        int y;
        
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int bfs(int y, int x){
        Queue<Pos> q = new ArrayDeque<Pos>();   //bfs 계산에 사용할 큐
        list = new ArrayList<>();   //이동할 애들 초기화

        q.add(new Pos(x,y));
        list.add(new Pos(x,y));
        visit[y][x] = true;

        int sum = map[y][x];
        while(!q.isEmpty()){
            Pos curr = q.poll();
            
            for(int d=0; d<4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if(nx<0 || ny<0 || nx>=N || ny>=N || visit[ny][nx]) continue;

                int val = Math.abs(map[curr.y][curr.x] - map[ny][nx]);
                //L,R 사이라면 이동 가능
                if(L <= val && val <= R) {
                    q.add(new Pos(nx, ny));
                    list.add(new Pos(nx, ny));

                    sum += map[ny][nx];
                    visit[ny][nx] = true;
                }        
                
            }
        }

        return sum;
    }

    public static void calculate(int sum) {
        int avg = sum / list.size();
        for(Pos p : list) {
            map[p.y][p.x] = avg;
        }
    }
}
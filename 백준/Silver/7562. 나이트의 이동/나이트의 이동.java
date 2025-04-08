import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int T, l;
    static int[][] map;
    static boolean[][] visit;
    //왼쪽 아래*2, 오른쪽 아래*2, 오른쪽 위*2, 왼쪽 위*2
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws Exception{
        // 경로 찾기니깐 BFS
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        // 하나씩 줄며 반복
        for(int i=1; i<=T; i++){
            l = sc.nextInt();   // 체스판 크기
            map = new int[l][l];
            visit = new boolean[l][l];

            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();

            // 테케마다 출력
            System.out.println(bfs(sx, sy, ex, ey));
        }
        sc.close();
    }

    public static int bfs(int sx, int sy, int ex, int ey){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});     //시작점 삽입
        visit[sx][sy] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];

            // 도착점일 경우 반환
            if(cx == ex && cy == ey){
                return map[cx][cy];
            }

            // 아니라면
            for(int d=0; d<8; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx < 0 || ny < 0 || nx >= l || ny >= l || visit[nx][ny]){
                    continue;
                }

                visit[nx][ny] = true;
                map[nx][ny] = map[cx][cy] + 1;
                q.offer(new int[]{nx, ny});
            }

        }


        return -1; // 오류
    }
}

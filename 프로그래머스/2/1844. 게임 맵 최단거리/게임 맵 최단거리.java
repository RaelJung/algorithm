import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int map[][];
    static boolean visit[][];
    static int n, m;

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        
        map = maps;
        n = maps.length;
        m = maps[0].length;
        
        visit = new boolean[n][m];
        
        return bfs(0, 0);
    }
    
    static int bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x, 1}); // {현재 y 좌표, 현재 x 좌표, 현재까지의 이동 거리}
        visit[y][x] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int curY = current[0];
            int curX = current[1];
            int depth = current[2];
            
            // 목표 지점에 도달한 경우
            if(curY == n-1 && curX == m-1){
                return depth;
            }
            
            // 네 방향으로 이동
            for(int d=0; d<4; d++){
                int ny = curY + dy[d];
                int nx = curX + dx[d];
                
                // 맵의 범위를 벗어나는지, 방문했는지, 벽인지 체크
                if(ny<0 || nx<0 || ny>=n || nx>=m) continue;
                if(map[ny][nx] == 0 || visit[ny][nx]) continue;
                
                visit[ny][nx] = true;
                queue.add(new int[] {ny, nx, depth+1});
            }
        }
        
        // 목표 지점에 도달하지 못한 경우
        return -1;
    }
}

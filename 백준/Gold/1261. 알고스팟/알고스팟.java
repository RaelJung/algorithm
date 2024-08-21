import java.util.LinkedList;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] maze;
    static int[][] dist;
    
    static int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        maze = new int[N][M];
        dist = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE; // 초기 거리 값을 최대값으로 설정
            }
        }
        
        bfs();
        System.out.println(dist[N-1][M-1]); // 목표 지점까지의 최소 벽 부수기 횟수
    }

    static void bfs() {
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[] {0, 0});
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    int cost = dist[x][y] + maze[nx][ny];
                    if (cost < dist[nx][ny]) {
                        dist[nx][ny] = cost;
                        if (maze[nx][ny] == 0) {
                            deque.addFirst(new int[] {nx, ny}); // 벽이 없으면 덱의 앞쪽에 추가
                        } else {
                            deque.addLast(new int[] {nx, ny}); // 벽이 있으면 덱의 뒤쪽에 추가
                        }
                    }
                }
            }
        }
    }
}
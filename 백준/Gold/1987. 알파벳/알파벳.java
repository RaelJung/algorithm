import java.util.Scanner;

public class Main {
    static int R, C;
    static char[][] board;
    static boolean[] visited = new boolean[26]; // 알파벳 방문 여부 체크
    static int maxCount = 0;
    
    // 상하좌우 이동을 위한 방향 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        board = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            board[i] = sc.next().toCharArray();
        }
        
        // 첫 번째 칸의 알파벳 방문 처리 후 DFS 시작
        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        
        System.out.println(maxCount);
    }
    
    static void dfs(int x, int y, int count) {
        maxCount = Math.max(maxCount, count);
        
        // 상하좌우로 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < R && ny < C) { // 보드 범위 내인지 확인
                int index = board[nx][ny] - 'A';
                if (!visited[index]) { // 아직 방문하지 않은 알파벳이라면
                    visited[index] = true;
                    dfs(nx, ny, count + 1);
                    visited[index] = false; // 백트래킹
                }
            }
        }
    }
}
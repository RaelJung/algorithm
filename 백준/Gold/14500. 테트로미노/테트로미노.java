import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;

                checkExtraShape(i, j); // ㅗ,ㅜ,ㅏ,ㅓ 처리
            }
        }

        System.out.println(max);
    }

    // 일반적인 DFS로 4칸 탐색
    static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum + map[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

    // DFS로 처리 못하는 'ㅗ', 'ㅜ', 'ㅏ', 'ㅓ' 모양 따로 처리
    static void checkExtraShape(int x, int y) {
        // 중심을 기준으로 ㅗ 모양 (네 방향 가능)
        int[][][] shapes = {
            {{0, 0}, {-1, 0}, {0, -1}, {0, 1}}, // ㅗ
            {{0, 0}, {1, 0}, {0, -1}, {0, 1}},  // ㅜ
            {{0, 0}, {0, -1}, {-1, 0}, {1, 0}}, // ㅓ
            {{0, 0}, {0, 1}, {-1, 0}, {1, 0}},  // ㅏ
        };

        for (int[][] shape : shapes) {
            int tempSum = 0;
            boolean isValid = true;

            for (int[] block : shape) {
                int nx = x + block[0];
                int ny = y + block[1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    isValid = false;
                    break;
                }

                tempSum += map[nx][ny];
            }

            if (isValid)
                max = Math.max(max, tempSum);
        }
    }
}

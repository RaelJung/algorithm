import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static int squareCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 풀이
        for (int i = 0; i < R; i++) {
            rotate();
        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void rotate() {
        int sy = 0, ey = N - 1;
        int sx = 0, ex = M - 1;
        while (true) {
            // end check
            if (ey - sy < 1 || ex - sx < 1)
                return;

            // 회전
            // 왼쪽 위 값을 tmp
            int tmp = map[sy][sx];
            // top 좌로 이동
            for (int i = sx; i < ex; i++) {
                map[sy][i] = map[sy][i + 1];
            }
            // right 위로 이동
            for (int i = sy; i < ey; i++) {
                map[i][ex] = map[i + 1][ex];
            }
            // bottom : 우로 이동
            for (int i = ex; i > sx; i--) {
                map[ey][i] = map[ey][i - 1];
            }
            // left : 하로 이동
            for (int i = ey; i > sy; i--) {
                map[i][sx] = map[i - 1][sx];
            }

            map[sy + 1][sx] = tmp;

            // 가운데로 sy, sx, ey, ex 보정
            sy += 1;
            sx += 1;
            ey -= 1;
            ex -= 1;
        }

    }
	
}
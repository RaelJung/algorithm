import java.util.Scanner;

public class Solution {
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static int dd[] = {0, 1, 2, 3};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
            
			int n = 1, x = 0, y = 0, d = 0;
			while(n <= N * N) {
				int X = x + dx[dd[d]], Y = y + dy[dd[d]];
                //유효 체크
				if(X < 0 || X >= N || Y < 0 || Y >= N || arr[X][Y] != 0) {
					d = (d + 1) % 4; // 방향 바꾸기
					X = x + dx[dd[d]]; Y = y + dy[dd[d]];
				}
				arr[x][y] = n++;
				x = X; y = Y;
			}
            
			System.out.println("#" + t);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		}
	}
}
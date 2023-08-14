import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int spaces[][];
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        spaces = new int[N][N];

        for (int r = 0; r < N; r++) {
        	String str = br.readLine();
            for (int c = 0; c < N; c++) {
                spaces[r][c] = str.charAt(c)-'0';
            }
        }
        makeSpace(0,0, N);
    }

    private static void makeSpace(int sr, int sc, int size) { // 영역의 좌상단 r, c, 영역 크기 size
        int sum = 0;
        for (int r = sr; r < sr + size; r++) {
            for (int c = sc; c < sc + size; c++) {
                sum += spaces[r][c];
            }
        }

        if (sum == 0) { // 모두 하얀색인 공간(기저 조건): size가 1이면 재귀호출 안됨
          System.out.print(0);

        } else if (sum == size * size) { // 모두 검은색인 공간(기저조건) : size가 1이면 재귀호출 안됨
        	System.out.print(1);

        } else {// 두 색이 섞여있는 공간
            int half = size / 2;
            System.out.print("(");
            makeSpace(sr, sc, half); // 1
            makeSpace(sr, sc + half, half); // 2
            makeSpace(sr + half, sc, half); // 3
            makeSpace(sr + half, sc+ half, half); // 4
            System.out.print(")");
        }

    }
}
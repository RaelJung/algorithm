import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Top-Down 방식
public class Main {
    static int n;
    static char[][] map;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new char[n][n];

        for(int i= 0; i<n; i++) {
                map[i]= br.readLine().toCharArray();
        }
        // 풀이
        divide(0, 0, n);
        System.out.println(sb.toString());
    }

    // 시작점 y, x에서 너비 높이 n영역이 모두 같은 문자인지 확인 
    static boolean check(int y, int x, int n) {
        char ch = map[y][x];
        for(int i = y; i<y+n; i++) {
            for(int j =x; j<x+n;j++) {
                if(ch != map[i][j]) {
                    return false;
                }
            }
        }
        // 이 영역의 모든 문자가 같다.
        sb.append(ch);
        return true;
    }

    static void divide(int y, int x, int n) {
        // check() true/false 구분
        if(!check(y, x, n)) {
            //() + 4분할 결과
            // 너비를 반으로 줄인다.
            int half = n/2;
            sb.append("(");
            divide(y, x, half);
            divide(y, x+half, half);
            divide(y+half, x, half);
            divide(y+half, x+half, half);
            sb.append(")");
        }
    }


}
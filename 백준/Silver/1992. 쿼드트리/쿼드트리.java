import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Bottom-Up 방식
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
        System.out.println(divide(0, 0, n));
        
    }

    static String divide(int y, int x, int n) {
    	if(n==1) return String.valueOf(map[y][x]);

        //() + 4분할 결과
        int half = n/2;
        String ret1 = divide(y, x, half);
        String ret2 = divide(y, x+half, half);
        String ret3 = divide(y+half, x, half);
        String ret4 = divide(y+half, x+half, half);
        
        if(ret1.length() == 1 && ret1.equals(ret2) && ret1.equals(ret3) && ret1.equals(ret4)) {
        	return ret1;
        }
        else {
        	StringBuilder sb = new StringBuilder();
        	sb.append("("+ret1+ret2+ret3+ret4+")");
        	return sb.toString();
        }
    }


}
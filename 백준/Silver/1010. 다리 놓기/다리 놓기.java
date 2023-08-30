import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, N, M;
	static int memoi[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			memoi = new int[M+1][N+1];
			for(int i=1; i<=M; i++) {
				//nC0이 되어야 하므로 j=0부터 시작
				for(int j=0; j<=N; j++) {
					if(i==0 || j==0 || i==j) {
						memoi[i][j] = 1;
					}
					else {
						memoi[i][j] = memoi[i-1][j-1] + memoi[i-1][j];
					}
				}
			}
			
			System.out.println(memoi[M][N]);
		}
	}
}
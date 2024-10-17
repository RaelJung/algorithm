import java.io.*;
import java.util.*;

class Main {
	static int N, X, Y;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			X = Math.abs(X);
			Y = Math.abs(Y);
			
			//총 이동거리와 맨허튼 거리 판단
			//거리가 작거나 같고, 남은 거리가 짝수일 때
			int sum = X+Y;
			if(sum <= N && (N-sum)%2 == 0) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
}
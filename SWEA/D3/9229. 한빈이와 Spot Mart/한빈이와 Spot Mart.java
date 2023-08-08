import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N,M,TC;
	static int[] cookie;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			cookie = new int[N];
			StringBuilder sb = new StringBuilder();
			
			st = new StringTokenizer(br.readLine());
			//배열에 입력 넣기
			for(int i=0; i<N; i++) {
				cookie[i] = Integer.parseInt(st.nextToken());
			}
			
			//max값과 비교
			int max=-1; 
			
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					int sum = cookie[i]+cookie[j];
					if(sum <= M && sum > max) max = sum;
				}
			}
			
			sb.append("#").append(t).append(" ").append(max);
			System.out.println(sb.toString());
		}
	}
}
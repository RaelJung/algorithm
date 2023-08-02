import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int nums[];
	static int N,M;
	
	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 
		 st = new StringTokenizer(br.readLine());
		 nums = new int[N+1];
		 nums[0] = 0;
		 
		 for(int i=1; i<=N; i++) {
			 nums[i] = Integer.parseInt(st.nextToken()) + nums[i-1];
		 }
		 
		 for(int i=0; i<M; i++) {
			 st = new StringTokenizer(br.readLine());
			 int s_idx = Integer.parseInt(st.nextToken());
			 int e_idx = Integer.parseInt(st.nextToken());
			 
			 System.out.println(nums[e_idx]-nums[s_idx-1]);
		 }
	}
}
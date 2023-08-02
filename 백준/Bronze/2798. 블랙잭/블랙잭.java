import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0802 BOJ_2798_블랙잭
public class Main {
	static int N,M;
	static int nums[];
	static int tgt[] = new int[3];
	static int max=0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0,0);
		System.out.println(max);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		//기저조건
		if(tgtIdx == tgt.length) {
			int sum=0;
			for(int i=0; i<3; i++) sum+=tgt[i];
			if(sum <= M && max < sum) max = sum;
			return;
		}
		
		if(srcIdx == nums.length) return;
		tgt[tgtIdx] = nums[srcIdx];
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1, tgtIdx);
	}
}
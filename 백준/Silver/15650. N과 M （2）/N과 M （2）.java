import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//0802 BOJ_15650_N과M(2)
public class Main {
	static int[] src;
	static int[] tgt;
	static int N,M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		for(int i=1; i<=N; i++) {
			src[i-1] = i;
		}
		tgt = new int[M];
		
		comb(0,0);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		//기저조건
		if(tgtIdx == tgt.length) {
			System.out.println(Arrays.toString(tgt)
									.replaceAll("\\[", "")
									.replaceAll(",", "")
									.replaceAll("\\]", ""));
			return;
		}
		
		//종료 조건(for문 대신)
		if(srcIdx == src.length) return;
		
		tgt[tgtIdx] = src[srcIdx];
		comb(srcIdx+1, tgtIdx+1);	//다음 tgt에 대한 다음 src
		comb(srcIdx+1, tgtIdx);		//현재 tgt에 대한 다음 src
	}
}

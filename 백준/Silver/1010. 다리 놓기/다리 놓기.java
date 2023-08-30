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
			
			memoi = new int[M+1][N+1];		//0은 더미
			
			comb(M,N);
			
			System.out.println(memoi[M][N]);
		}
	}
	
	public static int comb(int srcIdx, int tgtIdx) {
		if(srcIdx == tgtIdx || tgtIdx==0) {
			return memoi[srcIdx][tgtIdx] = 1;
		}
		
		//이미 계산했으면 그걸 이용
		if(memoi[srcIdx][tgtIdx] > 0) return memoi[srcIdx][tgtIdx];
		//아직 계산된 값이 없으면 선택, 비선택 두 가지 경우의 수를 모두 구한 뒤에 합친다.
		return memoi[srcIdx][tgtIdx] = comb(srcIdx-1, tgtIdx-1) + comb(srcIdx-1, tgtIdx);
	}
}
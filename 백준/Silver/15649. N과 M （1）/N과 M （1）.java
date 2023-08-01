import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] num;
	static int[] tgt;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		for(int i=1; i<=N; i++) {
			num[i-1] = i;
		}
		select = new boolean[num.length];
		tgt = new int[M];
		
		perm(0);
	}
	
	//재귀호출구조
	//tgtIdx 자리에 수를 채우는 작업
	static void perm(int tgtIdx) {
		//기저조건
		if(tgtIdx == tgt.length) {
			//complete code
			System.out.println(Arrays.toString(tgt).replaceAll("\\[","").replaceAll("\\]","").replaceAll(",",""));
			return;
		}

		//tgtIdx에 놓을 수를 선택 <= src 배열 모든 수를 대상
		for(int i=0; i<num.length; i++) {
			//이전에 선택된 수는 제외
			if(select[i]) continue;
			//i번째 수는 아직 사용되지 않은 수
			tgt[tgtIdx] = num[i];
			select[i] = true;	//현재 자리를 사용했다.
			perm(tgtIdx+1);		//다음 자리 고려
			select[i] = false;	//현재 자리 수 사용 원복
		}
	}
}

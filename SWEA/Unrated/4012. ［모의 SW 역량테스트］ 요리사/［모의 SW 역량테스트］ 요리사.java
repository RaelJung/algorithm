import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, halfN, T, min;
	static int[][] map;
	static boolean[] select;		//재료 선택 / 비선택
	static int arrA[], arrB[];		//
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			halfN = N/2;
			map = new int[N][N];
			select = new boolean[N];
			arrA = new int[halfN];
			arrB = new int[halfN];
			
			//입력
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//풀이
			min = Integer.MAX_VALUE;
			comb(0, 0);
			
			sb.append("#"+t+" "+min+"\n");
		}
		
		System.out.println(sb);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		//기저조건
		if(tgtIdx == halfN) {
			//complete code
			check();
			
			return;
		}
		
		if(srcIdx == N) return;
		
		select[srcIdx] = true;
		comb(srcIdx + 1 , tgtIdx + 1);		//현재 src를 tgt에 선택
		select[srcIdx] = false;
		comb(srcIdx+1, tgtIdx);
		
	}
	
	//select 배열에서 선택, 비선택 => 2그룹 나누어서 생각
	//각각의 그룹별  sum 계산 후, 차이 계산 후, min 계산
	static void check() {
		int sumA = 0;	//선택
		int sumB = 0;	//비선택
		
		int idxA = 0;	//arrA idx
		int idxB = 0;	//arrB idx
		
		//select[] -> arrA, arrB
		for(int i=0; i<N; i++) {
			if(select[i]) arrA[idxA++] = i;
			else arrB[idxB++] = i;
		}
		
		//2개로 나뉜 각 재료 배열에서 서로 모두 만나게 for-for
		for(int i=0; i<halfN; i++) {
			for(int j=0; j<halfN; j++)
			{		
				if(i==j) continue;
				sumA += map[arrA[i]][arrA[j]];
				sumB += map[arrB[i]][arrB[j]];
				
			}
		}
		
		min = Math.min(min, Math.abs(sumA - sumB));
	}
	
}
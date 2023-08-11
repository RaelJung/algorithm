import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//0811 BOJ_15686_치킨배달
public class Main {
	static int N, M, min, houseSize, srcSize;
	static List<int[]> house, src, tgt;
	static int[] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		house = new ArrayList<>();
		src = new ArrayList<>();
		tgt = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//2차원 배열 입력을 받으면서 집, 치킨집에 대해서 자료구조를 정리
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken()); 
				if(num == 1) house.add(new int[] {i,j});
				else if(num == 2) src.add(new int[] {i,j});
			}
		}
		
		//풀이
		min = Integer.MAX_VALUE;
		houseSize = house.size();
		srcSize = src.size();

		//조합
		comb(0,0);
		System.out.println(min);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		//기저 조건
		if(tgtIdx == M) {
			//complete code
			//치킨집 M개를 조합으로 뽑은 상태
			//치킨 거리 계산
			//모든 집 각각에 대해서 뽑힌 M개의 치킨집 거리 중 최소의 것을 찾아야함
			int sum=0;		//현재 조합의 치킨 거리의 총합
			for(int i=0; i<houseSize; i++) {
				int dist = Integer.MAX_VALUE;
				int[] h = house.get(i);
				
				for(int j=0; j<M; j++) {
					int[] c = tgt.get(j);
					dist = Math.min(dist, Math.abs(h[0]-c[0])+Math.abs(h[1]-c[1]));
					
				}
				sum+=dist;
			}
			min=Math.min(min, sum);
			return;
		}
		if(srcIdx == srcSize) return;
		
		tgt.add(src.get(srcIdx));		//선택
		comb(srcIdx+1, tgtIdx+1);		//선택 O
		tgt.remove(src.get(srcIdx));	//선택 원복
		comb(srcIdx+1, tgtIdx);			//선택 X <= 배열은 자연스럽게 다음 인덱스를 덮어쓰는 구조 (원복 필요)
	}
	
	
}
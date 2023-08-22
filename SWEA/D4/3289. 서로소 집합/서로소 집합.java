import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	//서로소 집합을 표현하는 1차원 배열
	static int[] parents;
	static int T, N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			makeSet();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int opt = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(opt == 0) {
					union(a,b);
				}
				else if(opt == 1) {
					if(findSet(a) == findSet(b)) sb.append("1");
					else sb.append("0");
				}
				
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	//서로소 집합을 표현하는 자료구조 생성 및 초기화
	static void makeSet() {
		parents = new int[N+1];		//0은 더미
		
		for (int i = 1; i <=N; i++) {
			parents[i] = i;
		}
	}
	
	//소속된 서로소 집합의 대표 원소를 리턴
	static int findSet(int x) {
		//기저조건
		//value와 index 같은 조건
		if(parents[x] == x) return x;
//		else return findSet(parents[x]);	//path compression X
		else return parents[x] = findSet(parents[x]);	//path compression O
	}
	
	//두 서로소 집합을 하나로 합친다.
	//x의 대표자, y의 대표자 찾아서 합치기
	static void union(int x, int y) {
		int px = findSet(x);	//x의 최종 대표자 집합 원소
		int py = findSet(y);	//y의 최종 대표자 집합 원소
		
		//만약 px == py <= x, y는 같은 서로소 집합에
		//그렇지 않으면 <= x, y는 서로 다른 서로소 집합에
		parents[py] = px;
	}
}
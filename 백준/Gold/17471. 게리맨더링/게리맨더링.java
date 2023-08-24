import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

//부분집합을 통해서 A, B 두 개의 그룹으로 나누고 각각 연결여부 bfs, dfs로 확인 후  - 최소값 갱신
public class Main {
	static int N, min;
	static int[][] matrix;
	static boolean[] select;		//부분 집합 용도
	static boolean[] visit;			//bfs, dfs 중복 check
	
	static Queue<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//자료구조
		matrix = new int[N+1][N+1];		//0 dummy
		select = new boolean[N+1];
		visit = new boolean[N+1];
		min = Integer.MAX_VALUE;
		
		//인구수 -> 별도의 자료구조 대신 matrix[v][0]을 활용
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken());
		}
		//그래프 인접 행렬
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());		//i 인접한 구역의 수
			for(int j=1; j<=n; j++) {
				int v = Integer.parseInt(st.nextToken());
				matrix[i][j] = v;
			}
		}
		
		//부분집합
		subset(1);		//1부터 
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	}
	
	//sel->true: A, false: B
	static void dfs(int v, boolean sel) {
		visit[v] = true; 	//해당 정점 방문
		for(int i=1; i<=N; i++) {
			int adj = matrix[v][i];
			if(adj != 0 && !visit[adj] && select[adj] == sel) {
				dfs(adj, sel);
			}
		}
	}
	
	static void check() {
		//두 그룹이 각각 유효한지 따진다. (연결)
		//그룹별로 따지되, 양쪽 다 연결 여부를 확인
		//bfs로 각각 갈 수 있는 곳으로 가서 visit -> true
		//두 그룹을 모두 따지고 나면 visit 전체 true? 일부가 false가 되어있는지?
		
		Arrays.fill(visit, false);
		q.clear();
		
		// A - select: true
		int a = -1;		//A 그룹의 dfs 시작 정점
		for(int i=1; i<=N; i++) {
			//선택된 한 정점만 queue에 넣고 bfs
			if(select[i]) {
				//선택한 정점에서 dfs
				a = i;
				break;
			}
		}
			
		//선택된 애 없으면
		if(a == -1) return;
		
		dfs(a, true);
		
		// B - select: false
		int b = -1;
		for(int i=1; i<=N; i++) {
			//선택된 한 정점만 queue에 넣고 bfs
			if(! select[i]) {
				b = i;
				break;
			}
		}
		
		//선택된 애 없으면
		if(b == -1) return;
		
		dfs(b, false);
		
		// A, B 모두 연결되어 있는지 visit[] 확인
		for(int i=1; i<=N; i++) {
			if(!visit[i]) return;		//연결되어 있지 X 것이 하나라도 있으면
		}
		
		//두 그룹을 나누었고, 모두 연결된 상태
		//두 그룹의 인구수의 차이를 계산, min 값과 비교
		int sumA = 0;
		int sumB = 0;
		
		for(int i=1; i<=N; i++) {
			if(select[i]) sumA += matrix[i][0];
			else sumB += matrix[i][0];
		}
		
		min = Math.min(min,  Math.abs(sumA - sumB));
	}
	
	static void subset (int srcIdx) {
		if(srcIdx == N+1) {
			//complete code
			//2개 구역으로 나뉜 상태
			check();
			
			return;
		}
		select[srcIdx] = true;	//선택
		subset(srcIdx+1);
		select[srcIdx] = false;	//비선택
		subset(srcIdx+1);
	}
}
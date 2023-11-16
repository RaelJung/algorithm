import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, res;
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2)->e1.c-e2.c);
	
	//서로소
	static int[] parent;
	
	static class Edge{
		int v1, v2, c;

		public Edge(int v1, int v2, int c) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		//정답 초기화
		res = 0;
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(v1, v2, c));
		}
		
		//서로소 초기화
		parent = new int[N+1];
		makeSet();
		
		//큐 돌면서 비용 계산
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			//사이클 없이 합쳐지면
			if(union(curr.v1,curr.v2)) {
				res+=curr.c;
			}
		}
		System.out.println(res);
	}
	
	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		//사이클 확인
		if(px == py) return false;
		//아니라면
		if(px < py) parent[py] = px;
		else parent[px] = py;
		return true;
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void makeSet() {
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
	}
}
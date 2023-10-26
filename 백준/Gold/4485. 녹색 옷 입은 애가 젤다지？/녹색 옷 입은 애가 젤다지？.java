import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>((e1,e2)->e1.c-e2.c);
	static final int INF = Integer.MAX_VALUE;
	static int[][] dist;
	
	static StringBuilder sb = new StringBuilder();
	
	static public class Edge{
		int x, y, c;

		public Edge(int y, int x, int c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t=1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			//matrix 초기화
			map = new int[N][N];
			dist = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = INF;
				}				
			}
			
			//다익스트라
			Dijkstra();		//시작은 어차피 0,0으로 고정
			sb.append("Problem "+t+": "+dist[N-1][N-1]+"\n");
			t++;
		}
		
		System.out.println(sb);
	}
	
	static void Dijkstra() {
		//시작점 초기화
		pq.add(new Edge(0,0,map[0][0]));
		dist[0][0] = map[0][0];
		
		//큐 돌기
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			//최소 비교
			//if(dist[curr.y][curr.x] < curr.c) continue;
			
			//사방 비교(다음 노드)
			for(int d=0; d<4; d++) {
				int ny = curr.y + dy[d];
				int nx = curr.x + dx[d];
				
				//범위 체크
				if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				
				//비용 비교
				if(dist[ny][nx] > curr.c+map[ny][nx]) {
					dist[ny][nx] = curr.c+map[ny][nx];
					pq.offer(new Edge(ny, nx, dist[ny][nx]));
				}
			}
		}
	}
}
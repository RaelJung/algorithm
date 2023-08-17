import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static int[][] adjMatrix;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N+1][N+1];	//0,0은 더미
		visit = new boolean[N+1];			//0은 더미
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			adjMatrix[v2][v1] = adjMatrix[v1][v2] = 1;
		}
		
		visit[V] = true;
		DFS(V);
		System.out.println();
		
		visit = new boolean[N+1];			//0은 더미
		visit[V] = true;
		BFS(V);
		
	}
	
	static void DFS(int n) {
		System.out.print(n+" ");
		
		for(int i=1; i<=N; i++) {
			if(adjMatrix[n][i] != 1 || visit[i]) continue;
						
			visit[i] = true;
			DFS(i);
		}
	}
	
	static void BFS(int n) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(n);
		visit[n] = true;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			
			System.out.print(v+" ");
			
			for(int i=1; i<=N; i++) {
				if(adjMatrix[v][i] != 1 || visit[i]) continue;
				
				queue.offer(i);
				visit[i] = true;
			}
		}
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//BFS로 풀기
public class Solution {
	static int T, N, NO, COUNT;		//NO: 시작 방 번호, COUNT: 가장 긴 이동 횟수 
	static int[][] room;

	static int[] dx = {0,0,-1,1};	//상하좌우
	static int[] dy = {-1,1,0,0};	//상하좌우
	static Queue<Node> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//초기화
			NO = 0;
			COUNT = 1;
			
			//풀이
			//모든 방에서 다 가본다. (완탐-bfs)
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++){
					queue.offer(new Node(i,j,room[i][j],1));
					bfs();
				}
			}
			sb.append("#").append(t).append(" ").append(NO).append(" ").append(COUNT);
			
			System.out.println(sb);
		}
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			//최대인가?
			if(node.cnt > COUNT) {
				COUNT = node.cnt;
				NO = node.no;
			}else if(node.cnt==COUNT) {
				NO = node.no < NO ? node.no : NO;	//Math.min()과 동일한 동작
			}
			
			//사방 탐색
			for(int d=0; d<4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				//유효범위 확인
				if(ny < 0 || nx < 0 || ny >= N || nx >= N || 
						room[ny][nx] != room[node.y][node.x]+1) continue;
				queue.offer(new Node(ny, nx, node.no, node.cnt+1));
				break; //조건에 맞는 방은 하나.
			}
		}
	}
	
	static class Node{
		int y,x,no,cnt;
		
		Node(int y, int x, int no, int cnt){
			this.y=y;
			this.x=x;
			this.no=no;
			this.cnt=cnt;
		}
	}
}
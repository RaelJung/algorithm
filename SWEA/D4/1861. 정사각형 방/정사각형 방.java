import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//DFS로 풀기
public class Solution {
	static int T, N, NO, COUNT;		//NO: 시작 방 번호, COUNT: 가장 긴 이동 횟수 
	static int[][] room;
	static int[][] memo;	//이미 방문한 곳의 결과를 기록

	static int[] dx = {0,0,-1,1};	//상하좌우
	static int[] dy = {-1,1,0,0};	//상하좌우
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			memo = new int[N][N];
			
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
					int no = room[i][j];
					int cnt = dfs(i, j);	//i,j에서 갈 수 있는 모든 곳을 간다.
					
					//최대인가?
					if(cnt > COUNT) {
						COUNT = cnt;
						NO = no;
					}else if(cnt==COUNT) {
						NO = no < NO ? no : NO;	//Math.min()과 동일한 동작
					}
				}
			}
			sb.append("#").append(t).append(" ").append(NO).append(" ").append(COUNT);
			
			System.out.println(sb);
		}
	}
	static int dfs(int y, int x) {
		//이미 방문해서 계산된 곳인지
		if(memo[y][x] != 0) return memo[y][x];
	
		//사방 탐색
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			//유효범위 확인
			if(ny < 0 || nx < 0 || ny >= N || nx >= N || 
					room[ny][nx] != room[y][x]+1) continue;
			return memo[y][x] = dfs(ny, nx) + 1;
		}
		//y,x에서 더이상 진행할 방이 없다면
		return memo[y][x]=1;
				
		//발생하는 문제 (2-3-4-5)라면, (3-4-5)와 같이 루트가 겹치는 문제가 발생.
		//memorization으로 해결
		//위를 사용하면, no, cnt를 기록할 필요 없다.
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, res;
	static int map[][];
	static int sx, sy;			//시작점(=도착점)
	//dfs
	//우하, 좌하, 좌상, 우상
	static int dy[] = {1,1,-1,-1};
	static int dx[] = {1,-1,-1,1};
	static boolean visit[];		//방문체크
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			//시작 초기화
			res = -1;
			
			//입력
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//탐색
			visit = new boolean[101];	//디저트 1~100
			//임의의 한 점 이므로 모든 점에서 돌아야 함
			for(int i=0; i<N; i++) {
				sy = i;
				for(int j=0; j<N; j++) {
					sx = j;
					dfs(sy, sx, 1, 0);		//현재 좌표, 디저트 개수, 방향
				}
			}
			
			
			sb.append("#").append(t)
			  .append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int y, int x, int cnt, int dir) {
		//현재 지점 방문체크
		visit[map[y][x]] = true;
		
		//사방향 탐색(단, 시작 방향에 주의)
		//이전 방향으로 돌아가면 사각형이 되지 않으므로
		for(int d=dir; d<4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			//1. 맵 범위 안에 드는지
			if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
			//2. 도착점에 도착 했는지(!!!단, 길이가 4이상이어야 함!!!)
			if(ny == sy && nx == sx && cnt >= 4) {
				res = Math.max(res, cnt);
				break;
			}
			//3. 방문 체크
			if(visit[map[ny][nx]]) continue;
			//4. 위의 상황 다 아니면
			dfs(ny, nx, cnt+1, d);		//d: 현재 방향
		}
		
		//방문 원복
		visit[map[y][x]] = false;
	}
	
}
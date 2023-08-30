import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int map[][];
	//[이동방향][y][x]
	//[0][4][3]: 대각선으로 4,3 좌표로 이동한 경우의 수(합)
	//[1][4][3]: 가로로 4,3 좌표로 이동한 경우의 수(합)
	//[2][4][3]: 세로로 4,3 좌표로 이동한 경우의 수(합)
	static int memoi[][][];		
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		memoi = new int[3][N+1][N+1];		//0,0은 더미
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//시작점
		memoi[1][1][2] = 1;
		
		//현재 위치에서 대각선으로, 가로로, 세로로 이동하는 값을 dp로 계산
		for(int y=1; y<=N; y++) {
			for(int x=2; x<=N; x++) {
				//대각선 memoi[0]
				//3방향 이동 가능
				if(y<N && x<N && map[y+1][x+1]==0 && map[y][x+1]==0 && map[y+1][x]==0) {
					//현재 y,x에서 대각선 y+1, x+1 가는 모든 경우의 수는
					//y,x로 올 때 대각선으로, 가로로, 세로로 오는 모든 경우의 수를 합친다.
					memoi[0][y+1][x+1] += (memoi[0][y][x] + memoi[1][y][x] + memoi[2][y][x]);
				}
				//가로 memoi[1]
				//2방향 이동 가능
				if(x<N && map[y][x+1]==0) {
					memoi[1][y][x+1] += (memoi[0][y][x] + memoi[1][y][x]);
				}
				//세로 memoi[2]
				//2방향 이동 가능
				if(y<N && map[y+1][x]==0) {
					memoi[2][y+1][x] += (memoi[0][y][x] + memoi[2][y][x]);
				}
			}
		}
		
		System.out.println(memoi[0][N][N] + memoi[1][N][N] + memoi[2][N][N]);
		
	}
}
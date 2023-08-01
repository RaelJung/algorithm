import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	//delta
	//왼 - 오 - 위
	static int[] dy = {0, 0, -1};
	static int[] dx = {-1, 1, 0};
	
	static int[][] ladder = new int[100][100];
	
	//시작좌표, 도착점
	static int sy, sx, ans;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			br.readLine(); 	//테케 번호 무시
			// ladder 초기화?
			// #1 ladder = new int[100][100]
			// #2 for - for 이용해서 ladder[i][j] = 0;
			// 이 문제는 초기화 필요 X
			
			// 입력
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//시작 좌표는 맨 밑에 있는 값이므로 별도로 for문 이용
			sy = 99;
			for(int k=0; k<100; k++) {
				if(ladder[99][k] == 2) {
					sx = k;
					break;
				}
			}
			
			//탐색 시작
			int dir = 2;	//시작 방향은 위
			while(true) {
				// 위
				if(dir == 2) {
					//왼-오-위 순서
					for(int d=0; d<3; d++) {
						int ny = sy + dy[d];
						int nx = sx + dx[d];
						
						if(nx >= 0 && nx < 100 && ladder[ny][nx]==1) {
							sy = ny;
							sx = nx;
							dir = d;
							break;		//방향이 선택되면 그 방향으로 이동해야 함.
						}
					}
				}
				// 옆
				else {
					//위로 가는 것을 우선순위!
					int ny = sy-1;
					int nx = sx;
					
					//위로 갈 수 있는 지 확인
					if(ladder[ny][nx]==1) {
						sy = ny;
						dir = 2;
					}
					//위로 못 가
					else{
						sx = sx+dx[dir];	//현재 방향으로 계속 더 이동
					}
				}
				//sy == 0 확인
				if (sy==0) {
					ans = sx;
					break;		//while문에 걸리는 break;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}

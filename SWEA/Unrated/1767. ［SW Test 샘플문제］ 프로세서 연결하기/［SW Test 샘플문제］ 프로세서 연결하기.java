import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N, max, totalCnt, min, map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayList<int[]> list;		//전선 놓을 코어리스트
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());	//멕시노스 크기
			map = new int[N][N];
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;		//연결해야하는 코어 개수
			list = new ArrayList<int[]>();
			
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					//가장자리 코어 제외(행이 0, N-1, 열이 0, N-1)
					if((i==0 || i==N-1 || j==0 || j==N-1) && map[i][j]==1) continue;
					//가장자리 코어 아닌 코어 발견
					if(map[i][j] == 1) {
						list.add(new int[] {i,j});
						totalCnt++;
					}
				}
			}
			go(0, 0);
			System.out.println("#"+tc+" "+min);
		}
	}
	
	//코어를 선택(4방향 시도)/비선택
	//index: 고려해야할 코어의 index,coreCnt: 연결된 코어 개수
	private static void go(int index, int coreCnt) {		 
		//가지치기: 현재까지 연결된 코어 수 + 남은 코어 수 < 임시 최대 코어 연결 수
		if(coreCnt+(totalCnt-index)<max) return;
		
		//기저조건
		if(index == totalCnt) {
			int res = getLength();		//놓아진 전선의 길이의 합
			if(max < coreCnt) {
				max = coreCnt;
				min = res;
			}
			else if(max == coreCnt) {
				if(min > res) {
					min = res;
				}
			}
			
			return;
		}
		
		//현재 코어 정보 가져오기
		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		//코어 선택(4방향 시도)
		for(int d=0; d<4; d++) {
			//현재 코어의 위치에서 해당 방향으로 전선 놓기가 가능한지 체크
			if(!isAvailable(r,c,d)) continue;
			//가능하다면 전선 놓기
			setStatus(r,c,d,2);
			//다음 코어로 가기
			go(index+1, coreCnt+1);
			//새로운 방향을 시도하기 위해 놓았던 전선 원복
			setStatus(r,c,d,0);
		}
		
		//코어 비선택(coreCnt 변화 없음)
		go(index+1, coreCnt);
	}
	private static int getLength() {
		int lCnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==2) {
					lCnt++;
				}
			}
		}
		return lCnt;
	}
	
	private static void setStatus(int r, int c, int d, int status) {
		int nr = r;
		int nc = c;
		
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N) break;
			map[nr][nc] = status;
		}
	}
	
	private static boolean isAvailable(int r, int c, int d) {
		int nr = r;
		int nc = c;
		
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N) break;
			if(map[nr][nc] != 0) return false;
		}
		
		return true;
	}
}
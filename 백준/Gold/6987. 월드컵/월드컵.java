import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] win, lose, draw;		//승, 패, 무 저장
	static int[][] game;				//for=for match 진행을 이어갈 배열
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		win = new int[6];
		lose = new int[6];
		draw = new int[6];
		
		
		//게임 배열 2팀이 각각 1:1 시합을 이어나가는 형태 - 15개 게임
		//0 0 0 0 0 1 1 1 1 2 2 2 3 3 4
		//1 2 3 4 5 2 3 4 5 3 4 5 4 5 5
		game = new int [15][2];
		int idx = 0;
		
		for(int i=0; i<5; i++) {
			for(int j=i+1; j<6; j++) {
				game[idx][0] = i;
				game[idx][1] = j;
				idx++;
			}
		}
		
		//입력
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum=0;
			for(int j=0; j<6; j++) {		//팀 별 3개씩 끊어서
				sum += win[j] = Integer.parseInt(st.nextToken());
				sum += draw[j] = Integer.parseInt(st.nextToken());
				sum += lose[j] = Integer.parseInt(st.nextToken());
			}
			//유효하지 않음
			if(sum != 30) {
				System.out.print("0 ");
				continue;
			}
			
			//dfs 완전탐색
			if(dfs(0)) System.out.print("1 ");
			else System.out.print("0 ");
			
		}
	}
	
	//game 배열을 이용해서, 모든 1:1 게임을 순차적으로 진행하면서 win, draw, lose 자료구조의 유효성을 검증
	//가지치기 - win, lose, draw에 대해서 각 배열에 양수일 때만 진행
	//game 배열에 마지막까지 도달하면, 유효한 결과
	static boolean dfs(int idx) {
		//기저조건
		if(idx == 15) return true;	//자료구조 유효함
		
		int teamA = game[idx][0];
		int teamB = game[idx][1];
		
		//a팀이 이기는 경우
		if(win[teamA] > 0 && lose[teamB] > 0) {
			win[teamA]--;
			lose[teamB]--;
			
			//현재 게임의 결과를 계속 이어나갔을 때 이후 모든 결과가 올바르면 true
			if(dfs(idx+1)) return true;
			
			//원복
			win[teamA]++;
			lose[teamB]++;
		}
		//b팀이 이기는 경우
		if(win[teamB] > 0 && lose[teamA] > 0) {
			win[teamB]--;
			lose[teamA]--;
			
			//현재 게임의 결과를 계속 이어나갔을 때 이후 모든 결과가 올바르면 true
			if(dfs(idx+1)) return true;
			
			//원복
			win[teamB]++;
			lose[teamA]++;
		}
		//비기는 경우
		if(draw[teamA] > 0 && draw[teamB] > 0) {
			draw[teamA]--;
			draw[teamB]--;
			
			//현재 게임의 결과를 계속 이어나갔을 때 이후 모든 결과가 올바르면 true
			if(dfs(idx+1)) return true;
			
			//원복
			draw[teamA]++;
			draw[teamB]++;
		}
		
		return false;
	}
}
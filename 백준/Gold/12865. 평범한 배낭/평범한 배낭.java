import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int memoi[][];
	static int item[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//memoi 초기화
		memoi = new int[N+1][K+1];		//0은 더미
		
		//item 세팅
		item = new int[N+1][2];			//0은 더미
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken());
			item[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//가치 합의 최댓값
		//item
		for(int i=1; i<=N; i++) {
			for(int w=1; w<=K; w++) {
				//현재 item이 현재 무게에 선택 가능?
				if(item[i][0] <= w) {
					//선택 O
					//memoi[i-1][w] => i번째 item을 고려하기 전까지 w 무게를 만드는데 최상의 value
					int sel_o = memoi[i-1][w - item[i][0]] + item[i][1];
					
					//선택X
					int sel_x = memoi[i-1][w];
					memoi[i][w] = Math.max(sel_o, sel_x);
				}
				else {
					memoi[i][w] = memoi[i-1][w];
				}
			}
			
		}
		
		System.out.println(memoi[N][K]);
	}
}
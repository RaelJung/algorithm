import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int memoi[];
	static int item[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//memoi 초기화
		memoi = new int[K+1];		//0은 더미
		
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
			int w = item[i][0];
			int v = item[i][1];
			
			//큰 무게부터 작은 무게로 옮겨가기
			for(int k=K; k>=w; k--) {
				//memoi[w] => i번째 item을 고려하기 전까지 w 무게를 만드는데 최상의 value
				//memoi[w]를 새로운 현재 고려하는 값으로 덮어쓰지 않으면 이전 item을 고려한 최상의 value
				memoi[k] = Math.max(memoi[k], memoi[k-w]+v);
			}
			
		}
		
		System.out.println(memoi[K]);
	}
}
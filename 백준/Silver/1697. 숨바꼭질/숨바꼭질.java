import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//그래프를 사용하는 문제
//그래프의 최단을 구하기 -> BFS
//visit
public class Main {
	static int N, K;
	static Queue<Integer> q = new ArrayDeque<>();
	//boolean 대신 왜 int? visit 자체에 몇 번째 depth인지 기록하기 위함
	static int[] visit = new int[100001];		
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(N, K));
	}
	
	static int bfs(int N, int K) {
		//최단 단계(초)를 계산해서 return
		int minus = 0;
		int plus = 0;
		int multiply = 0;
		
		visit[N] = 0;		//true의 의미
		q.offer(N);
		
		while(!q.isEmpty()) {
			//꺼내서 k가 확인되면 종료
			int curr = q.poll();
			if(curr == K) break;
			
			//그렇지 않으면 +1, -1, *2에 대한 계산을 하고, 유효하면  queue에 넣기
			minus = curr-1;
			plus = curr+1;
			multiply = curr*2;
			
			//음수가 아니고, 아직 방문하지 않았다면
			if(minus >= 0 && visit[minus]==0 ) {
				//꺼낸 curr까지 온 depth 보다 한 번 더 계산
				visit[minus] = visit[curr] + 1;		
				q.offer(minus);
			}
			
			//10,000 넘지 않았고, 아직 방문하지 않았다면
			if(plus <= 100000 && visit[plus]==0 ) {
				//꺼낸 curr까지 온 depth 보다 한 번 더 계산
				visit[plus] = visit[curr] + 1;		
				q.offer(plus);
			}
			
			//10,000 넘지 않았고, 아직 방문하지 않았다면
			if(multiply <= 100000 && visit[multiply]==0 ) {
				//꺼낸 curr까지 온 depth 보다 한 번 더 계산
				visit[multiply] = visit[curr] + 1;		
				q.offer(multiply);
			}
		}
		//boolean의 방문 여부도 체크하지만, depth도 확인만 해줄 수 있음
		return visit[K];
	}
	
}
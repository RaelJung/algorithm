import java.io.BufferedReader;
import java.io.InputStreamReader;

//0808 SW_1233_사칙연산유효성검사
//Bottom-Up으로 유효성 봐야함 => dfs()
//1. 검증하는 노드가 숫자면 자식이 없는지 확인
//2. 검증하는 노드가 연산자이면 자식의 유효성에 의존 <= dfs()
public class Solution {
	static int N, ans;
	static char[] node;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			N = Integer.parseInt(br.readLine());
			node = new char[N+1];	// 0 dummy
			
			//두번째만 관리
			for(int i=1; i<=N; i++) {
				node[i] = br.readLine().split(" ")[1].charAt(0);	//1 - 2 3 에서 -만 취한다.
			}
			
			//완전 이진트리지만, 자식이 한쪽만 있는 경우
			if(N % 2 == 0) {
				sb.append("#").append(t).append(" ").append(0).append("\n");
				continue;	//다음 테케
			}
			
			//바닥에서부터 dfs(1) 수행되고, true면 1, false면 0을 가지도록.
			ans = dfs(1) ? 1 : 0;		
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	//x 위치의 노드가 유효한지 검사하고  return
	static boolean dfs(int x) {
		//기저조건
		if(x > N) return false;
		//숫자노드인지 아닌지 만약 숫자이면 자식이 없어야 한다.
		if(Character.isDigit(node[x])) {
			//자식 확인
			if(x*2 > N) return true;
			return false;
		}
		//숫자노드가 아니면 연산자이므로 두 자식의 유효성에 의존한다. (둘 다 true이면 true 리턴)
		else {
			return dfs(x*2) && dfs(x*2+1);
		}
	}
}
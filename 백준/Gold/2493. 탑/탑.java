import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//input의 길이가 꽤 크다. 50만개의 입력.
//Scanner, BufferedReader 성능 차이가 크다. => BufferedReader 사용.
//output도 크다 => StringBuilder
//자료구조 = 모두 다 담고 왔다갔다 하는 배열?? <= 불필요한 자료는 제거하는 stack
public class Main {
	static int N, idx;
	static Deque<int[]> stack = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			//stack에서 현재 높이보다 작은 애들은 제거, 큰 것이 나오면 그 큰 것의 번호를 출력해 추가.
			while(!stack.isEmpty()) {
				//자신보다 큰 경우
				if(stack.peek()[1] >= height) {
					sb.append(stack.peek()[0]+1).append(" ");
					break;
				}
				//height 보다 작으면 제거
				stack.pop();
			}
			//내가 제일 높으면
			if(stack.isEmpty()) sb.append("0 "); 
			//자기 자신 추가
			stack.push(new int[] {i, height});
		}

		System.out.println(sb.toString());
	}
}
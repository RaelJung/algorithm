import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	static int N, ans;
	static char[] chArray;
	static Deque<Character> stack = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			N = Integer.parseInt(br.readLine());
			chArray=br.readLine().toCharArray();
			
			stack.clear();
			ans=0; //false;
			
			for(int i=0; i<N; i++) {
				char token = chArray[i];
				
				//여는 문자 stack에 담는다.
				if(token == '<' || token == '{' || token == '(' || token == '[') {
					stack.push(token);
				}
				else {
					//시작부터 닫는 tag
					if(stack.isEmpty()) {
						stack.push(token);
						break;
					}
					char prev = stack.peek();
					//매칭 안되면 꺼내지 않고 break;
					if(token == '>' && prev != '<') break;
					else if(token == '}' && prev != '{') break; 
					else if(token == ')' && prev != '(') break; 
					else if(token == ']' && prev != '[') break;
					else stack.pop();	// 매칭이 되면 꺼낸다.
				}
			}
			//모두 매칭이 다 완료되면 stack은 empty
			if(stack.isEmpty()) ans=1;
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
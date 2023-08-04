import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static Queue<Integer> q = new ArrayDeque<>();
	static int N;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		while(q.size()>1) {
			q.poll();
			int m_num = q.poll();
			q.add(m_num);
		}
		
		System.out.println(q.peek());
	}
}
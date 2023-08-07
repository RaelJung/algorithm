import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//0807 링크드리스트
public class Solution {
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {	
			N = Integer.parseInt(br.readLine());
			LinkedList<Integer> l = new LinkedList<Integer>();
			StringBuilder sb = new StringBuilder();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			//원본 암호문 넣기
			for(int i=0; i<N; i++) {
				l.add(Integer.parseInt(st.nextToken()));
			}
			
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				st.nextToken();	//하나 버리고(연산자)
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				for(int j=0; j<y; j++) {
					l.add(x+j, Integer.parseInt(st.nextToken()));
				}
			}
			
			sb.append("#").append(t).append(" ");
			for(int i=0; i<10; i++) {
				sb.append(l.get(i)).append(" ");
			}
			System.out.println(sb.toString());
		}
	}
}
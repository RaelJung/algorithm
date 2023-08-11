import java.io.BufferedReader;
import java.io.InputStreamReader;

//greedy 
//3보다는 5를 많이 사용해야 유리
//5 사용할 대는 최대한 많이 사용해야 하고, 3을 사용할 때는 최대한 적게 사용해야 한다.
//5로 나누어지는 상황
//3
public class Main {
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int cnt = 0;
	
		while(true) {
			if(N < 0) {
				System.out.println(-1);
				break;
			}
			
			if(N % 5 == 0) {	//5 최대한 많이 사용
				System.out.println(N/5 + cnt);
				break;
			}
			else {		//5로 나눠떨어지지 않으면 3만큼 줄인다.
				N-=3;
				cnt++;
			}
		}
	}
}
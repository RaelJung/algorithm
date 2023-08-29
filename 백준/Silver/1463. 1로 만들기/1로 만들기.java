import java.util.Scanner;

public class Main {
	static int N;
	static int[] memoi;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		memoi = new int[N+1];
		memoi[1] = 0;		//명시적으로 표현
		
		for(int i=2; i<=N; i++) {
			memoi[i] = memoi[i-1]+1;
			
			if(i%2==0) memoi[i] = Math.min(memoi[i], memoi[i/2]+1);
			if(i%3==0) memoi[i] = Math.min(memoi[i], memoi[i/3]+1);
			
		}
		
		System.out.println(memoi[N]);
	}
	
}
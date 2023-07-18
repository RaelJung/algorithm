import java.util.Scanner;

//0718_BOJ_11659_구간합구하기4
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		//누적합 배열
		int nums[] = new int[N+1];
		
		nums[0] = 0;
		for(int i=1; i<=N; i++) {
			nums[i] = sc.nextInt()+nums[i-1]; 
		}
		
		for(int i=0; i<M; i++) {
			int s_idx = sc.nextInt();
			int e_idx = sc.nextInt();
	
			System.out.println(nums[e_idx] - nums[s_idx-1]);
		}
		
		sc.close();
	}
}
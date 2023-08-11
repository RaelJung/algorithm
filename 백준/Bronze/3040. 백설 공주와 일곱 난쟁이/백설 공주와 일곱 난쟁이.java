import java.util.Scanner;

public class Main {
	static int[] arr = new int[9];
	static int[] idx = new int[2];
	static int sum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(i!=j) {
					if(sum-(arr[i]+arr[j]) == 100) {
						idx[0] = i;
						idx[1] = j;
					}
				}
			}
		}
		
		for(int i=0; i<9; i++) {
			if(i != idx[0] && i != idx[1])
				System.out.println(arr[i]);
		}
	}
}
import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static double sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 7N/N+M 구하기...
		// 실수형 연산을 위해 N 또는 M을 double로 변환
		sum = 7.0 * N / (N + (double)M);
		
		// 반올림 없이 소수점 둘째 자리까지 자르기
		double truncatedSum = Math.floor(sum * 100) / 100.0;
		
		// 소수점 둘째 자리까지 출력 (반올림 없이)
		System.out.printf("%.2f", truncatedSum);
	}
}
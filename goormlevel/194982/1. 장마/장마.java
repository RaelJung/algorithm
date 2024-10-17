import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static int[] k; //마을 땅 높이
	static int[] day; //마지막으로 비내렸던 날 기록용
	static int s, e;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//1부터 하자 헷갈림
		k = new int[N+1];
		day = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++){
			k[i] = Integer.parseInt(st.nextToken());
		}
		
		// i일이 되는 날에는 si번 집부터 ei집까지 비가 내린다 (비 높이 + 1)
		// 3의 배수에는 배수 시스템 작동 3,6,9
		// 배수 시스템은 i-2까지만 배수 (1 감소)
		// 땅 높이는 쌓였던 물의 높이 만큼 증가
		// 마지막으로 비가 내렸던 날짜를 기억... (2일 이내면 감소)
		
		for(int i=1; i<=M; i++){
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
	
			
			for(int j=s; j<=e; j++){
				k[j]++;
				day[j] = i;
			}
			
			//비 내리고 배수 작동
			if(i%3==0){
				//최근 2일 이내 집 배수
				for(int j=1; j<=N; j++){
					if(day[j]>=i-2 && day[j]<=i){
						k[j]--;
					}
				}
			}
			
		}
		
		for(int i=1; i<=N; i++){
			System.out.print(k[i]+" ");
		}
		
	}
}
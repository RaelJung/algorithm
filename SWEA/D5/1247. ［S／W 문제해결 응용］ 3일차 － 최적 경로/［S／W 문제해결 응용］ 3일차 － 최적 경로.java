import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//NP
public class Solution {
	static int T, N, comY, comX, homeY, homeX, min;
	static int cust[][];
	static int index[];		//np를 위한 변수
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			cust= new int[N][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			comY = Integer.parseInt(st.nextToken());
			comX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}
			
			//초기화
			min = Integer.MAX_VALUE;
			
			//풀이
			index = new int[N];
			for(int i=0; i<N; i++) {
				index[i] = i;
			}
			
			while(true) {
				//complete code
				check();
				
				if(! np(index)) break;
			}
			
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb);
	}
	
	static void check() {
		//회사 -> 첫번째 고객
		int sum = distance(comY, comX, cust[index[0]][0], cust[index[0]][1]);
		//첫번째 고객 -> 마지막 고객
		for (int i = 0; i < N-1; i++) {
			sum += distance(
					cust[index[i]][0], cust[index[i]][1],
					cust[index[i+1]][0], cust[index[i+1]][1]
					);
		}
		//마지막 고객 -> 집
		sum += distance(homeY, homeX, cust[index[N-1]][0], cust[index[N-1]][1]);
		min = Math.min(min, sum);
	}
	
	static int distance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1 - y2) + Math.abs(x1 - x2); 
	}
	
	static boolean np(int array[]) {
		int i,j,k;
		
		i = j = k = array.length-1;
		
        while(i > 0 && array[i-1] >= array[i]) i--;
        if(i == 0) return false;
        
        while(array[i-1] >= array[j] ) j--;
        
        swap(array, i-1, j);
        
        while(k > i) {
            swap(array, i++, k--);
        }
        return true;
    }
    
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
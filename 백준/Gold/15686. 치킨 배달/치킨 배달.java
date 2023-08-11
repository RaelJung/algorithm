import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//0811 BOJ_15686_치킨배달
//NP 풀이
public class Main {
	static int[] index;
	static int N, M, min, houseSize, srcSize;
	static List<int[]> house, src;
	static int[] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		house = new ArrayList<>();
		src = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//2차원 배열 입력을 받으면서 집, 치킨집에 대해서 자료구조를 정리
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken()); 
				if(num == 1) house.add(new int[] {i,j});
				else if(num == 2) src.add(new int[] {i,j});
			}
		}
		
		//풀이
		min = Integer.MAX_VALUE;
		houseSize = house.size();
		srcSize = src.size();

		//NP
		//srcSize -> M: 0000111...111(1의 수가 M개) -> ... -> 111...11000
		index = new int[srcSize];	
		for(int i=srcSize-M; i<srcSize; i++) {
			index[i] = 1;
		}
		
		//조합 by NP
		while(true) {
			//complete code
			int sum=0;		//현재 조합의 치킨 거리의 총합
			for(int i=0; i<houseSize; i++) {
				int dist = Integer.MAX_VALUE;
				int[] h = house.get(i);
				
				for(int j=0; j<srcSize; j++) {	//모든 치킨집에 대해서
					if(index[j] == 1) {		//j번째 치킨집이 선택되었으면
						int[] c = src.get(j);
						dist = Math.min(dist, Math.abs(h[0]-c[0])+Math.abs(h[1]-c[1]));
					}
				}
				sum+=dist;
			}
			min=Math.min(min, sum);
			
			if (!np(index)) break;	//더이상 더 큰 수를 만들 수 없을 때 break;
		}
		System.out.println(min);
	}
	
	static boolean np(int[] arr) {
        int i, j, k;
        i = j = k = srcSize - 1;

        while(i > 0 && arr[i-1] >= arr[i]) i--;
        if(i == 0) return false;
        
        while(arr[i-1] >= arr[j] ) j--;
        
        swap(arr, i-1, j);
        
        while(k > i) {
            swap(arr, i++, k--);
        }
        return true;
    }
    
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
	
}
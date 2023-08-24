import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    static int[] susi;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		susi = new int[N+k-1];
		for (int i = 0; i < N; i++) {
			susi[i]=Integer.parseInt(br.readLine());
        }
		
		for (int i = 0; i < k-1; i++) {
			susi[N++]=susi[i];
		}

		int[] eaten = new int[d+1];
		int max=1;      //1은 쿠폰
		eaten[c]+=1;
		
		// default
		int start=0;
		for (int i = start; i < k; i++) {
			if(eaten[susi[i]]==0) {
				max++;
			}
			eaten[susi[i]]+=1;
		}
		
		// window
		start=0;
		int end=k;
		
		int result=max;
		for (int i = end; i < susi.length; i++) {
			eaten[susi[start]]-=1;
			if(eaten[susi[start]]==0) {
				result-=1;
			}
            
			if(eaten[susi[i]]==0) result+=1;
			eaten[susi[i]]+=1;
			max=Math.max(max, result);
			start++;
		}
		System.out.println(max);
	}
}
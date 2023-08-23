import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int l; // 데이터의 길이
	static int start; // 시작점
	static int size = 100 + 1; // 연락인원 (100) + 1
	static int[] visit; // 연락받은 인원 체크
	static int[][] graph; // 연락망
	static Queue<Integer> queue;
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	for(int t = 1; t <= 10; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		graph = new int[size][size];
    		queue = new LinkedList<>();
    		visit = new int[size];
    		
    		l = Integer.parseInt(st.nextToken());
    		start = Integer.parseInt(st.nextToken());
    		
    		st = new StringTokenizer(br.readLine());
    		
    		for(int i = 0; i < l/2; i++) {
    			int from = Integer.parseInt(st.nextToken());
    			int to = Integer.parseInt(st.nextToken());
    			
    			graph[from][to] = 1;
    		}	
    		
    		System.out.print("#" + t + " ");
    		bfs(start);
    	}
    }
    
    public static void bfs(int x) {
    	queue.offer(x);
    	visit[x] = 1; 
    	int max = 0; 
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	while(!queue.isEmpty()) {
    		int queueSize = queue.size();
    		max = 0;
    		
    		for(int t = 0; t < queueSize; t++) {
				int cur = queue.poll();
				for(int i = 1; i < size; i++) {
					if(graph[cur][i] == 1 && visit[i] == 0) {
						queue.offer(i);
						visit[i] = 1;
						max = Math.max(max, i);
					}
				}
    		}
    		list.add(max);
    	}
    	
    	System.out.println(list.get(list.size()-2));
    }
}
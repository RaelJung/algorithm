import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
        }
        
        int order = 0; // 실행 순서
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            boolean isHigh = false;
            
            // 큐의 다른 프로세스들 중 현재 프로세스보다 우선순위가 높은 것이 있는지 확인
            for (int[] process : q) {
                if (process[0] > curr[0]) {
                    isHigh = true;
                    break;
                }
            }
            
            if (isHigh) {
                // 우선순위가 더 높은 프로세스가 있으면 현재 프로세스를 큐의 뒤로 보냄
                q.offer(curr);
            } else {
                // 우선순위가 높은 프로세스가 없으면 현재 프로세스를 실행
                order++;
                if (curr[1] == location) {
                    return order;
                }
            }
        }
        
        return -1;
    }
}

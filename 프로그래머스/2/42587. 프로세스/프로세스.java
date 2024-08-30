import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Process> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            q.add(new Process(priorities[i], i));
        }
        
        while(!q.isEmpty()){
            Process curr = q.poll();
            boolean hasBig = false;
            
            // 현재 우선순위와, 큐에 남아있는 우선순위와 비교
            // 현재 큐를 리스트로 변환하여 우선순위를 비교
            for (Process p : q) {
                if (curr.priority < p.priority) {
                    hasBig = true;
                    break;
                }
            }
            
            if(hasBig) q.add(curr);
            else{
                answer++;
                if(curr.idx == location) break;
            }
        }
        
        return answer;
    }
    
    public static class Process {
        int idx;
        int priority;
        
        public Process(int priority, int idx){
            this.idx = idx;
            this.priority = priority;
        }
    }
}
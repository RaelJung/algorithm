import java.io.*;
import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static boolean visit[];
    static String t, word[];
    static int n;
    
    public int solution(String begin, String target, String[] words) {
        
        t = target;
        word = words;
        n = word.length;
        visit = new boolean[n];
        
        bfs(begin);
        
        if(answer == Integer.MAX_VALUE)
            answer = 0;
        
        return answer;
    }
    
    static void bfs(String begin){
        Queue<Word> q = new LinkedList<>();
        
        //단어 목록 중 해당하는 단어 큐에 담기
        for(int i=0; i<n; i++){
            if(!visit[i] && isOneDiffer(begin, word[i])){
                q.add(new Word(word[i], 0));
            }
        }
        
        while(!q.isEmpty()){
            //하나 뽑고 타겟 단어인지 확인
            Word w = q.poll();
            visit[Arrays.asList(word).indexOf(w.w)] = true;
            w.depth++;
            
            if(t.equals(w.w)){
                if(w.depth < answer)
                    answer = w.depth;
            }
            
            //아니면 변환 가능 단어 큐에 담기
            else{
                for(int i=0; i<n; i++){
                    if(!visit[i] && isOneDiffer(w.w, word[i]))
                        q.add(new Word(word[i], w.depth));
                }             
            }
        }
    }
    
    static boolean isOneDiffer(String w1, String w2){
        int cnt=0;
        for(int i=0; i<w1.length(); i++){
            if(w1.charAt(i) != w2.charAt(i)){
                cnt+=1;
            }
        }
        
        if(cnt == 1){
            return true;
        }
        return false;
    }
    
    public static class Word{
        String w;
        int depth;
        
        Word(String w, int depth){
            this.w = w;
            this.depth = depth;
        }
    }
}
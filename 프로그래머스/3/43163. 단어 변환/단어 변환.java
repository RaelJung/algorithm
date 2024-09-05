import java.util.*;
import java.io.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static String t;
    static boolean[] visit;
    static String[] word;
    
    public int solution(String begin, String target, String[] words) {
        t = target;
        word = words;
        visit = new boolean[words.length];
        bfs(new Word(begin, 0));
        
        // 변환 불가시 0 return
        if(answer == Integer.MAX_VALUE)
            answer = 0;
        
        return answer;
    }
    
    public static void bfs(Word start){
        Queue<Word> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            Word curr = q.poll();
            
            // 큐에서 뽑아서 타겟과 비교. 
            // 이 때, 변환 횟수를 최소로 변환
            if(curr.word.equals(t)){
                if(answer > curr.depth) answer = curr.depth;
                return;
            }
            
            for(int i=0; i<word.length; i++){
                // 기준 단어와 1개만 다른 단어를 모두 큐에 넣기
                // depth 추가!
                if(!visit[i] && isOneDiff(curr.word, word[i])){
                    visit[i] = true;;
                    q.add(new Word(word[i], curr.depth+1));
                }
            }
        }
    }
    
    // 하나의 문자가 다른지 확인하는 함수
    public static Boolean isOneDiff(String w1, String w2){
        int cnt = 0;
        
        for(int i=0; i<w1.length(); i++){
            if(w1.charAt(i) != w2.charAt(i))
                cnt++;
        }
        
        if(cnt == 1) {
            return true;
        }
        return false;
    }
    
    public static class Word{
        String word;
        int depth;
        
        public Word(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
}
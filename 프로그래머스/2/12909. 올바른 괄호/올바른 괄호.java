import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        if(s.charAt(s.length()-1) == '(')
            return false;
        
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        
        for(int i=0; i<s.length(); i++){
            stack.push(s.charAt(i));
        }
        
        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c == ')') cnt++;
            else if(c == '('){
                if(cnt == 0)
                    return false;
                cnt--;
            }
        }
        
        if(cnt == 0) answer = true;

        return answer;
    }
}
import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) throws Exception{
        String[] answer = {};
        
        answer = Sort(strings, n);
        
        return answer;
    }

    public String[] Sort(String arrs[], int n){
        Arrays.sort(arrs, (s1, s2) -> {
            if(s1.charAt(n) != s2.charAt(n)){
                return s1.charAt(n) - s2.charAt(n);
            }
            return s1.compareTo(s2);
        });

        return arrs;
    }
}
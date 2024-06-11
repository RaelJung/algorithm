import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 규칙 찾기
        // brown + yellow = return의 w * h
        int sum = brown + yellow;
        List<Integer> div = getDivisors(sum);
        
        // 약수 쌍을 이용해 조건을 만족하는 가로, 세로 길이를 찾습니다.
        for (int i = 0; i < div.size() / 2 + 1; i++) {
            int h = div.get(i);          // 세로 길이
            int w = div.get(div.size() - 1 - i);  // 가로 길이
            
            // 조건을 만족하는지 확인
            // 즉, brown의 영역인 2를 빼면 너비를 구할 수 있음
            if ((w - 2) * (h - 2) == yellow) {
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }
        
        return answer;
    }
    
    // 주어진 수의 모든 약수를 찾는 메소드
    public static List<Integer> getDivisors(int num) {
        List<Integer> div = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                div.add(i);
            }
        }
        return div;
    }
}

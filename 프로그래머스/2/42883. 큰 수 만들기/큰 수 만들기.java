import java.util.Stack;

public class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int length = number.length();
        
        for (int i = 0; i < length; i++) {
            char c = number.charAt(i);
            // 현재 문자가 스택의 최상단 문자보다 크면 스택에서 제거
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // k가 남아있는 경우 뒤에서부터 제거
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // 스택의 내용을 StringBuilder에 담아서 결과 생성
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String number = "1924";
        int k = 2;
        String result = solution.solution(number, k);
        System.out.println(result);  // 결과를 출력, 예상 결과: "94"
    }
}

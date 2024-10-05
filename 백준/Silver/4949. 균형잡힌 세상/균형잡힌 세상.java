import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.nextLine();

            // 종료 조건
            if (str.equals(".")) {
                break;
            }

            boolean isTrue = true;
            Stack<Character> s = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                // 여는 괄호 처리
                if (ch == '(' || ch == '[') {
                    s.push(ch);
                }
                // 닫는 괄호 처리
                else if (ch == ')' || ch == ']') {
                    if (s.isEmpty()) {
                        isTrue = false; // 스택이 비어있으면 잘못된 경우
                        break;
                    }
                    char top = s.pop();
                    if ((ch == ')' && top != '(') || (ch == ']' && top != '[')) {
                        isTrue = false; // 매칭 안 되는 괄호가 나온 경우
                        break;
                    }
                }
            }

            // 열린 괄호가 남아 있는지 확인
            if (!s.isEmpty()) {
                isTrue = false;
            }

            if (isTrue) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        sc.close();
    }
}
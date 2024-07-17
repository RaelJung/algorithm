import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine(); // 입력 문자열

        int total = 0; // 입력 받은 문자열에서 a의 개수
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') total++;
        }

        int aMax = 0; // 부분 문자열에서 a의 개수 중 최댓값
        for (int i = 0; i < str.length(); i++) {
            int aCnt = 0; // 부분 문자열에서 a의 개수 카운트

                for (int j = 0; j < total; j++) {
                // 입력 문자열의 범위를 벗어나면 다시 0부터 시작해야함
                int index = (i + j < str.length() ? i + j : i + j - str.length()); 

                if (str.charAt(index) == 'a') aCnt++;

                if (aCnt > aMax) aMax = aCnt; // 최댓값과 비교
            }
        }

        System.out.println(total - aMax);
    }
}
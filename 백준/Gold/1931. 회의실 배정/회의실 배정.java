import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            meetings[i][0] = sc.nextInt(); // 시작 시간
            meetings[i][1] = sc.nextInt(); // 종료 시간
        }

        // 종료 시간 기준 정렬, 같으면 시작 시간 기준 정렬
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0]; // 시작 시간 오름차순
            } else {
                return a[1] - b[1]; // 종료 시간 오름차순
            }
        });

        int count = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= end) {
                end = meetings[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}

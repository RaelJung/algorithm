import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<LinkedList<Character>> gears = new ArrayList<>();
    static boolean[] visited = new boolean[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니바퀴 4개 입력 받기
        for (int i = 0; i < 4; i++) {
            LinkedList<Character> gear = new LinkedList<>();
            for (char c : br.readLine().toCharArray()) {
                gear.add(c);
            }
            gears.add(gear);
        }

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1; // 인덱스 보정
            int dir = Integer.parseInt(st.nextToken());

            visited = new boolean[4]; // 매 회전마다 초기화
            rotate(num, dir);
        }

        // 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears.get(i).get(0) == '1') {
                score += (1 << i);
            }
        }

        System.out.println(score);
    }

    // 회전 처리 함수
    static void rotate(int idx, int dir) {
        visited[idx] = true;

        // 왼쪽 기어 확인
        if (idx > 0 && !visited[idx - 1]) {
            if (gears.get(idx).get(6) != gears.get(idx - 1).get(2)) {
                rotate(idx - 1, -dir);
            }
        }

        // 오른쪽 기어 확인
        if (idx < 3 && !visited[idx + 1]) {
            if (gears.get(idx).get(2) != gears.get(idx + 1).get(6)) {
                rotate(idx + 1, -dir);
            }
        }

        // 현재 기어 회전
        if (dir == 1) { // 시계 방향
            char last = gears.get(idx).removeLast();
            gears.get(idx).addFirst(last);
        } else { // 반시계 방향
            char first = gears.get(idx).removeFirst();
            gears.get(idx).addLast(first);
        }
    }
}

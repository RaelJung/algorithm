import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 트럭 수
        int w = Integer.parseInt(st.nextToken());   // 다리 길이
        int L = Integer.parseInt(st.nextToken());   // 다리 최대 하중

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        // 다리 위를 나타내는 큐 (길이 w)
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) bridge.offer(0);  // 처음엔 다리 위에 아무 트럭도 없음

        int time = 0;         // 시간 초
        int idx = 0;          // 현재 올릴 트럭 인덱스
        int totalWeight = 0;  // 현재 다리 위 무게 합

        while (idx < n) {
            // 1초 흐름
            time++;

            // 다리 앞쪽 트럭 제거
            totalWeight -= bridge.poll();

            // 다음 트럭을 올릴 수 있으면
            if (totalWeight + trucks[idx] <= L) {
                bridge.offer(trucks[idx]);
                totalWeight += trucks[idx];
                idx++;
            } else {
                // 못 올리면 빈 공간 채우기 (0)
                bridge.offer(0);
            }
        }

        // 마지막 트럭이 다리를 완전히 지나가는 시간 더함
        time += w;

        System.out.println(time);
    }
}

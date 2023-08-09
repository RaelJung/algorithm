import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//0809 BOJ_11286_절댓값 힙
//PriorityQueue를 사용하지 X <= 배열을 이용해서 직접 구현 (Heap 구현 X)
//10만개의 정수 배열을 만들고 from, to index를 이용.
public class Main {
    static int N, from, to;
    static PriorityQueue<Integer> pq =new PriorityQueue<>(
        (n1, n2)-> Math.abs(n1) == Math.abs(n2) ? n1-n2 : Math.abs(n1) - Math.abs(n2)
    );

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // N개의 연산처리
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                Integer min = pq.poll();
                System.out.println(min== null?0:min);
            } else {
                pq.offer(num);
            }
        }
    }
}
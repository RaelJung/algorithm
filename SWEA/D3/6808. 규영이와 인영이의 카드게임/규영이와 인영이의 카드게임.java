//0810 SW6806_규영이와 인영이의 카드게임 - 순열
//18개의 카드 중에, 규영이의 카드 9개는 고정. 
//어떤 순서대로 구성하느냐에 따라 규영이의 카드와 승부가 달라짐.
//인영이의 카드 9개를 순열로 처리 - 모든 경우에 대해 규영이의 카드와 게임을 진행 win, lose 누적.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 18개 카드 중에 규영이의 카드 9개 고정되고 나머지 9개 카드의 순서에 따라 승부가 갈라짐
public class Solution {
    static int T, win, lose, n = 9;
    static int[] input = new int[19];
    static int[] guCard = new int[9];
    static int[] inCard = new int[9]; // 인영이의 카드
    static int[] tgt = new int[9]; // 순열을 통해 배치될 카드
    static boolean[] select = new boolean[9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            win = 0;
            lose = 0;
            Arrays.fill(input, 0);
            // 입력처리
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = 0;
            for (int i = 0; i < n; i++) {
                num = Integer.parseInt(st.nextToken());
                input[num] = 1;
                guCard[i] = num;
            }
            num = 0;
            for (int i = 1; i < 19; i++) {
                if (input[i] == 0) {
                    inCard[num++] = i;
                }
            }
            perm(0);
            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);

    }

    static void perm(int tgtIdx) {
        if (tgtIdx == n) {
            check();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (select[i]) {
                continue;
            }
            tgt[tgtIdx] = inCard[i];
            select[i] = true;
            perm(tgtIdx + 1);
            select[i] = false;
        }
    }

    static void check() {
        int guSum = 0;
        int inSum = 0;
        for (int i = 0; i < n; i++) {
            if (guCard[i] > tgt[i]) {
                guSum += guCard[i] + tgt[i];
            } else {
                inSum += guCard[i] + tgt[i];
            }
        }
        if (guSum > inSum) {
            win++;
        } else {
            lose++;
        }
    }
}
//0810 SW6806_규영이와 인영이의 카드게임 - 순열
//18개의 카드 중에, 규영이의 카드 9개는 고정. 
//어떤 순서대로 구성하느냐에 따라 규영이의 카드와 승부가 달라짐.
//인영이의 카드 9개를 순열로 처리 - 모든 경우에 대해 규영이의 카드와 게임을 진행 win, lose 누적.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//SWAP
public class Solution {
    static int T, win, lose, n = 9;
    static int[] input = new int[19];
    static int[] guCard = new int[9];
    static int[] inCard = new int[9]; // 인영이의 카드
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
            
            //풀이
            perm(0);

            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);

    }
    
    //재귀호출 구조
    //tgtIdx 자리에 수를 채우는 작업
    static void perm(int srcIdx){
        //기저 조건
        if(srcIdx == n){
            check();
            return;
        }

        //i가 srcIdx부터 <= 자기 자신을 포함.
        for(int i=srcIdx; i<inCard.length; i++){
            int temp = inCard[srcIdx];
            inCard[srcIdx] = inCard[i];
            inCard[i] = temp;

            perm(srcIdx + 1);

            //i와 srcIdx 교환 원복
            temp = inCard[srcIdx];
            inCard[srcIdx] = inCard[i];
            inCard[i] = temp;
        }
    }

    static void check() {
        int guSum = 0;
        int inSum = 0;
        for (int i = 0; i < n; i++) {
            if (guCard[i] > inCard[i]) {
                guSum += guCard[i] + inCard[i];
            } else {
                inSum += guCard[i] + inCard[i];
            }
        }
        if (guSum > inSum) {
            win++;
        } else {
            lose++;
        }
    }
}
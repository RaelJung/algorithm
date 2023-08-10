//0810 SW6806_규영이와 인영이의 카드게임 - 순열
//18개의 카드 중에, 규영이의 카드 9개는 고정. 
//어떤 순서대로 구성하느냐에 따라 규영이의 카드와 승부가 달라짐.
//인영이의 카드 9개를 순열로 처리 - 모든 경우에 대해 규영이의 카드와 게임을 진행 win, lose 누적.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//NP
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
            //정렬 - 이미 정렬 inCard가 이미 정렬
            while(true){
                //complete code
                check();
                
                if(!np(inCard)) break;
            }

            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);

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

    static boolean np(int array[]){
        //3가지
        //1. 앞에서 교환되어야 하는 인덱스 & 작업
        int i = array.length - 1;
        while(i>0 && array[i-1] >= array[i]) --i;

        //이미 가장 큰 수
        //desc
        if(i==0) return false;

        //앞쪽에서 바꿀 index 확정 i-1

        //2. 뒤에서 교환되어야 하는 인덱스 & 작업
        int j = array.length - 1;
        while(array[i-1] >= array[j]) --j;

        //j 확정
        swap(array, i-1, j);

        //3. 교환 후, 뒤쪽을 작은 수로 정리
        int k = array.length - 1;
        while(i<k){
            swap(array, i++, k--);
        }

        //np() 호출 전 보다 바로 다음 큰 수를 만든 것
        return true;
    }

    static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
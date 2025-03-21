import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int start, end = 0;     //기준 시작점, 끝점 정의
    static int length = 0;             // 점수 정의
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Point p[] = new Point[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(p); //시작점(x) 기준으로 정렬

        start = p[0].x;
        end = p[0].y;
        for(int i=1; i<N; i++){
            if(p[i].x <= end){  //겹칠 경우 -> 기존에서 증가
                end = Math.max(end, p[i].y);
            }
            else{           //안 겹치면 길이 저장 후, 새로 시작
                length += end - start;
                start = p[i].x;
                end = p[i].y;
            }
        }

        //마지막 점 계산
        length += end - start;

        System.out.println(length);
    }

    static class Point implements Comparable<Point>{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        @Override
        public int compareTo(Point o) {
            return this.getX() - o.getX(); //작은게 앞으로
        }
    }
}

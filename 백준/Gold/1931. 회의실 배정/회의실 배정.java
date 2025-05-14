import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Time time[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new Time[N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            
            time[i] = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(time);

        int cnt = 0;
        int end = 0;    //이전 회의 끝 시간
        for(int i=0; i<N; i++){
            if(time[i].s >= end){
                end = time[i].e;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static class Time implements Comparable<Time>{
        int s,e;

        public Time(int s, int e){
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Time o){
            if (this.e == o.e) {
                return this.s - o.s; // 끝나는 시간이 같으면 시작 시간 기준으로 정렬
            }
            return this.e-o.e;
        }
    }
}

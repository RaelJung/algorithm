import java.io.*;
import java.util.*;

public class Main {
    static int N, sum=0, total=0;
    static int[] time;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        time = new int[N];
        for(int i=0; i<N; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        for(int i=0; i<N; i++){
            sum += time[i];
            total += sum;
        }

        System.out.println(total);
    }
}

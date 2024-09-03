import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        POS[] p = new POS[N];

        for(int i=0; i<N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            p[i] = new POS(x, y);
        }

        Arrays.sort(p);

        for(int i=0; i<N; i++){
            System.out.println(p[i].x+" "+p[i].y);
        }

        sc.close();
    }

    public static class POS implements Comparable<POS>{
        int x;
        int y;

        public POS(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(POS other){
            if(this.x == other.x){
                return this.y - other.y;
            }
            return this.x - other.x;
        }
    }
}
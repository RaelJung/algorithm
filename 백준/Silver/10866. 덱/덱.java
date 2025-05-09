import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String opt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new ArrayDeque<>();

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            opt = st.nextToken();
            if(opt.equals("push_front")){
                deque.addFirst(st.nextToken());
            }
            else if(opt.equals(("push_back"))){
                deque.addLast(st.nextToken());
            }
            else if(opt.equals("pop_front")){
                String res = deque.pollFirst();
                if(res == null) res = "-1";
                System.out.println(res);
            }
            else if(opt.equals("pop_back")){
                String res = deque.pollLast();
                if(res == null) res = "-1";
                System.out.println(res);
            }
            else if(opt.equals("size")){
                System.out.println(deque.size());
            }
            else if(opt.equals("empty")){
                int res = 0;
                if(deque.isEmpty()) res = 1;
                System.out.println(res);
            }
            else if(opt.equals("front")){
                String res = deque.peekFirst();
                if(res == null) res = "-1";
                System.out.println(res);
            }
            else if(opt.equals("back")){
                String res = deque.peekLast();
                if(res == null) res = "-1";
                System.out.println(res);
            }
        }
    }
}

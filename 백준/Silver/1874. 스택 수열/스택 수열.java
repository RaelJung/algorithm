import java.util.*;

public class Main {
    static int N;
    static int[] nums, nums_sort;
    static LinkedList<Character> opt;
    static Stack<Integer> s;

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        nums_sort = new int[N];

        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }

        nums_sort = nums.clone();
        Arrays.sort(nums_sort);

        //stack에 넣으며 비교
        s = new Stack<>();
        opt = new LinkedList<>();

        int idx = 0;
        for(int i=0; i<N; i++){
            s.push(nums_sort[i]);
            opt.add('+');

            //peek으로 원 배열과 비교
            while(!s.isEmpty() && (nums[idx] == s.peek())){
                s.pop();
                opt.add('-');
                idx++;
            }
        }

        //수열 만들 수 있다면
        if(idx == N){
            for(char o : opt){
                System.out.println(o);
            }
        }
        else{
            System.out.println("NO");
        }
        

        sc.close();
    }
}
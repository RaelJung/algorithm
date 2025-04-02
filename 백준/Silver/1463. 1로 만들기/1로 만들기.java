import java.util.Scanner;

public class Main {
    static int X;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        dp = new int[X+1];  //인덱스가 숫자가 될 것임!

        // 3으로 나누거나, 2로 나누어서(나머지 없어야 함)
        // -1 하는 것을 반복하여 최종적으로 1로 만드는 것
        // 최소 연산을 구하므로 DP 문제임... 

        for(int i=2; i<X+1; i++){
            dp[i] = dp[i-1]+1;  //1을 뺀 경우
            if(i%3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3]+1); //3을 나누는 경우
            }
            if(i%2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2]+1); //2를 나누는 경우
            }
        }

        System.out.println(dp[X]);
    }
}

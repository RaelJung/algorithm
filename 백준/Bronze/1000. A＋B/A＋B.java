import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        String[] numbers = num.split(" ");
        
        System.out.println(Integer.parseInt(numbers[0])+Integer.parseInt(numbers[1]));
    }
}

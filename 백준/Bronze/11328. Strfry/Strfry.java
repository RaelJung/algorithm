import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int t=0; t<n; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1, str2;
            int alpha1[], alpha2[]; 
            boolean isSame = true;

            //알파벳 문자열 초기화
            alpha1 = new int[28];
            alpha2 = new int[28];

            //문자열 입력
            str1 = st.nextToken();
            str2 = st.nextToken();

            //문자열 길이만큼 반복하며 알파벳 배열에 저장
            //소문자로 구성되므로 대문자 고려 X!
            for(int i=0; i<str1.length(); i++){
                alpha1[str1.charAt(i) - 'a']++;
            }
            for(int i=0; i<str2.length(); i++){
                alpha2[str2.charAt(i) - 'a']++;
            }
            
            for(int i=0; i<28; i++){
                if(alpha1[i] != alpha2[i]){
                    isSame = false;
                    break;
                }
            }

            if(isSame){
                System.out.println("Possible");
            }
            else{
                System.out.println("Impossible");
            }

        }
        
    }
}
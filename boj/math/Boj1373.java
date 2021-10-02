package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binary = br.readLine();
        int len = binary.length();
        int multi = 1;
        int count = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=len-1; i>=0; i--){
            int num = binary.charAt(i) - '0';
            sum += num * multi;
            multi *= 2;
            count++;

            if(count == 3){
                sb.append(sum);
                multi = 1;
                count = 0;
                sum = 0;
            }
        }

        if(sum != 0 || sb.length() == 0){
            sb.append(sum);
        }

        System.out.println(sb.reverse());
    }
}

package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj18291 {
    static final int DIV = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 1 || num == 2){
                sb.append(1).append("\n");
            }else{
                long ans = pow(2, num-2);
                sb.append(ans).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static long pow(int A, int exponent){
        if(exponent == 1){
            return A % DIV;
        }

        long temp = pow(A, exponent/2);

        if(exponent % 2 == 1){
            return ((temp*temp)%DIV * (A%DIV))%DIV;
        }
        return temp*temp%DIV;
    }
}

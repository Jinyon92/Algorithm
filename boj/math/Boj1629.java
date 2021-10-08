package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long ans = pow(A,B,C);
        System.out.println(ans);
    }

    public static long pow(int A, int exponent, int C){
        if(exponent == 1){
            return A%C;
        }

        long temp = pow(A, exponent/2, C);

        if(exponent % 2 == 1){
            return ((temp * temp)%C * A%C) % C;
        }

        return temp * temp % C;
    }
}

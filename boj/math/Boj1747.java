package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1747 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(2);
            System.exit(0);
        }

        for(int i=N; ; i++){
            if(isPrime(i) && isPalind(i)){
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean isPrime(int x){
        for(int i=2; i*i<=x; i++){
            if(x%i == 0) return false;
        }

        return true;
    }

    public static boolean isPalind(int x){
        String str = Integer.toString(x);
        int len = str.length();

        for(int i=0; i<len/2; i++){
            if(str.charAt(i) != str.charAt(len-i-1)){
                return false;
            }
        }

        return true;
    }
}

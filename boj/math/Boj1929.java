package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int MAX = 1000001;
        boolean[] isPrime = new boolean[MAX];
        StringBuilder sb = new StringBuilder();

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2; i*i<MAX; i++){
            if(isPrime[i]){
                for(int j=i*i; j<MAX; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=N; i<=M; i++){
            if(isPrime[i]){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}

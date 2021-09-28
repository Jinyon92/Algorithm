package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j <= i/2; j++){
                dp[i] = Math.min(dp[i], dp[i-j] + dp[j]);
            }
        }

        System.out.println(dp[N]);
    }
}

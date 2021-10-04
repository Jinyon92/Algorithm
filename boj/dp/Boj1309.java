package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long dp[][] = new long[N+1][3]; // N+1 : 행, 0 : 사자 없음, 1 : 왼쪽 사자, 2: 오른쪽 사자
        int DIV = 9901;

        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        for(int i=2; i<=N; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % DIV;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % DIV;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % DIV;
        }

        long ans = (dp[N][0] + dp[N][1] + dp[N][2]) % DIV;
        System.out.println(ans);
    }
}

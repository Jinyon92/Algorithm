package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long dp[][] = new long[100001][4];
        long div = 1000000009;
        StringBuilder sb = new StringBuilder();

        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
        for(int i=4; i<100001; i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % div;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % div;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % div;
        }

        for(int tc = 0; tc < T; tc++){
            int num = Integer.parseInt(br.readLine());
            long ans = (dp[num][1] + dp[num][2] + dp[num][3]) % div;
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}

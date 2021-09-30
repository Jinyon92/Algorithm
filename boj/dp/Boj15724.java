package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];
        StringBuilder sb = new StringBuilder();

        for(int y=1; y<=N; y++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int x=1; x<=M; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int y=1; y<=N; y++){
            for(int x=1; x<=M; x++){
                dp[y][x] = dp[y-1][x] + dp[y][x-1] - dp[y-1][x-1] + map[y][x];
            }
        }

        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int ans = dp[y2][x2] - dp[y2][x1-1] - dp[y1-1][x2] + dp[y1-1][x1-1];
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}

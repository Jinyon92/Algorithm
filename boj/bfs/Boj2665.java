package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2665 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[][] dp = new int[N][N];
        Queue<Node> q = new LinkedList<>();

        for(int y=0; y<N; y++){
            String input = br.readLine();
            for(int x=0; x<N; x++){
                map[y][x] = input.charAt(x) - '0';
                dp[y][x] = 100_000_000;
            }
        }

        dp[0][0] = 0;
        q.offer(new Node(0,0,0));

        int[] dy = {1,0,-1,0};
        int[] dx = {0,1,0,-1 };
        while(!q.isEmpty()){
            Node cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            int count = cur.count;

            for(int dir=0; dir<4; dir++){
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                int cnt = count;

                if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if(map[ny][nx] == 0) cnt++;

                if(dp[ny][nx] > cnt){
                    dp[ny][nx] = cnt;
                    q.offer(new Node(ny,nx,cnt));
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }

    static class Node {
        int y;
        int x;
        int count;

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}

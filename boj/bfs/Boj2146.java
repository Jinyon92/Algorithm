package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2146 {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int answer;
    static Queue<Point> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int y=0; y<N; y++){
            String input = br.readLine();
            for(int x=0; x<N; x++){
                map[y][x] = input.charAt(2*x) - '0';
            }
        }

        int landNum = 1;
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                if(map[y][x] == 1 && !visited[y][x]){
                    visited[y][x] = true;
                    map[y][x] = landNum;
                    dfs(y,x,landNum);
                    landNum++;
                }
            }
        }

        answer = Integer.MAX_VALUE;
        q = new LinkedList<>();
        for(int i=0; i<N; i++){
            Arrays.fill(visited[i], false);
        }
        int count = 1;
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                if(!visited[y][x] && map[y][x] >= count){
                    visited[y][x] = true;
                    bfs(map[y][x]);
                    count++;
                }
            }
        }

        System.out.println(answer);
    }

    static int dy[] = {1,0,-1,0};
    static int dx[] = {0,1,0,-1};
    public static void bfs(int landNum){
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                if(map[y][x] == landNum) q.offer(new Point(y,x,0));
            }
        }

        for(int i=0; i<N; i++){
            Arrays.fill(visited[i], false);
        }
        boolean isFlag = false;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                Point cur = q.poll();
                int y = cur.y;
                int x = cur.x;
                int dist = cur.dist;

                for(int dir=0; dir<4; dir++){
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if(ny >= N || ny < 0 || nx >= N || nx < 0) continue;

                    if(!visited[ny][nx]){
                        visited[ny][nx] = true;

                        if(map[ny][nx] == 0){
                            q.offer(new Point(ny, nx, dist+1));
                        }
                        else if(map[ny][nx] == landNum){
                            q.offer(new Point(ny, nx, dist));
                        }
                        else {
                            answer = Math.min(answer, dist);
                            isFlag = true;
                            break;
                        }
                    }
                }
                if(isFlag) break;
            }
            if(isFlag) break;
        }

        q.clear();
    }

    public static void dfs(int y, int x, int landNum){
        for(int dir=0; dir<4; dir++){
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if(ny >= N || ny < 0 || nx >= N || nx < 0) continue;

            if(!visited[ny][nx] && map[ny][nx] == 1){
                visited[ny][nx] = true;
                map[ny][nx] = landNum;
                dfs(ny, nx, landNum);
            }
        }
    }

    static class Point{
        int y;
        int x;
        int dist;

        public Point(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}

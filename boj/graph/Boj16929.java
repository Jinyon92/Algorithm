package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16929 {
    static boolean[][] visited;
    static int N, M;
    static boolean isFlag;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for(int y=0; y<N; y++){
            String input = br.readLine();
            for(int x=0; x<M; x++){
                map[y][x] = input.charAt(x);
            }
        }

        isFlag = false;
        for(int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                visited[y][x] = true;
                dfs(y,x,y,x,map[y][x],1);
                visited[y][x] = false;
            }
        }

        if(isFlag) System.out.println("Yes");
        else System.out.println("No");

    }

    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    public static void dfs(int y, int x, int sy, int sx, char key, int cnt){
        if(isFlag) return;

        for(int dir=0; dir<4; dir++){
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

            if(ny == sy && nx == sx && cnt >= 4){
                isFlag = true;
                return;
            }

            if(!visited[ny][nx] && map[ny][nx] == key){
                visited[ny][nx] = true;
                dfs(ny, nx, sy, sx, key, cnt+1);
                visited[ny][nx] = false;
            }
        }
    }
}

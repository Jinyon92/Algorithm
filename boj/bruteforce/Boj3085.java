package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3085 {
    static int N;
    static char[][] map;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        ans = 0;

        for(int y=0; y<N; y++){
            String str = br.readLine();
            for(int x=0; x<N; x++){
                map[y][x] = str.charAt(x);
            }
        }

        int val = eatCandy();
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                change(y,x);
            }
        }
        ans = Math.max(ans, val);
        System.out.println(ans);
    }

    static int dy[] = {1,0,-1,0};
    static int dx[] = {0,1,0,-1};
    public static void change(int y, int x){
        for(int dir=0; dir<4; dir++){
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

            if(map[y][x] != map[ny][nx]){
                char temp = map[y][x];
                map[y][x] = map[ny][nx];
                map[ny][nx] = temp;

                int max = eatCandy();
                ans = Math.max(max, ans);

                temp = map[y][x];
                map[y][x] = map[ny][nx];
                map[ny][nx] = temp;
            }
        }
    }

    public static int eatCandy(){
       int ret = 0;

       for(int y=0; y<N; y++){
           int count = 1;
           char key = map[y][0];
           for(int x=1; x<N; x++){
               if(key == map[y][x]) count++;
               else{
                   key = map[y][x];
                   ret = Math.max(ret, count);
                   count = 1;
               }
           }
           ret = Math.max(ret, count);
       }

       for(int x=0; x<N; x++){
           int count = 1;
           char key = map[0][x];
           for(int y=1; y<N; y++){
               if(key == map[y][x]) count++;
               else{
                   key = map[y][x];
                   ret = Math.max(ret, count);
                   count = 1;
               }
           }
           ret = Math.max(ret, count);
       }

       return ret;
    }
}

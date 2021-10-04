package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15661 {
    static int N;
    static int half;
    static int[][] team;
    static boolean[] visited;
    static ArrayList<Integer> ateam;
    static ArrayList<Integer> bteam;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        half = N/2;
        team = new int[N][N];
        visited = new boolean[N];
        ateam = new ArrayList<>();
        bteam = new ArrayList<>();

        for(int y=0; y<N; y++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int x=0; x<N; x++){
                team[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 9999999;
        permutation(0, 0);

        System.out.println(ans);
    }

    public static void permutation(int idx, int cnt) {
        if(cnt <= half && cnt >= 1){
            for(int i=0; i<N; i++){
                if(visited[i]) ateam.add(i);
                else bteam.add(i);
            }

            int aScore = 0;
            int bScore = 0;
            if(ateam.size() > 0) {
                for(int first : ateam){
                    for(int second : ateam){
                        aScore += team[first][second];
                    }
                }
            }

            if(bteam.size() > 0) {
                for(int first : bteam){
                    for(int second : bteam){
                        bScore += team[first][second];
                    }
                }
            }

            int val = Math.abs(aScore - bScore);
            ans = Math.min(ans, val);
            ateam.clear();
            bteam.clear();

            if(cnt == half) return;
        }

        for(int i=idx; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                permutation(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }
}

package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj9372 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N+1];
            visited = new boolean[N+1];
            for(int i=0; i<=N; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            answer = 0;
            dfs(1);
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int v){
        visited[v] = true;

        for(int next : graph[v]){

            if(!visited[next]){
                answer++;
                dfs(next);
            }
        }
    }
}

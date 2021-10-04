package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj13023 {
    static ArrayList<Integer>[] graph;
    static int ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            graph[to].add(from);
            graph[from].add(to);
        }

        for(int i=0; i<N; i++){
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;

            if(ans == 1) break;
        }

        System.out.println(ans);
    }

    public static void dfs(int cur, int depth){
        if(depth == 4){
            ans = 1;
            return;
        }

        if(ans == 1) return;

        for(int node : graph[cur]){
            if(!visited[node]){
                visited[node] = true;
                dfs(node, depth+1);
                visited[node] = false;
            }
        }

    }
}

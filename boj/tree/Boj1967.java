package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1967 {
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int maxNum;
    static int maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[u].add(new Node(v,w));
            tree[v].add(new Node(u,w));
        }

        visited[1] = true;
        maxNum = 0;
        dfs(1,0);
        Arrays.fill(visited, false);

        visited[maxNode] = true;
        dfs(maxNode, 0);
        System.out.println(maxNum);
    }

    public static void dfs(int cur, int dist){
        if(maxNum < dist){
            maxNum = dist;
            maxNode = cur;
        }

        for(Node node : tree[cur]){
            int next = node.v;
            int weight = node.w;

            if(!visited[next]){
                visited[next] = true;
                dfs(next, dist+weight);
            }
        }
    }

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}

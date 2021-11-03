package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Node>[] graph = new ArrayList[N+1];
        ArrayList<Node>[] reverse = new ArrayList[N+1];
        int[] degree = new int[N+1];
        int[] dist = new int[N+1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v,w));
            reverse[v].add(new Node(u,w));
            degree[v]++;
        }
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));

        exit:while(!q.isEmpty()){
            Node cur = q.poll();
            int cp = cur.v;
            int cw = cur.w;

            for(Node next : graph[cp]){
                int np = next.v;
                int nw = next.w;

                if(dist[np] < cw + nw){
                    dist[np] = cw + nw;
                }

                degree[np]--;

                if(degree[np] == 0){
                    q.offer(new Node(np, dist[np]));
                    if(np == end) break exit;
                }
            }
        }

        System.out.println(dist[end]);
        q.clear();
        boolean[] visited = new boolean[N+1];
        q.offer(new Node(end, dist[end]));
        int cnt = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            int cp = cur.v;
            int cw = cur.w;
            if(visited[cp]) continue;
            visited[cp] = true;
            if(cp == start) break;

            for(Node next : reverse[cp]){
                int np = next.v;
                int nw = next.w;

                if(dist[np] == cw - nw){
                    cnt++;
                    q.offer(new Node(np, dist[np]));
                }
            }
        }
        System.out.println(cnt);
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


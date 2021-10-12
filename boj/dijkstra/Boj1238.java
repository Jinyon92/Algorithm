package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1238 {
    static ArrayList<Node>[] graph;
    static int[] dist;
    static PriorityQueue<Node> pq;
    static int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 마을
        int M = Integer.parseInt(st.nextToken()); // 간선
        int X = Integer.parseInt(st.nextToken()); // 도착지점
        graph = new ArrayList[N+1];
        dist = new int[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v,w));
        }

        int answer = 0;
        pq = new PriorityQueue<>();
        for(int i=1; i<=N; i++){
            if(i == X) continue;

            int ret = dijkstra(i,X);
            ret += dijkstra(X, i);
            answer = Math.max(ret, answer);
        }

        System.out.println(answer);
    }

    public static int dijkstra(int start, int end){
        pq.clear();
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int cur = node.v;
            int curWeight = node.w;
            if(dist[cur] < curWeight) continue;

            for(Node n : graph[cur]){
                int next = n.v;
                int w = n.w;

                if(dist[next] > curWeight + w){
                    dist[next] = curWeight + w;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }

        return dist[end];
    }

    static class Node implements Comparable<Node>{
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
}

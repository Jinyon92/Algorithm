package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1504 {
    static ArrayList<Node>[] grpah;
    static int[] dist;
    private static final int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        grpah = new ArrayList[N+1];
        dist = new int[N+1];
        for(int i=1; i<=N; i++){
            grpah[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            grpah[u].add(new Node(v,w));
            grpah[v].add(new Node(u,w));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int point1 = Integer.parseInt(st.nextToken());
        int point2 = Integer.parseInt(st.nextToken());

        int result1 = dijkstra(1,point1);
        result1 += dijkstra(point1, point2);
        result1 += dijkstra(point2, N);

        int result2 = dijkstra(1,point2);
        result2 += dijkstra(point2, point1);
        result2 += dijkstra(point1, N);

        if(result1 >= INF && result2 >= INF){
            System.out.println(-1);
        }else{
            int answer = Math.min(result1, result2);
            System.out.println(answer);
        }
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node node = pq.poll();
            int cur = node.v;
            int weight = node.w;
            if(dist[cur] < weight) continue;

            for(Node n : grpah[cur]){
                int next = n.v;
                int w = n.w;

                if(dist[next] > weight + w){
                    dist[next] = weight + w;
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
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}

package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj11779 {
    static int[] dist, parent;
    static final int MAX_DIST = 1000_000_000;
    static ArrayList<Node> graph[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        parent = new int[N+1]; //해당 경로 찾기 위해서
        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            dist[i] = MAX_DIST;
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, cost));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int answer = dijkstra(start, end);
        Stack<Integer> stack = new Stack<>();

        int cur = end;
        while(cur != start){
            stack.push(cur);
            cur = parent[cur];
        }
        stack.push(start);

        sb.append(answer).append("\n");
        sb.append(stack.size()).append("\n");
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curPos = cur.v;
            int curCost = cur.cost;
            if(dist[curPos] < curCost) continue;

            for(Node next : graph[curPos]){
                int nPos = next.v;
                int nCost = next.cost;
                if(dist[nPos] > curCost + nCost){
                    dist[nPos] = curCost + nCost;
                    pq.offer(new Node(nPos, dist[nPos]));

                    parent[nPos] = curPos;
                }
            }
        }

        return dist[end];
    }

    static class Node implements Comparable<Node>{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}

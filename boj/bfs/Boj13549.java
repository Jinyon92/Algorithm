package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[100001];

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        pq.offer(new Node(N, 0));
        visited[N] = true;

        int ans = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int cur = now.cur;
            int time = now.time;

            if (cur == K) {
                System.out.println(time);
                return;
            }

            if (cur * 2 <= 100000 && !visited[cur * 2]) {
                visited[cur * 2] = true;
                pq.offer(new Node(cur*2, time));
            }

            if (cur - 1 >= 0 && !visited[cur - 1]) {
                visited[cur - 1] = true;
                pq.offer(new Node(cur-1, time+1));
            }

            if (cur + 1 <= 100000 && !visited[cur + 1]) {
                visited[cur + 1] = true;
                pq.offer(new Node(cur+1, time+1));
            }
        }

        System.out.println(ans);
    }

    static public class Node implements Comparable<Node> {
        int cur;
        int time;

        public Node(int cur, int time) {
            this.cur = cur;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if(this.time == o.time){
                return this.cur - o.cur;
            } else{
                return this.time - o.time;
            }
        }
    }
}

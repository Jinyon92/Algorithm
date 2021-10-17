package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] indegree = new int[N+1];
        ArrayList<Integer> list[] = new ArrayList[N+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            list[front].add(back);
            indegree[back]++;
        }

        for(int i=1; i<=N; i++){
            if(indegree[i] == 0) q.offer(i);
        }


        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(" ");

            for(int next : list[cur]){
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }

        System.out.println(sb);
    }
}

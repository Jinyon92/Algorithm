package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] indegree = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> answer = new LinkedList<>();

        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=0; j<cnt; j++){
                int singer = Integer.parseInt(st.nextToken());
                temp.add(singer);
            }

            for(int j=1; j<cnt; j++){
                list[temp.get(j-1)].add(temp.get(j));
                indegree[temp.get(j)]++;
            }

            temp.clear();
        }

        for(int i=1; i<=N; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            answer.offer(cur);

            for(int next : list[cur]){
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        if(answer.size() == N){
            while(!answer.isEmpty()){
                sb.append(answer.poll()).append("\n");
            }
        }else{
            sb.append(0);
        }

        System.out.println(sb);
    }
}

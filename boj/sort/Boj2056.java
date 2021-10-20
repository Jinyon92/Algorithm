package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] indegree = new int[N+1];
        int[] time = new int[N+1];
        int[] dp = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            for(int j=0; j<count; j++){
                int pre = Integer.parseInt(st.nextToken());
                list[pre].add(i);
            }
            indegree[i] = count;
            time[i] = t;
            dp[i] = t;
        }

        for(int i=1; i<=N; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : list[cur]){
                indegree[next]--;
                dp[next] = Math.max(dp[next], dp[cur]+time[next]);

                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=N; i++){
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }

}

package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while(!pq.isEmpty()){
            int first = pq.poll();

            if(pq.isEmpty()){
                break;
            }
            int second = pq.poll();

            int sum = first + second;
            answer += sum;
            pq.offer(sum);
        }

        System.out.println(answer);
    }
}

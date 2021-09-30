package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] location = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            location[i] = Integer.parseInt(st.nextToken());
        }

        if(N == 1){
            System.out.println(Math.abs(S-location[0]));
            return;
        }

        int a = Math.abs(S - location[0]);
        int b = Math.abs(S - location[1]);
        int r = 0;
        int idx = 1;
        while(true){
            r = GCD(a, b);
            idx++;

            if(idx == N) break;

            a = Math.abs(S - location[idx]);
            b = r;
        }

        System.out.println(r);
    }

    public static int GCD(int a, int b){
        if(a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}

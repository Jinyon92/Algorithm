package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Boj6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int MAX = 1000000;
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = new boolean[MAX+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i=2; i*i<=MAX; i++){
            if(isPrime[i]){
                for(int j = i*i; j<=MAX; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=2; i<=MAX; i++){
            if(isPrime[i]) list.add(i);
        }


        while(true){
            int number = Integer.parseInt(br.readLine());
            if(number == 0) break;

            int a = 0;
            int b = 0;

            for(int val : list){
                b = number - val;
                if(isPrime[b]){
                    a = val;
                    break;
                }
            }

            if(b<a){
                int temp = a;
                a = b;
                b = temp;
            }

            sb.append(number).append(" = ").append(a).append(" + ").append(b).append("\n");
        }

        System.out.println(sb);
    }
}

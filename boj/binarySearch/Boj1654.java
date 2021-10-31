package boj.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        long left = 1;
        long right = 0;
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(right < arr[i]){
                right = arr[i];
            }
        }

        right++;
        while(left < right){
            long mid = (left + right) / 2;

            int count = 0;
            for(int i=0; i<K; i++){
                count += (arr[i] / mid);
            }

            if(count < N){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        System.out.println(left-1);
    }
}

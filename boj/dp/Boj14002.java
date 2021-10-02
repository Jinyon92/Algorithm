package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int dp[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<N; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int idx = 0;
        int max = dp[0];
        for(int i=1; i<N; i++){
            if(max < dp[i]) {
                max = dp[i];
                idx = i;
            }
        }

        int count = dp[idx];
        sb.append(count+1).append("\n");
        int maxVal = arr[idx];
        list.add(maxVal);
        for(int i=idx-1; i>=0; i--){
            if(maxVal > arr[i] && dp[i] == count-1){
                list.add(arr[i]);
                maxVal = arr[i];
                count--;
            }

            if(count == -1) break;
        }

        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}

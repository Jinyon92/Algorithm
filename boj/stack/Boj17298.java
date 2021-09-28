package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] ans = new int[N];
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int value = arr[0];
        for(int i=1; i<N; i++){
            if(value < arr[i]){
                ans[i-1] = arr[i];

                while(!stack.isEmpty()){
                    int[] temp = stack.peek();
                    int idx = temp[0];
                    int val = temp[1];

                    if(val < arr[i]){
                        ans[idx] = arr[i];
                    }else{
                        break;
                    }

                    stack.pop();
                }

                value = arr[i];

            }else{
                stack.push(new int[]{i-1, value});
                value = arr[i];
            }
        }

        ans[N-1] = -1;
        while(!stack.isEmpty()){
            int[] temp = stack.pop();
            int idx = temp[0];

            ans[idx] = -1;
        }

        for(int i=0; i<N; i++){
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }

}

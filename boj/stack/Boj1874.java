package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int value = 1;

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(!stack.isEmpty() && stack.peek() == num){
                stack.pop();
                sb.append("-").append("\n");
                continue;
            }

            if(value <= N) {
                while(true){
                    if(value > N) break;

                    stack.push(value);
                    sb.append("+").append("\n");
                    value++;

                    if(stack.peek() == num) {
                        stack.pop();
                        sb.append("-").append("\n");
                        break;
                    }
                }
            }
        }

        if(stack.isEmpty()){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}

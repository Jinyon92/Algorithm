package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            int size = str.length();
            boolean isFlag = false;

            for(int j=0; j<size; j++){
                char ch = str.charAt(j);
                if(ch == '('){
                    stack.push(ch);
                }else{
                    if(stack.isEmpty()){
                        isFlag = true;
                        break;
                    }
                    stack.pop();
                }
            }

            if(isFlag || !stack.isEmpty()) {
                sb.append("NO").append("\n");
                stack.clear();
            }
            else sb.append("YES").append("\n");
        }

        System.out.println(sb);
    }
}

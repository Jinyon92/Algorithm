package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc < T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            while(st.hasMoreTokens()){
                String str = st.nextToken();

                int size = str.length();
                for(int i = 0; i < size; i++){
                    stack.push(str.charAt(i));
                }

                while(!stack.isEmpty()){
                    char ch = stack.pop();
                    sb.append(ch);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

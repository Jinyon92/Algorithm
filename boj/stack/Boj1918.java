package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == '-' || ch == '+'){
                while(!stack.isEmpty()){
                    char op = stack.peek();
                    if(op == '(') break;

                    sb.append(stack.pop());
                }
                stack.push(ch);
            }else if(ch == '*' || ch == '/'){
                while(!stack.isEmpty()){
                    char op = stack.peek();
                    if(op == '+' || op == '-' || op == '(') break;

                    sb.append(stack.pop());
                }
                stack.push(ch);
            }else if(ch == '('){
                stack.push(ch);
            }else if(ch == ')'){
                while(!stack.isEmpty()){
                    char op = stack.pop();
                    if(op == '(') break;

                    sb.append(op);
                }
            }else{
                sb.append(ch);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}

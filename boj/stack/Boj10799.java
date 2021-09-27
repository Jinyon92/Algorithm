package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brackets = br.readLine();
        Stack<Character> stack = new Stack<>();
        int len = brackets.length();
        int answer = 0;

        boolean isFlag = false;
        for(int i=0; i<len; i++){
            char bracket = brackets.charAt(i);
            if(bracket == '('){
                stack.push(bracket);
                isFlag = false;
            }else{
                stack.pop();

                if(!isFlag) answer += stack.size();
                else answer += 1;

                isFlag = true;
            }
        }

        System.out.println(answer);
    }
}

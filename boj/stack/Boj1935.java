package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Boj1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Double> stack = new Stack<>();
        String exp = br.readLine();
        int len = exp.length();
        double[] value = new double[N];

        for(int i=0; i<N; i++){
            value[i] = Double.parseDouble(br.readLine());
        }

        for(int i=0; i<len; i++){
            char ch = exp.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                double val1 = stack.pop();
                double val2 = stack.pop();
                double total = 0;
                if(ch == '+' ) {
                    total = val2 + val1;
                }
                else if(ch == '-'){
                    total = val2 - val1;
                }
                else if(ch == '*'){
                    total = val2 * val1;
                }else{
                    total = val2 / val1;
                }

                stack.push(total);
            }else{
                int idx = ch - 'A';
                stack.push(value[idx]);
            }
        }

        System.out.printf("%.2f" , stack.pop());
    }
}

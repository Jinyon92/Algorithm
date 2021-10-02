package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int binary = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if(binary == 0){
            System.out.println(0);
        }else{
            while(binary != 0){
                sb.append(Math.abs(binary % -2));
                binary = (int)Math.ceil((double)binary / -2);
            }
        }

        System.out.println(sb.reverse());
    }
}

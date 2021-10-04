package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int channel = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean[] isBroke = new boolean[10];

        if(N != 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++){
                int number = Integer.parseInt(st.nextToken());
                isBroke[number] = true;
            }
        }

        int ans;
        if(channel > 100){
            ans = channel - 100;
        }else if(channel == 100){
            ans = 0;
        }else{
            ans = 100 - channel;
        }

        for(int i=0; i<=999999; i++){
            String num = Integer.toString(i);
            boolean isFlag = false;
            int len = num.length();

            for(int j=0; j<len; j++){
                int value = num.charAt(j) - '0';
                if(isBroke[value]) {
                    isFlag = true;
                    break;
                }
            }

            if(isFlag) continue;

            int val = Integer.parseInt(num);
            int ret;
            if(channel > val){
                ret = channel - val + len;
            }else if(channel == val){
                ret = len;
            }else{
                ret = val - channel + len;
            }

            ans = Math.min(ret, ans);
        }

        System.out.println(ans);
    }

}

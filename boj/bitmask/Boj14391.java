package boj.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14391 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for(int y=0; y<N; y++){
            String input = br.readLine();
            for(int x=0; x<M; x++){
                map[y][x] = input.charAt(x) - '0';
            }
        }

        int bitCount = N*M;
        int answer = 0;
        // 비트 0 : 가로
        // 비트 1 : 세로
        for(int subset = 0; subset < (1<<bitCount); subset++){
            int sum = 0;

            for(int y=0; y<N; y++){
                int subSum = 0;

                for(int x=0; x<M; x++){
                    int num = y*M+x;

                    if((subset & (1<<num)) == 0){
                        subSum = subSum * 10 + map[y][x];
                    }else{
                        sum += subSum;
                        subSum = 0;
                    }
                }
                sum += subSum;
            }

            for(int x=0; x<M; x++){
                int subSum = 0;

                for(int y=0; y<N; y++){
                    int num = y*M+x;

                    if((subset & (1<<num)) != 0){
                        subSum = subSum * 10 + map[y][x];
                    }else{
                        sum += subSum;
                        subSum = 0;
                    }
                }
                sum += subSum;
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}

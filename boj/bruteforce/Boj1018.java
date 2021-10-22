package boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1018 {

    static int M, N;
    static char map[][];
    static int min = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new char[N][M];

        for(int i = 0 ; i < N ; i++) {
            String temp = bufferedReader.readLine();
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(i+8>N || j+8>M) continue;
                min = Math.min(min, check(j, i));
            }
        }
        System.out.println(min);

    }

    static int check(int x, int y) {
        int count1 = 0;
        int count2 = 0;

        boolean flag = true;

        for(int i = y ; i < y+8 ; i++) {
            for(int j = x ; j < x+8 ; j++) {
                // flag == true, W이면 count2 증가

                if(flag) {
                    if(map[i][j] == 'W'){
                        count2++;
                    } else {
                        count1++;
                    }
                } else {
                    if(map[i][j] == 'B'){
                        count2++;
                    } else {
                        count1++;
                    }
                }
                if(j==x+7) continue;
                flag = !flag;
            }
        }
//        System.out.println(count1 + " : " + count2);
        return Math.min(count1, count2);
    }
}

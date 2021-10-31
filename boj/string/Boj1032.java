package boj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1032 {
    static String[] strArr;
    static int count;
    static String str="";
    static boolean isSame=true;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine().trim());
        strArr=new String[n];

        for(int i=0;i<n;i++) {
            strArr[i]=br.readLine();
        }
        for(int i=0;i<strArr[0].length();i++) {
            for(int j=1;j<n;j++) {
                if(strArr[0].charAt(i)==strArr[j].charAt(i)) {
                    isSame=true;
                }else {
                    isSame=false;
                    break;
                }
            }
            if(isSame==false) {
                str+="?";
            }else {
                str+=strArr[0].charAt(i);
            }
        }
        System.out.println(str);
        br.close();
    }

}


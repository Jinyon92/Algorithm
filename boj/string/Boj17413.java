package boj.string;

import java.util.Scanner;

public class Boj17413 {
    static String s;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        s=sc.nextLine();
        boolean left=false;
        int start=0;
        String temp;
        for (int i = 0; i < s.length(); i++) {
            // 공백인 경우 < > 태그 사이 안이라면 무시, 아니라면 이전까지의 문자열을 뒤집어 출력
            if(left==false && s.charAt(i)==' ') {
                temp=s.substring(start, i);
                for (int j = temp.length()-1; j >=0; j--) {
                    System.out.print(temp.charAt(j));
                }
                System.out.print(" ");
                start=i+1;
                // 태그 열기. 태그가 시작됨을 알리고 이전까지의 문자열을 뒤집어 출력
            }else if(s.charAt(i)=='<') {
                left=true;
                if(i!=0) {//인덱스0 시작부터 <인경우는 이전 문자열 없음
                    temp=s.substring(start,i);
                    for (int j = temp.length()-1; j >=0; j--) {
                        System.out.print(temp.charAt(j));
                    }
                }
                start=i;//태그도 출력하기 위함
            }else if(s.charAt(i)=='>') {
                System.out.print(s.substring(start,i+1));
                left=false;
                start=i+1;
            }
        }
        if(start!=s.length()) {// 태그 사이 문자열이 아닌 경우 마지막에 문자열을 뒤집어 출력
            temp=s.substring(start);
            for (int j = temp.length()-1; j >=0; j--) {
                System.out.print(temp.charAt(j));
            }
        }
    }
}

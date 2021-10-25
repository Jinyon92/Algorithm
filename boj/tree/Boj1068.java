package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1068 {
    static int deleteNode;
    static ArrayList<Integer>[] tree;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        for(int i=0; i<N; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int root = 0;
        for(int i=0; i<N; i++){
            int parent = Integer.parseInt(st.nextToken());

            if(parent == -1) {
                root = i;
            }else{
                tree[parent].add(i);
            }
        }

        deleteNode = Integer.parseInt(br.readLine());
        answer = 0;
        if(deleteNode != root){
            dfs(root);
        }

        System.out.println(answer);
    }

    public static void dfs(int root){
        boolean isFlag = false;
        for(int child : tree[root]){
            if(child == deleteNode) continue;

            isFlag = true;
            dfs(child);
        }

        if(!isFlag) answer++;
    }
}

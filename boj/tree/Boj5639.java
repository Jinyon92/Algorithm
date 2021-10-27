package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5639 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rootNum = Integer.parseInt(br.readLine());
        Node root = new Node(rootNum);

        String input;
        while(true){
            input = br.readLine();
            if(input == null || input.equals("")){
                break;
            }
            root.insert(Integer.parseInt(input));
        }

        sb = new StringBuilder();
        postOrder(root);
        System.out.println(sb);
    }

    public static void postOrder(Node root){
        if(root.left != null) postOrder(root.left);
        if(root.right != null) postOrder(root.right);
        sb.append(root.num).append("\n");
    }

    static class Node {
        int num;
        Node left;
        Node right;

        public Node(int n){
            this.num = n;
        }

        void insert(int n){
            if(this.num > n){
                if(this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if(this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }
}

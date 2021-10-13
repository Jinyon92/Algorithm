package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2250 {
    static List<Node> tree = new ArrayList<>();
    static int[] levelMin, levelMax;
    static int point = 1;
    static int maxLevel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        levelMin = new int[N+1];
        levelMax = new int[N+1];
        for(int i=0; i<=N; i++){
            tree.add(new Node(i,-1,-1));
            levelMax[i] = 0;
            levelMin[i] = N;
        }
        maxLevel = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if(left != -1) {
                tree.get(num).left = left;
                tree.get(left).parent = num;
            }
            if(right != -1) {
                tree.get(num).right = right;
                tree.get(right).parent = num;
            }
        }

        int root = 0;
        for(int i=1; i<=N; i++){
            if(tree.get(i).parent == -1){
                root = i;
                break;
            }
        }

        inorder(root, 1);
        int answerLevel = 0;
        int answerWidth = 0;
        for(int i=1; i<=maxLevel; i++){
            int width = levelMax[i] - levelMin[i] + 1;
            if(answerWidth < width){
                answerWidth = width;
                answerLevel = i;
            }
        }

        System.out.println(answerLevel+" "+answerWidth);
    }

    public static void inorder(int root, int level){
        Node cur = tree.get(root);
        if(maxLevel < level) maxLevel = level;
        if(cur.left != -1) inorder(cur.left, level+1);
        levelMin[level] = Math.min(levelMin[level], point);
        levelMax[level] = Math.max(levelMax[level], point);
        point++;
        if(cur.right != -1) inorder(cur.right, level+1);
    }

    static class Node {
        int parent;
        int num;
        int left;
        int right;

        public Node(int num, int left, int right) {
            this.parent = -1;
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }
}

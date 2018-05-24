package kcrn.kyu.algorithm.tree;

import java.util.Scanner;

public class Josephus {

    static int tree[];

    public static void init(int node, int start, int end, int val) {
        if(start == end) {
            tree[node] = val;
            return;
        }

        init(node*2, start, (start+end)/2, val);
        init(node*2+1, (start+end)/2+1, end, val);

        tree[node] = tree[node*2] + tree[node*2+1];

    }

    public static int query(int node, int start, int end, int pos) {
        if(start == end)
            return start;

        if(tree[node*2] >= pos) {
            return query(node*2, start, (start+end)/2, pos);
        } else {
            return query(node*2+1, (start+end)/2+1, end, pos-tree[node*2]);
        }

    }

    public static void update(int node, int start, int end, int pos, int diff){
        if(start > pos || end < pos) return;

        if(start == end) {
            tree[node] += diff;
            return;
        }

        update(node*2, start, (start+end)/2, pos, diff);
        update(node*2+1, (start+end)/2+1, end, pos, diff);

        tree[node] = tree[node*2] + tree[node*2+1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (1 << (h+1));
        tree = new int[treeSize];

        init(1, 1, N, 1);

        int idx = 1;
        int pos = idx+M-1;
        StringBuilder ans = new StringBuilder("<");

        for(int i=1; i<=N; i++) {
            int maxCnt = N-i+1;
            if(pos > maxCnt) {
                int cercle = (maxCnt) * ((pos -1) / maxCnt);
                if(maxCnt == 1) pos = 1;
                else pos -= cercle;
            }

            idx = query(1, 1, N, pos);
            pos += (M-1);
            ans.append(idx).append(", ");

            update(1, 1, N, idx, -1);
        }

        ans = new StringBuilder(ans.substring(0, ans.length()-2));
        ans.append(">");

        System.out.println(ans);
    }
}

package kcrn.kyu.algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutation {

    static int a[];
    static int ans[];
    static int tree[];

    public static void update(int node, int start, int end, int pos, int diff){
        if(start > pos || end < pos) return;

        if(start == pos && end == pos){
            tree[node] += diff;
            return;
        }

        int mid = (start + end) / 2;

        update(node*2, start, mid, pos, diff);
        update(node*2+1, mid+1, end, pos, diff);
        tree[node] = tree[node*2] + tree[node*2+1];
    }

    public static int query(int node, int start, int end, int val) {
        if(start == end)
            return start;

        if(tree[node*2] >= val) {
            return query(node*2, start, (start+end)/2, val);
        } else {
            return query(node*2+1, (start+end)/2+1, end, val - tree[node*2]);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        a = new int[N+1];
        ans = new int[N+1];
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (1 << (h+1));
        tree = new int[treeSize];

        for(int i=1; i<=N; i++) {
            a[i] = Integer.parseInt(br.readLine());
            update(1, 1, N, i, 1);
        }

        update(1, 1, N, a[1]+1, -1);
        ans[a[1]+1] = 1;

        for(int i=2; i<=N; i++) {
            int idx = query(1, 1, N, a[i]+1);
            ans[idx] = i;
            update(1, 1, N, idx, -1);
        }

        for(int i=1; i<=N; i++)
            System.out.println(ans[i]);
    }
}

package kcrn.kyu.algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Segment {

    static int MAX = 1000000;
    public static int tree[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int h = (int) Math.ceil(Math.log(MAX) / Math.log(2));
        int tree_size = (1 << (h + 1));

        tree = new int[tree_size];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.valueOf(st.nextToken());

            if (m == 2) {
                int tasty = Integer.valueOf(st.nextToken());
                int num = Integer.valueOf(st.nextToken());
                update(1, 1, MAX, tasty, num);
            } else if (m == 1) {
                int pos = Integer.valueOf(st.nextToken());
                int tasty = kth(1, 1,MAX, pos);
                System.out.println(tasty);
                update(1, 1, MAX, tasty, -1);
            }
        }
    }

    public static void update(int node, int start, int end, int i, int diff) {
        if (i < start || i > end)
            return;
        tree[node] = tree[node] + diff;

        if (start != end) {
            update(node * 2, start, (start + end) / 2, i, diff);
            update(node * 2 + 1, (start + end) / 2 + 1, end, i, diff);
        }
    }

    public static int kth(int node, int start, int end, int pos) {
        if (start == end) {
            return start;
        } else {
            if (pos <= tree[node * 2]) {
                return kth(node * 2, start, (start + end) / 2, pos);
            } else {
                return kth(node * 2 + 1, (start + end) / 2 + 1, end, pos - tree[node * 2]);
            }
        }
    }
}

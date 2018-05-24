package kcrn.kyu.algorithm.tree;

import java.util.*;

public class Lca {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>[] a = (List<Integer>[]) new List[n+1];

        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i=1; i<=n-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x].add(y);
            a[y].add(x);
        }

        int[] depth = new int[n+1];
        boolean[] check = new boolean[n+1];
        int[] parent = new int[n+1];
        int start = 1;

        Queue<Integer> q = new LinkedList<Integer>();
        check[start] = true;
        depth[start] = 0;
        parent[start] = 0;

        q.add(start);

        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : a[x]) {
                if (check[y] == false) {
                    depth[y] = depth[x] + 1;
                    check[y] = true;
                    parent[y] = x;
                    q.add(y);
                }
            }
        }

        int m = sc.nextInt();

        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (depth[x] < depth[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            while (depth[x] != depth[y]) {
                x = parent[x];
            }
            while (x != y) {
                x = parent[x];
                y = parent[y];
            }
            System.out.println(x);
        }
    }
}

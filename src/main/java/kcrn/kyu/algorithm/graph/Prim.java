package kcrn.kyu.algorithm.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class EdgePrim {
    public int start;
    public int end;
    public int cost;

    public EdgePrim() {
        this(0,0,0);
    }

    public EdgePrim(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

public class Prim {

    static class Compare implements Comparator<EdgePrim> {
        public int compare(EdgePrim one, EdgePrim two) {
            return Integer.compare(one.cost, two.cost);
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<EdgePrim>[] a = (List<EdgePrim>[]) new List[n+1];

        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            a[u].add(new EdgePrim(u,v,c));
            a[v].add(new EdgePrim(v,u,c));
        }

        boolean[] c = new boolean[n+1];
        Compare cmp = new Compare();
        PriorityQueue<EdgePrim> q = new PriorityQueue<>(1, cmp);
        c[1] = true;

        for (EdgePrim e : a[1]) {
            q.add(e);
        }

        int ans = 0;
        for (int i=0; i<n-1; i++) {
            EdgePrim e = new EdgePrim();
            while (!q.isEmpty()) {
                e = q.poll();
                if (c[e.end] == false) {
                    break;
                }
            }
            c[e.end] = true;
            ans += e.cost;

            for (EdgePrim ee : a[e.end]) {
                q.add(ee);
            }
        }
        System.out.println(ans);
    }
}

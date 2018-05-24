package kcrn.kyu.algorithm.graph;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopologySort {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer>[] a = (List<Integer>[]) new List[n+1];

        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<>();
        }

        int[] ind = new int[n+1];

        for (int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x].add(y);
            ind[y] += 1;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i=1; i<=n; i++) {
            if (ind[i] == 0) {
                q.offer(i);
            }
        }

        for (int k=0; k<n; k++) {
            int x = q.poll();
            System.out.print(x + " ");
            for (int y : a[x]) {
                ind[y] -= 1;
                if (ind[y] == 0) {
                    q.offer(y);
                }
            }
        }
        System.out.println();
    }
}

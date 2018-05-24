package kcrn.kyu.algorithm.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponent {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        boolean[] check = new boolean[N + 1];

        for (int j = 1; j <= N; j++)
            list[j] = new ArrayList<Integer>();

        for (int i = 1; i <= M; i++) {
            int N1 = sc.nextInt();
            int N2 = sc.nextInt();
            list[N1].add(N2);
            list[N2].add(N1);
        }

        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();

        int cnt = 0;

        for (int j = 1; j <= N; j++) {
            if (!check[j]) {
                cnt++;
                ad.offer(j);
                check[j] = true;
                while (!ad.isEmpty()) {
                    int x = ad.poll();
                    for (int i = 0; i < list[x].size(); i++) {

                        int y = list[x].get(i);

                        if (!check[y]) {
                            check[y] = true;
                            ad.offer(y);
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}

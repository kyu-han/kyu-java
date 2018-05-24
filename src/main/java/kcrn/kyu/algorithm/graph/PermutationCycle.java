package kcrn.kyu.algorithm.graph;

import java.util.Scanner;

public class PermutationCycle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                arr[i] = sc.nextInt();
            }

            boolean[] check = new boolean[N + 1];
            int ans = 0;

            for (int i = 1; i <= N; i++) {
                if (!check[i]) {
                    dfs(arr, check, i);
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

    public static void dfs(int[] arr, boolean[] check, int num) {
        if (!check[num]) {
            check[num] = true;
            dfs(arr, check, arr[num]);
        }
    }
}
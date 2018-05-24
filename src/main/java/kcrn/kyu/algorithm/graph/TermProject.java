package kcrn.kyu.algorithm.graph;

import java.util.Scanner;

public class TermProject {

    static int a[];
    static int d[];
    static int s[];
    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            a = new int[100001];
            d = new int[100001];
            s = new int[100001];

            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
                d[i] = 0;
                s[i] = 0;
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (d[i] == 0) {
                    ans += dfs(i, 1, i);
                }
            }
            System.out.println(n - ans);
        }
    }

    public static int dfs(int x, int cnt, int step) {
        if (d[x] != 0) {
            if (step != s[x]) {
                return 0;
            }
            return cnt - d[x];
        }
        d[x] = cnt;
        s[x] = step;
        return dfs(a[x], cnt + 1, step);
    }
}

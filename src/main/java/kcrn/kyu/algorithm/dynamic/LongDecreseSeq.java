package kcrn.kyu.algorithm.dynamic;

import java.util.Scanner;

public class LongDecreseSeq {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int a[] = new int[N + 1];
        int d[] = new int[N + 1];

        for (int i = 1; i <= N; i++)
            a[i] = sc.nextInt();

        for (int i = N; i >= 1; i--) {
            d[i] = 1;
            for (int j = N; j > i; j--) {
                if (a[i] > a[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }

            }
        }

        int ans = d[N];

        for (int i = 1; i <= N; i++)
            if (d[i] > ans)
                ans = d[i];

        System.out.println(ans);

    }
}

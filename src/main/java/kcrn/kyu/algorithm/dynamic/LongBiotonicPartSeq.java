package kcrn.kyu.algorithm.dynamic;

import java.util.Scanner;

public class LongBiotonicPartSeq {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int a[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            a[i] = sc.nextInt();
        }

        int d[][] = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            d[i][0] = 1;
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j] && d[i][0] < d[j][0] + 1) {
                    d[i][0] = d[j][0] + 1;
                }
            }
        }

        for (int i = N; i >= 1; i--) {
            d[i][1] = 1;
            for (int j = N; j > i; j--) {
                if (a[i] > a[j] && d[i][1] < d[j][1] + 1) {
                    d[i][1] = d[j][1] + 1;
                }
            }
        }

        int ans = d[1][0] + d[1][1] - 1;

        for (int i = 2; i <= N; i++) {
            if (ans < d[i][0] + d[i][1]) {
                ans = d[i][0] + d[i][1] - 1;
            }
        }

        System.out.println(ans);

    }

}

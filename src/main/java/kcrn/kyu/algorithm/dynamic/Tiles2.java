package kcrn.kyu.algorithm.dynamic;

import java.util.Scanner;

public class Tiles2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d[] = new int[n+1];
        d[1] = 1;

        if (n >= 2) d[2] = 3;

        for(int i=3; i<=n; i++) d[i] = (d[i-2]*2) % 10007 + d[i-1] % 10007;

        System.out.println(d[n] % 10007);
        sc.close();
    }
}

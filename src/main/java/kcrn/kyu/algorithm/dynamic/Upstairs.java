package kcrn.kyu.algorithm.dynamic;

import java.util.Scanner;

public class Upstairs {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] d = new int[N+1][2];
        int[] a = new int[N+1];

        for(int i=1; i<=N; i++) a[i] = sc.nextInt();

        d[1][0] = d[1][1] = a[1];

        for(int i=2; i<=N; i++){
            d[i][0] = d[i-1][1] + a[i];
            d[i][1] = Math.max(d[i-2][1], d[i-2][0]) + a[i];
        }

        System.out.println(Math.max(d[N][0], d[N][1]));

        sc.close();
    }

}

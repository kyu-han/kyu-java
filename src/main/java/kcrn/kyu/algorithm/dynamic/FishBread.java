package kcrn.kyu.algorithm.dynamic;

import java.util.Scanner;

public class FishBread {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] p = new int[N+1];
        int[] d = new int[N+1];

        for(int i=1; i<=N; i++){
            p[i] = sc.nextInt();
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                d[i] = Math.max(d[i], d[i-j]+p[j]);
            }
        }

        System.out.println(d[N]);

    }

}

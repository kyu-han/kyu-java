package kcrn.kyu.algorithm.dynamic;

import java.util.Scanner;

public class EasyStairs {
    public static void main(String[] arg){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), mod = 1000000000;
        int d[][] = new int[N+1][10];

        for(int i=1; i<=9; i++) d[1][i] = 1;

        for(int i=2; i<=N; i++){
            for(int j=0; j<=9; j++){
                d[i][j] = 0;
                if(j-1 >= 0) d[i][j] += d[i-1][j-1];
                if(j+1 <= 9) d[i][j] += d[i-1][j+1];
                d[i][j] %= mod;
            }
        }

        long ans = 0;
        for(int i=0; i<=9; i++) ans += d[N][i];

        System.out.println(ans % mod);
    }
}

package kcrn.kyu.algorithm.dynamic;

import java.util.Scanner;

public class Ascending {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] d = new int[N+1][11];

        for(int i=0; i<=9; i++) d[1][i] = 1;

        for(int i=2; i<=N; i++){
            for(int j=0; j<=9; j++) {
                for(int k=j; k<=9; k++){
                    d[i][j] = (d[i][j] + d[i-1][k])%10007;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<=9; i++)	ans = (ans+d[N][i])%10007;

        System.out.println(ans%10007);
    }
}

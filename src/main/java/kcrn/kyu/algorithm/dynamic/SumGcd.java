package kcrn.kyu.algorithm.dynamic;

import java.util.Scanner;

public class SumGcd {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] c = new long[t+1];

        for(int i=1; i<=t; i++){
            int n = sc.nextInt();
            long d[] = new long[n+1];
            for(int j=1; j<=n; j++){
                d[j] = sc.nextInt();
            }

            for(int j=1; j<n; j++){
                for(int k=j+1; k<=n; k++){
                    c[i] += gcd(d[j], d[k]);
                }
            }
            System.out.println(c[i]);
        }

    }

    public static long gcd(long d, long d2){
        if(d2 == 0) return d;
        return gcd(d2, d % d2);
    }

}

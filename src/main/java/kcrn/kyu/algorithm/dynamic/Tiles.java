package kcrn.kyu.algorithm.dynamic;

import java.math.BigInteger;
import java.util.Scanner;

public class Tiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String d[] = new String[n+1];
        d[1] = "1";

        if (n >= 2) d[2] = "2";
        for(int i=3; i<=n; i++) d[i] = new BigInteger(d[i-2]).add(new BigInteger(d[i-1])).toString();

        System.out.println(new BigInteger(d[n]).mod(new BigInteger("10007")));
        sc.close();
    }
}

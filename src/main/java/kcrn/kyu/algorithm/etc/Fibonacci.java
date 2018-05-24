package kcrn.kyu.algorithm.etc;

import java.util.Scanner;

public class Fibonacci {

    static int[] memo;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int num = sc.nextInt();
            memo = new int[num + 1];
            fibonacci(num);
            System.out.println((num == 0 ? 1 : memo[num - 1]) + " " + memo[num]);
        }
        sc.close();
    }

    public static int fibonacci(int n) {
        if (n <= 1) return memo[n] = n;
        else {
            if (memo[n] > 0) return memo[n];
            return memo[n] = fibonacci(n - 2) + fibonacci(n - 1);
        }
    }

}

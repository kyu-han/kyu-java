package kcrn.kyu.algorithm.etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoldbachSpeculation2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        boolean check[] = new boolean[1000001];

        for (int i = 2; i <= 1000000; i++) {
            if (!check[i]) {
                list.add(i);
                for (int j = i * 2; j <= 1000000; j += i) {
                    check[j] = true;
                }
            }
        }

        int n = sc.nextInt();
        while (n != 0) {
            for (int i = 1; i < list.size(); i++) {
                if (!check[n - list.get(i)]) {
                    System.out.println(n + " = " + list.get(i) + " + " + (n - list.get(i)));
                    break;
                }
            }
            n = sc.nextInt();
            if (n == 0) break;
        }
    }
}

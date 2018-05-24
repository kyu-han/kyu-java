package kcrn.kyu.algorithm.etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Eratosthenes {

    public static void main(String[] args) {

        //long start = System.currentTimeMillis();
        List<Integer> list = Eratosthenes(1000);
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (list.contains(num)) {
                answer++;
            }
        }

        System.out.println(answer);
        //System.out.println("time : " + (System.currentTimeMillis() - start));
    }

    public static List<Integer> Eratosthenes(int max) {
        List<Integer> value = new ArrayList<>();
        int cnt = 2;

        while (cnt <= max) {
            value.add(cnt);
            cnt++;
        }

        for (int j = 2; j <= max; j++) {
            for (int i = max; i >= 0; i--) {
                if (i != j && i % j == 0) {
                    value.remove(new Integer(i));
                }
            }
        }
        return value;
    }

}

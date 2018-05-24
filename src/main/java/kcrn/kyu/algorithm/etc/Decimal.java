package kcrn.kyu.algorithm.etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decimal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstNum = sc.nextInt();
        int secondNum = sc.nextInt();

        int sum = 0;
        int first = 0;
        boolean once = true;

        List<Integer> list = new ArrayList<>();
        int n = 10000;
        boolean c[] = new boolean[n+1];

        for(int i=2; i<=n; i++) {
            if(!c[i]){
                list.add(i);
                for(int j = i*i; j<=n; j+=i ){
                    c[j] = true;
                }
            }
        }

        for(int i=0; i<list.size(); i++) {
            if(list.get(i) >= firstNum && list.get(i) <= secondNum) {
                if(once){
                    first = list.get(i);
                    once = false;
                }
                sum += list.get(i);
            }
        }

        if(first == 0)
            System.out.println("-1");
        else {
            System.out.println(sum);
            System.out.println(first);
        }
    }

}

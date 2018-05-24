package kcrn.kyu.algorithm.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decimal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstNo = sc.nextInt();
        int secondNo = sc.nextInt();
        int max = 1000000;
        boolean[] deleted = new boolean[max+1];
        List<Integer> list = new ArrayList<>();

        for(long i=2; i<=max; i++){
            if(!deleted[(int)i]){
                list.add((int)i);
                for(long j = i*i; j<=max; j+=i ){
                    deleted[(int)j] = true;
                }
            }
        }

        for(int n : list) if(n >= firstNo && n <= secondNo) System.out.println(n);

    }
}

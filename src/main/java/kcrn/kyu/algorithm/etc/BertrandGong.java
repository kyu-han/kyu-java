package kcrn.kyu.algorithm.etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BertrandGong {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int max = 123456*2;
        boolean[] deleted = new boolean[max+1];
        List<Integer> list = new ArrayList<>();
        List<Integer> insu = new ArrayList<>();

        for(long i=2; i<=max; i++){
            if(!deleted[(int)i]){
                list.add((int)i);
                for(long j = i*i; j<=max; j+=i ){
                    deleted[(int)j] = true;
                }
            }
        }

        while (true){
            int No = sc.nextInt();
            if(No == 0) break;
            insu.add(No);
        }

        for(long No : insu){
            int sum = 0;
            for(long n : list) if(n > No && n <= No*2) sum++;
            System.out.println(sum);
        }
    }

}

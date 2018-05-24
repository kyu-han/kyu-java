package kcrn.kyu.algorithm.dynamic;

import java.util.Scanner;

public class LongIncreasePartSeq {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] a = new int[N];
        int[] d = new int[N];

        for (int i=0; i<N; i++){
            a[i] = sc.nextInt();
        }

        for (int i=0; i<N; i++){
            d[i] = 1;
            for (int j=0; j<i; j++){
                if(a[j] < a[i] && d[i] < d[j]+1){
                    d[i] = d[j] + 1;
                }
            }
        }

        int ans = d[0];

        for (int i=0; i<N; i++){
            if(ans < d[i]) {
                ans = d[i];
            }
        }

        System.out.println(ans);
    }

}

package kcrn.kyu.algorithm.dynamic;

import java.util.Scanner;

public class IncreasePartSeq {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a[] = new int[N+1];

        for(int i=1; i<=N; i++){
            a[i] = sc.nextInt();
        }

        int d[] = new int[N+1];

        for(int i=1; i<=N; i++){
            d[i] = a[i];
            for(int j=1; j<i; j++){
                if(a[i] > a[j] && d[i] < a[i] + d[j]){
                    d[i] = a[i] + d[j];
                }
            }
        }

        int ans = d[1];

        for(int i=2; i<=N; i++) {
            if(ans < d[i]) ans = d[i];
        }

        System.out.println(ans);

    }

}

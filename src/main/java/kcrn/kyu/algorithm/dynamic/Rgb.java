package kcrn.kyu.algorithm.dynamic;

import java.io.IOException;
import java.util.Scanner;

public class Rgb {

    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[][] = new int[3][N];
        int r, g, b;

        arr[0][0] = sc.nextInt();
        arr[1][0] = sc.nextInt();
        arr[2][0] = sc.nextInt();


        for(int i = 1; i < N; i++ ){
            r = sc.nextInt();
            g = sc.nextInt();
            b = sc.nextInt();

            arr[0][i] = Math.min(arr[1][i-1], arr[2][i-1]) + r;
            arr[1][i] = Math.min(arr[0][i-1], arr[2][i-1]) + g;
            arr[2][i] = Math.min(arr[0][i-1], arr[1][i-1]) + b;
        }
        System.out.println(Math.min(arr[0][N-1], Math.min(arr[1][N-1], arr[2][N-1])));

    }

}

package kcrn.kyu.algorithm.etc;

import java.math.BigInteger;
import java.util.Scanner;

public class Transposition {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a == 0 & b == 0) break;
            int c = a-b;

            BigInteger sumA = new BigInteger("1");
            BigInteger sumB = new BigInteger("1");
            BigInteger sumC = new BigInteger("1");

            if(c > b) {
                for(int i=c+1; i<=a; i++) sumA = sumA.multiply(new BigInteger(i+""));
                for(int i=1; i<=b; i++) sumB = sumB.multiply(new BigInteger(i+""));
                System.out.println(sumA.divide((sumB)));
            } else {
                for(int i=b+1; i<=a; i++) sumA = sumA.multiply(new BigInteger(i+""));
                for(int i=1; i<=c; i++) sumC = sumC.multiply(new BigInteger(i+""));
                System.out.println(sumA.divide((sumC)));
            }
        }
    }
}

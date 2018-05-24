package kcrn.kyu.algorithm.etc;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PrinterQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int tc = 0; tc < testCase; tc++) {

            int totSize = sc.nextInt();
            int printThisPosition = sc.nextInt();
            // 개행 문자 버림
            sc.nextLine();

            int cntPrint = 0;
            ArrayDeque<Integer> ad = new ArrayDeque<>();
            ArrayDeque<Boolean> chkAd = new ArrayDeque<>();

            for (int size = 0; size < totSize; size++) {
                if (size == printThisPosition) chkAd.offer(true);
                else chkAd.offer(false);
            }

            StringTokenizer st = new StringTokenizer(sc.nextLine());
            while (st.hasMoreTokens()) ad.offer(Integer.parseInt(st.nextToken(" ")));

            while (!ad.isEmpty()) {
                int chkPriority = ad.poll();
                boolean boolPriority = chkAd.poll();
                Iterator<Integer> it = ad.iterator();
                int sameNoCnt = 0;

                while (it.hasNext()) if (chkPriority >= it.next()) sameNoCnt++;

                if (sameNoCnt != ad.size()) {
                    ad.offer(chkPriority);
                    chkAd.offer(boolPriority);
                } else {
                    cntPrint++;
                    if (boolPriority) {
                        System.out.println(cntPrint);
                        break;
                    }
                }
            }
        }
    }
}

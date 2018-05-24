package kcrn.kyu.algorithm.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSum {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a[] = new int[n + 1];
        int d[] = new int[n + 1];
        int cnt = 1;

        while (st.hasMoreTokens())
            a[cnt++] = Integer.parseInt(st.nextToken(" "));

        d[1] = a[1];

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + a[i];
            if (d[i] < a[i])
                d[i] = a[i];
        }

        int ans = d[1];

        for (int i = 2; i <= n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }

        System.out.println(ans);
    }

}

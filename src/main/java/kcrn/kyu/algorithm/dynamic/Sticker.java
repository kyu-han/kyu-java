package kcrn.kyu.algorithm.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int d[][] = new int[n+1][3];
            int a[][] = new int[n+1][3];

            for(int i=0; i<2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int cnt = 1;
                while(st.hasMoreTokens()){
                    a[cnt++][i] = Integer.parseInt(st.nextToken(" "));
                }
            }

            for (int i=1; i<=n; i++) {
                d[i][0] = Math.max(d[i-1][0],Math.max(d[i-1][1],d[i-1][2]));
                d[i][1] = Math.max(d[i-1][0],d[i-1][2])+a[i][0];
                d[i][2] = Math.max(d[i-1][0],d[i-1][1])+a[i][1];
            }

            int ans = 0;
            ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
            System.out.println(ans);
        }
    }
}
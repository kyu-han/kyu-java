package kcrn.kyu.algorithm.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Histogram {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            int[] arr = new int[n];
            int cnt = 0;

            while (st.hasMoreTokens()) {
                arr[cnt++] = Integer.parseInt(st.nextToken());
            }

            ArrayDeque<Integer> ad = new ArrayDeque<>();

            int start = 0;
            int end = 0;
            long max = 0;

            for (int i = 0; i < arr.length; i++) {
                ad.push(i);
                if (i == arr.length - 1 || arr[i] > arr[i + 1]) {
                    while (!ad.isEmpty()) {
                        int temp = ad.pop();
                        if (i < arr.length - 1 && arr[temp] <= arr[i + 1]) {
                            ad.push(temp);
                            break;
                        }

                        if (temp == 0)
                            start = temp;
                        else {
                            int tempBack = temp - 1;
                            while (arr[temp] <= arr[tempBack]) {
                                tempBack--;
                                if (tempBack == -1)
                                    break;
                            }
                            start = tempBack + 1;
                        }
                        end = i;

                        if (max < (long) (end - start + 1) * arr[temp]) {
                            max = (long) (end - start + 1) * arr[temp];
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }
}

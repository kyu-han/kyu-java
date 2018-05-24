package kcrn.kyu.algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class FindMinValue {

    static class FMVSW {

        int val;
        int index;

        FMVSW(int val, int index) {
            this.val = val;
            this.index = index;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] a = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Deque<FMVSW> dq = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            if(!dq.isEmpty() && dq.getFirst().index <= i-L) {
                dq.removeFirst();
            }

            while(!dq.isEmpty() && dq.getLast().val > a[i]) {
                dq.removeLast();
            }

            dq.addLast(new FMVSW(a[i], i));
            sb.append(dq.getFirst().val+" ");
        }
        System.out.println(sb);
    }
}

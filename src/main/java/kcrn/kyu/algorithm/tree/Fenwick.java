package kcrn.kyu.algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Fenwick {
    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        tree = new long[N+1];
        int[][] q = new int[N+1][2];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            update(i, 1);
            q[i][0] = Integer.parseInt(st.nextToken());
            q[i][1] = i;
        }

        Arrays.sort(q,  new Comparator<int[]>() {
            public int compare(int[] arg0, int[] arg1) {
                return arg0[0] - arg1[0];
            }
        });

        long v = 0;
        long[] ans = new long[N+1];

        for(int i=1; i<=N; i++){
            int idx = q[i][1];
            long res = query(1, idx)*q[i][0] + query(idx+1, N)*(q[i][0]-1) + v;

            v += q[i][0];
            update(idx, -1);
            ans[idx] = res;
        }

        for (int i = 1; i <= N; i++){
            System.out.println(ans[i]);
        }
    }

    public static void update (int node, int diff){
        while (node < tree.length)
        {
            tree[node] += diff;
            node += (node & -node);
        }
    }

    public static long query (int start, int end){
        return query(end) - query(start-1);
    }

    public static long query (int node){
        int ans = 0;
        if(node < tree.length){
            while (node > 0)
            {
                ans += tree[node];
                node -= (node & -node); // 최하위 비트 지우기
            }
        }
        return ans;
    }
}

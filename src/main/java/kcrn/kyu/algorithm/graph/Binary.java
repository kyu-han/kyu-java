package kcrn.kyu.algorithm.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Binary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        for (int i = 1; i <= K; i++) {

            int V = sc.nextInt();
            int E = sc.nextInt();

            ArrayList<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[V + 1];

            for (int j = 1; j <= V; j++)
                list[j] = new ArrayList<>();

            for (int j = 1; j <= E; j++) {
                int V1 = sc.nextInt();
                int V2 = sc.nextInt();
                list[V1].add(V2);
                list[V2].add(V1);
            }

            int[] check = new int[V + 1];
            String ans = "YES";

            for (int j=1; j<=V; j++) {
                if (check[j] == 0) {
                    dfs(list, check, j, 1);
                }
            }

            for (int j=1; j<=V; j++) {
                for (int k : list[j]) {
                    if(check[j] == check[k]){
                        ans = "NO";
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static void dfs(ArrayList<Integer>[] list, int[] check, int V, int c) {
        check[V] = c;

        for(int y : list[V]){
            if(check[y] == 0)
                dfs(list, check, y, 3-c);
        }
    }
}

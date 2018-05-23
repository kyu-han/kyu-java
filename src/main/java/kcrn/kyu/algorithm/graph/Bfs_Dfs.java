package kcrn.kyu.algorithm.graph;

/*
4 5 1
1 2
1 3
1 4
2 4
3 4

5 5 4
1 2
1 3
1 4
2 5
4 5

*/

import java.util.Arrays;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Bfs_Dfs {

    static int N;
    static boolean[] visited;
    static boolean[][] edge;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        visited = new boolean[N+1];
        edge = new boolean[N+1][N+1];

        for(int i=1; i<=M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            edge[v1][v2] = edge[v2][v1] = true;
        }

        dfs(V);

        System.out.println();

        Arrays.fill(visited, false);

        bfs(V);


    }

    public static void dfs(int cur) {

        visited[cur] = true;
        System.out.print(String.valueOf(cur)+ " ");

        for(int i=1; i<=N; i++) {
            if(visited[i] || !edge[i][cur]) continue;
            dfs(i);
        }

    }

    public static void bfs(int cur) {

        Queue<Integer> que = new LinkedList();

        visited[cur] = true;
        que.add(cur);

        while(!que.isEmpty()) {

            int here = que.remove();
            System.out.print(String.valueOf(here+" "));

            for(int i=1; i<=N; i++) {
                if(visited[i] || !edge[i][here]) continue;
                visited[i] = true;
                que.add(i);
            }

        }

    }

}

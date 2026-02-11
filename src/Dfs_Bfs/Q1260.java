package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {

    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 정점 수
        int M = Integer.parseInt(st.nextToken());  // 간선 수
        int V = Integer.parseInt(st.nextToken());  // 시작 점

        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());

            graph[row][column] = graph[column][row] = 1;
        }

        visited = new boolean[N + 1];
        DFS(V);

        System.out.println();

        visited = new boolean[N + 1];
        BFS(V);

    }

    public static void DFS(int v) {

        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 1; i < graph.length; i ++) {
            if (graph[v][i] == 1 && !visited[i])
                DFS(i);
        }

    }

    public static void BFS(int v) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        System.out.print(v + " ");

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            for (int i = 1; i < graph.length; i ++) {
                if (graph[tmp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }

    }
}

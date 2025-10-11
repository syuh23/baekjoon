package Dynamic_Programming;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        int n = 10, infection = 1, k = 2;
        int[][] edges = {
                {1,2,1},{1,3,1},{1,4,3},{1,5,2},{5,6,1},{5,7,1},{2,9,2},{9,10,1},{2,8,3}
        };

        ArrayList<Integer>[][] edgeTypeNode = new ArrayList[3][n + 1];
        for (int a = 0; a < 3; a++) {
            for (int b = 1; b <= n; b++) edgeTypeNode[a][b] = new ArrayList<>();
        }
        for (int a = 0; a < edges.length; a++) {
            int x = edges[a][0], y = edges[a][1], t = edges[a][2] - 1;
            edgeTypeNode[t][x].add(y);
            edgeTypeNode[t][y].add(x);
        }

        int[][] componentId = new int[3][n + 1];
        ArrayList<int[]>[] components = new ArrayList[3];

        for (int a = 0; a < 3; a++) {
            components[a] = new ArrayList<>();
            boolean[] visited = new boolean[n + 1];
            int[] stack = new int[n];

            int cid = 0;
            for (int b = 1; b <= n; b++) {
                if (visited[b]) continue;

                int sp = 0, used = 0;
                int[] buf = new int[n];

                visited[b] = true; stack[sp++] = b;
                while (sp > 0) {
                    int u = stack[--sp];
                    buf[used++] = u;
                    componentId[a][u] = cid + 1;

                    for (int c = 0; c < edgeTypeNode[a][u].size(); c++) {
                        int v = edgeTypeNode[a][u].get(c);
                        if (!visited[v]) { visited[v] = true; stack[sp++] = v; }
                    }
                }
                components[a].add(Arrays.copyOf(buf, used));
                cid++;
            }
        }

        int totalOrders = 1;
        for (int a = 0; a < k; a++) totalOrders *= 3;

        int best = 0;
        for (int a = 0; a < totalOrders; a++) {
            boolean[] infected = new boolean[n + 1];
            infected[infection] = true;

            int code = a;
            for (int b = 0; b < k; b++) {
                int type = code % 3;
                code /= 3;

                int compCount = components[type].size();
                boolean[] hit = new boolean[compCount + 1];

                for (int c = 1; c <= n; c++) {
                    if (!infected[c]) continue;
                    int id = componentId[type][c];
                    if (id > 0) hit[id] = true;
                }

                for (int c = 1; c <= compCount; c++) {
                    if (!hit[c]) continue;
                    int[] group = components[type].get(c - 1);
                    for (int d = 0; d < group.length; d++) infected[group[d]] = true;
                }
            }

            int count = 0;
            for (int b = 1; b <= n; b++) if (infected[b]) count++;
            if (count > best) best = count;
        }

        System.out.println(best);
    }
}

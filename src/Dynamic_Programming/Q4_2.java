package Dynamic_Programming;

import java.util.*;

// 4번 정답

class Q4_2 {
    public static void main(String[] args) {
        int n = 7;
        int infection = 6;
        int[][] edges = {
                {1,2,3},{1,4,3},{4,5,1},{5,6,1},{3,6,2},{3,7,2}
        };
        int k = 3;

        // 1. 타입별로 그래프 구성
        ArrayList<Integer>[][] graph = new ArrayList[3][n + 1];
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], type = edge[2] - 1;
            graph[type][x].add(y);
            graph[type][y].add(x);
        }


        // 2. 각 타입별로 연결 그룹 계산
        int[][] groupNum = new int[3][n + 1];
        ArrayList<int[]>[] groups = new ArrayList[3];

        for (int t = 0; t < 3; t++) {
            groups[t] = new ArrayList<>();
            boolean[] visit = new boolean[n + 1];
            int[] stk = new int[n];
            int gid = 0;

            for (int root = 1; root <= n; root++) {
                if (visit[root]) continue;

                int top = 0, cnt = 0;
                int[] temp = new int[n];

                visit[root] = true;
                stk[top++] = root;

                while (top > 0) {
                    int cur = stk[--top];
                    temp[cnt++] = cur;
                    groupNum[t][cur] = gid + 1;

                    for (int nxt : graph[t][cur]) {
                        if (!visit[nxt]) {
                            visit[nxt] = true;
                            stk[top++] = nxt;
                        }
                    }
                }

                groups[t].add(Arrays.copyOf(temp, cnt));
                gid++;
            }
        }

        // 3. 모든 3^k 가지 순서 완전탐색
        int total = 1;
        for (int i = 0; i < k; i++) total *= 3;

        int answer = 0;

        for (int seq = 0; seq < total; seq++) {
            boolean[] virus = new boolean[n + 1];
            virus[infection] = true;

            int val = seq;
            for (int round = 0; round < k; round++) {
                int t = val % 3;
                val /= 3;

                // 현재 감염된 노드가 속한 그룹 찾기
                int groupCnt = groups[t].size();
                boolean[] selected = new boolean[groupCnt + 1];

                for (int v = 1; v <= n; v++) {
                    if (virus[v]) {
                        int gid = groupNum[t][v];
                        if (gid > 0) selected[gid] = true;
                    }
                }

                // 해당 그룹 전체 감염
                for (int gid = 1; gid <= groupCnt; gid++) {
                    if (selected[gid]) {
                        int[] members = groups[t].get(gid - 1);
                        for (int v : members) {
                            virus[v] = true;
                        }
                    }
                }
            }

            // 감염된 노드 수 카운트
            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (virus[i]) result++;
            }
            answer = Math.max(answer, result);
        }

        System.out.println(answer);
    }
}

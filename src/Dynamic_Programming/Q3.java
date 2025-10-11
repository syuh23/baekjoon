package Dynamic_Programming;

public class Q3 {
    static int dist_limit = 3;
    static int split_limit = 100;
    static int maxLeaves = 0;

    public static void main(String[] args) {
        dfs(0, 1, 1, 0);
        System.out.println(maxLeaves);
    }

    static void dfs(int distribCnt, int split, int nodes, int leafCnt) {
        // distribCnt : 현재까지 분배노드 총 개수
        // currentSplit : 분배도
        // currentLevelNodes : 이번 레벨에 존재하는 노드 수
        // leafCnt : 누적 리프노드 수

        if (nodes == 0) {
            maxLeaves = Math.max(maxLeaves, leafCnt);
            return;
        }

        int remainingDistrib = dist_limit - distribCnt;
        int maxDistribThisLevel = Math.min(nodes, remainingDistrib);

        for (int distribNodesThisLevel = 0; distribNodesThisLevel <= maxDistribThisLevel; distribNodesThisLevel++) {
            int leafNodesThisLevel = nodes - distribNodesThisLevel;

            if (distribNodesThisLevel == 0) {
                maxLeaves = Math.max(maxLeaves, leafCnt + leafNodesThisLevel);
                continue;
            }

            for (int child = 2; child <= 3; child++) {
                long nextSplit = (long) split * child;
                if (nextSplit > split_limit) continue;

                dfs(distribCnt + distribNodesThisLevel,
                        (int) nextSplit,
                        distribNodesThisLevel * child,
                        leafCnt + leafNodesThisLevel);
            }
        }
    }
}

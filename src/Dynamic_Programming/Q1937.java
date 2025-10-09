package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1937 {

    static int N;
    static int[][] bamboo;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        bamboo = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                bamboo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dfs(i, j);
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }

    static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];
        dp[x][y] = 1;

        for (int i = 0; i < 4; i++ ) {
            int fx = x + dx[i];
            int fy = y + dy[i];

            if (fx <= 0 || fx > N || fy <= 0 || fy > N) continue;

            if (bamboo[x][y] < bamboo[fx][fy]) {
                dp[x][y] = Math.max(dp[x][y], dfs(fx, fy) + 1);  // 여기서 틀림... 난 그냥 dfs(fx, fy) + dp[x][y]를 적음 ㅠㅠ
            }
        }

        return dp[x][y];
    }
}

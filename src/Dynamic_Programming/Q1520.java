package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1520 {

    static int N, M;
    static int[][] map, dp;
    static int[] dx = {-1, 1, 0,  0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(1, 1));
    }

    static int dfs(int x, int y) {

        // 마지막 행열에 닿으면 1 Return
        if (x == N && y == M) return 1;

        // -1이 아니라는 것은 방문을 했다는 뜻이니까 그대로 dp 값 반환
        if (dp[x][y] != -1) return dp[x][y];

        // 방문했다는 의미로 0으로 초기화
        dp[x][y] = 0;
        for (int k = 0; k < 4; k++) {

            // 이동된 좌표 fx, fy
            int fx = x + dx[k], fy = y + dy[k];

            // 예외처리, 이런 경우엔 그냥 넘어감
            if (fx <= 0 || fx > N || fy <= 0 || fy > M) continue;

            // 현재 좌표의 값이 이동한 좌표의 값보다 더 크면 이동한 곳을 현재 좌표로 설정하여 dfs 메소드 실행
            if (map[x][y] > map[fx][fy]) {
                dp[x][y] += dfs(fx, fy);
            }
        }

        return dp[x][y];
    }
}

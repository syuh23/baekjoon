package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1932 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] triangle = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        triangle[1][1] = Integer.parseInt(st.nextToken());
        dp[1][1] = triangle[1][1];

        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());

                if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
                else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[n][i]);
        }

        System.out.println(max);
    }
}

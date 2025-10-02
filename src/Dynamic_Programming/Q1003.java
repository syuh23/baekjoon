package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int[][] dp = new int[41][41];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            for (int j = 2; j <= N; j++) {
                dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
                dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
            }

            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }
}

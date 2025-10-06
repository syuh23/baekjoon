package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] dp = new int [N + 1][10];
        int sum = 0;

        for (int i = 0; i <= 9; i ++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j ++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % 1000000000;
                }
                else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % 1000000000;
                }
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        for (int i = 1; i <= 9; i ++) {
            sum = (sum + dp[N][i]) % 1000000000;
        }
        System.out.println(sum);

//        int[] dp = new int[N + 1];
//        dp[1] = 9;
//
//        for (int i = 2; i <= N; i++) {
//            dp[i] = dp[i - 1] * 2 - (i - 1);
//            dp[i] = dp[i] % 1000000000;
//        }
//
//        System.out.println(dp[N]);
    }
}

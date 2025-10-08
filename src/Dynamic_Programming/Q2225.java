package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= K; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            dp[i][1] = 1;
            for (int j = 2; j <= K; j++) {
                int sum = 0;
                for (int a = 0; a <= i; a++) {
                    sum = (sum + dp[a][j - 1]) % 1000000000;
                }
                dp[i][j] = sum % 1000000000;
            }
        }

        System.out.println(dp[N][K] % 1000000000);
    }
}

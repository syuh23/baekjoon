package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[][] dp = new int[31][31];

        for (int repeat = 0; repeat < T; repeat++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= M; i++) {
                dp[i][0] = 1;
                dp[i][i] = 1;
            }

            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }

            System.out.println(dp[M][N]);

//            long mulM = 1, mulN = 1;
//            for (int i = 1; i <= N; i++) {
//                mulN *= i;
//                mulM *= (M - i + 1);
//            }
//
//            long result = mulM / mulN;
//            System.out.println(result);
        }
    }

}

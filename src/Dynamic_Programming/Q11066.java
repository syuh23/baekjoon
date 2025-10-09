package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11066 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] numbers = new int [N + 1];
            int[] sum = new int[N + 1];
            int[][] dp = new int[N + 1][N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + numbers[i];
            }

            for (int gap = 1; gap <= N; gap++) {
                for (int from = 1; from + gap <= N; from++) {
                    int to = from + gap;
                    dp[from][to] = Integer.MAX_VALUE;

                    for (int middle = from; middle < to; middle++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][middle] + dp[middle + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }

            System.out.println(dp[1][N]);
        }
    }
}

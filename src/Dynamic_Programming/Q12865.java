package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] wv = new int[2][N + 1]; // 1행 : 무게, 2행 : 가치
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            wv[0][i] = Integer.parseInt(st.nextToken());  // 무게
            wv[1][i] = Integer.parseInt(st.nextToken());  // 가치
        }

        for (int i = 1; i <= N; i++) {
            int w = wv[0][i];
            for (int j = 1; j <= K; j++) {
                if (w > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + wv[1][i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}

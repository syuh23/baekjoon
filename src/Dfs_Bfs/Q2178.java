package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i ++) {  // 현재
            int max = 0;

            for (int j = 1; j < i; j ++) {  // 과거
                if (arr[j] >= arr[i]) continue;
                if (max < dp[j]) {
                    max = dp[j];
                }
            }

            dp[i] = max + arr[i];
        }

        int result = 0;
        for (int i = 1; i <= N; i ++) {
            if (result < dp[i]) {
                result = dp[i];
            }
        }

        System.out.println(result);
    }
}

package Dynamic_Programming;

import java.io.*;
import java.util.StringTokenizer;

public class Q14002 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N + 1];
        int[] dp = new int[N + 1];
        int[] result = new int[N + 1];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }
        bw.write(max + "\n");

        for (int i = N; i > 0; i--) {
            if (dp[i] == max) {
                result[i] = i;
                max--;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] != 0) {
                bw.write(numbers[result[i]] + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

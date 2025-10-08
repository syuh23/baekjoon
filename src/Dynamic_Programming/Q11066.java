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

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] numbers = new int [N + 1];
            int[][] dp = new int[N + 1][N + 1];

            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                numbers[j] = Integer.parseInt(st.nextToken());
            }

            int min = Integer.MAX_VALUE - 1;
            for (int j = 1; j <= N; j++) {
                for (int k = j + 1; k <= N; k++) {
                    min = Math.min(min, numbers[j] + numbers[k]);

                }
            }

        }
    }
}

package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] price = new int[n + 1];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        sum[1] = price[1];
        for (int i = 2; i <= n; i++) {
            int max = price[i];
            for (int j = i - 1; j >= i / 2; j--) {
                max = Math.max(max, sum[i - j] + sum[j]);
            }
            sum[i] = max;
        }

        System.out.println(sum[n]);
    }
}

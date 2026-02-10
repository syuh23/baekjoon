package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N + 1];  // 1 ~ N번 까지
        int result = 0;

        for (int i = 1; i <= N; i ++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N; i > 0; i --) {
            int a = K / coins[i];
            result += a;
            K -= a * coins[i];
        }

        System.out.println(result);
    }
}

package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] numbers = new int [N + 1];
        int[] inc = new int [N + 1];
        int[] dec = new int [N + 1];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        inc[1] = 1;
        for (int i = 2; i <= N; i++) {
            inc[i] = 1;
            for (int j = 1; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        dec[N] = 1;
        for (int i = N - 1; i >= 1; i--) {
            dec[i] = 1;
            for (int j = i + 1; j <= N; j++) {
                if (numbers[i] > numbers[j]) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            result = Math.max(result, inc[i] + dec[i] - 1);
        }
        System.out.println(result);
    }
}

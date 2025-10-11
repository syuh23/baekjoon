package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11444 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        int[] fibonacci = new int[1000000000 + 1];
        int qu = (int) (n / 1000000000);
        int re = (int) (n % 1000000000);

        fibonacci[1] = 1;
        for (int i = 1; i <= qu; i ++) {
            for (int j = 1; j <= 1000000000; j ++) {
                if (i == 1 && j == 1) continue;

                if (j == 1) {
                    fibonacci[j] = (fibonacci[1000000000] + fibonacci[999999999]) % 1000000007;
                }
                else if (j == 2) {
                    fibonacci[j] = (fibonacci[1] + fibonacci[1000000000]) % 1000000007;
                }
                else {
                    fibonacci[j] = (fibonacci[j - 1] + fibonacci[j - 2]) % 1000000007;
                }
            }
        }
        for (int i = 1; i <= re; i ++) {
            if (qu == 0 && i == 1) continue;

            if (i == 1) {
                fibonacci[i] = (fibonacci[1000000000] + fibonacci[999999999]) % 1000000007;
            }
            else if (i == 2) {
                fibonacci[i] = (fibonacci[1] + fibonacci[1000000000]) % 1000000007;
            }
            else {
                fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1000000007;
            }
        }

        if (re == 0) {
            System.out.println(fibonacci[1000000000] % 1000000007);
        }
        else {
            System.out.println(fibonacci[re] % 1000000007);
        }
    }
}

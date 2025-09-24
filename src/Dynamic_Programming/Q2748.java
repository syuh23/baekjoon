package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        if (number <= 0 || number > 90) {
            System.out.println("다시 입력");
            return;
        }

        // 맹점
        // n이 90까지 가능했기 때문에 피보나치 수를 구하려면 int 의 범위를 넘어선다.
        // 즉, long 으로 배열을 만들어야 정답.
        long[] fibonacci = new long[number + 1];

        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i <= number; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        System.out.println(fibonacci[number]);
    }
}

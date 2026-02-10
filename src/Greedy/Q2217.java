package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2217 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] rope = new int[N];
        int max = 0;

        for (int i = 0; i < N; i ++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);

        for (int i = 0; i < N; i ++) {
            max = Math.max(max, rope[i] * (N - i));
        }

        System.out.println(max);
    }
}

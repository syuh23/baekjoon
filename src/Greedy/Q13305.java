package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] distance = new int[N]; // 1 ~ N-1
        int[] city = new int[N + 1]; //1 ~ N
        //city[0] = 1000000001;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i ++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i ++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        long cost = 0;
        int min = 1000000000;
        for (int i = 1; i < N; i ++) {
            if (min < city[i]) {
                cost += (long) min * distance[i];
            }
            else {
                cost += (long) city[i] * distance[i];
                min = city[i];
            }
        }

        System.out.println(cost);
    }
}

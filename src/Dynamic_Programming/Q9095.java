package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q9095 {

    private static ArrayList<List<Integer>> findNumCombinations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // 0 < N < 11 (정수)
        firstThree(n);

    }

    private static void firstThree(int n) {
        int repeat = 0;
        int start = n - 3;



    }

    private static int minusThree(int start) {
        return start - 3;
    }

}

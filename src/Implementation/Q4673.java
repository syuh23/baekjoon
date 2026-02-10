package Implementation;

public class Q4673 {

    public static void main(String[] args) {

        boolean[] check = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            int n = d(i);

            if (n < 10001)
                check[n] = true;
        }

        for (int i = 1; i < 10001; i ++) {
            if (!check[i])
                System.out.println(i);
        }
    }

    // 이렇게 간단하게...
    public static int d(int number) {
        int sum = number;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}

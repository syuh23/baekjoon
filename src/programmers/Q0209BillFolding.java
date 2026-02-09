package programmers;

public class Q0209BillFolding {
    // 가로 세로 상관 X
    // 긴 쪽을 접음
    // 소수점 이하 버림
    // 최소 접는 횟수
    public static void main(String[] args) {
        int[] wallet = {50, 50};
        int[] bill = {100, 241};
        int answer = 0;

        // wallet과 bill의 크기를 비교
        // wallet의 작, bill의 작 비교 -> bill이 더 작기
        // wallet의 큰, bill의 큰 비교 -> bill이 더 작기

        while (compareSize(wallet, bill)) {
            // bill [0], [1]을 비교하여 더 큰 쪽을 반으로 접기 (소숫점 버림)
            if (bill[0] >= bill[1]) {
                bill[0] /= 2;
            }
            else {
                bill[1] /= 2;
            }

            answer ++;
        }

        System.out.println(answer);
    }

    public static boolean compareSize(int[] wallet, int[] bill) {
        if (Math.max(wallet[0], wallet[1]) >= Math.max(bill[0], bill[1])
                && Math.min(wallet[0], wallet[1]) >= Math.min(bill[0], bill[1]))
            return false;
        else
            return true;
    }
}
